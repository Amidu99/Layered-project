package bo.custom.impl;

import bo.custom.*;
import db.DBConnection;
import model.CustomerDTO;
import model.ItemDTO;
import model.OrderDTO;
import model.OrderDetailDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PlaceOrderBOImpl implements PlaceOrderBO {
    OrderBO orderBO = new OrderBOImpl();
    OrderDetailBO orderDetailBO = new OrderDetailBOImpl();
    ItemBO itemBO = new ItemBOImpl();
    CustomerBO customerBO = new CustomerBOImpl();

    @Override
    public boolean saveOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) {
        /*Transaction*/
        Connection connection;
        try {
            connection = DBConnection.getDbConnection().getConnection();

            //Check order id already exist or not

            boolean b1 = orderBO.existOrder(orderId);
            /*if order id already exist*/
            if (b1) {
                return false;
            }

            connection.setAutoCommit(false);

            //Save the Order to the order table
            boolean b2 = orderBO.addOrder(new OrderDTO(orderId, orderDate, customerId));

            if (!b2) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }

            // add data to the Order Details table

            for (OrderDetailDTO detail : orderDetails) {
                boolean b3 = orderDetailBO.addOrderDetail(detail);
                if (!b3) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }

                //Search & Update Item
                ItemDTO item = findItem(detail.getItemCode());
                item.setQtyOnHand(item.getQtyOnHand() - detail.getQty());

                //update item
                boolean b = itemBO.updateItem(new ItemDTO(item.getCode(), item.getDescription(), item.getUnitPrice(), item.getQtyOnHand()));

                if (!b) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }
            }

            connection.commit();
            connection.setAutoCommit(true);
            return true;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public ItemDTO findItem(String code) {
        try {
            return itemBO.searchItem(code);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to find the Item " + code, e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public CustomerDTO search(String id) throws SQLException, ClassNotFoundException {
        return customerBO.searchCustomer(id);
    }

    @Override
    public ItemDTO searchItem(String code) throws SQLException, ClassNotFoundException {
        return itemBO.searchItem(code);
    }

    @Override
    public boolean existItem(String code) throws SQLException, ClassNotFoundException {
        return itemBO.existItem(code);
    }

    @Override
    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerBO.existCustomer(id);
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return orderBO.generateNewID();
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
        return customerBO.getAllCustomer();
    }

    @Override
    public ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException {
        return itemBO.getAllItem();
    }
}