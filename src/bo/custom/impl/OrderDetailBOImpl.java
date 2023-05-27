package bo.custom.impl;

import bo.custom.OrderDetailBO;
import dao.DAOFactory;
import dao.custom.OrderDetailsDAO;
import model.OrderDetailDTO;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailBOImpl implements OrderDetailBO {
    //OrderDetailsDAO orderDetailsDAO = new OrderDetailsDAOImpl();

    //with Factory Design Pattern
    OrderDetailsDAO orderDetailsDAO = (OrderDetailsDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER_DETAILS);

    @Override
    public ArrayList<OrderDetailDTO> getAllOrderDetail() {
        return null;
    }

    @Override
    public boolean addOrderDetail(OrderDetailDTO dto) throws SQLException, ClassNotFoundException {
        return orderDetailsDAO.add(dto);
    }

    @Override
    public boolean updateOrderDetail(OrderDetailDTO dto) throws SQLException, ClassNotFoundException {
        return orderDetailsDAO.update(dto);
    }

    @Override
    public boolean existOrderDetail(String id) throws SQLException, ClassNotFoundException {
        return orderDetailsDAO.exist(id);
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return orderDetailsDAO.generateNewID();
    }

    @Override
    public boolean deleteOrderDetail(String id) throws SQLException, ClassNotFoundException {
        return orderDetailsDAO.delete(id);
    }

    @Override
    public OrderDetailDTO searchOrderDetail(String id) throws SQLException, ClassNotFoundException {
        return orderDetailsDAO.search(id);
    }
}