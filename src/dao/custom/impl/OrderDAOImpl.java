package dao.custom.impl;


import dao.SQLUtil;
import dao.custom.OrderDAO;
import entity.Order;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDAOImpl implements OrderDAO {

    @Override
    public ArrayList<Order> getAll() {
        return null;
    }

    @Override
    public boolean add(Order order) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO orders (oid, date, customerID, customerName, orderTotal) VALUES (?,?,?,?,?)",order.getOrderId(),Date.valueOf(order.getOrderDate()),order.getCustomerId(),order.getCustomerName(),order.getOrderTotal());
    }

    @Override
    public boolean update(Order dto) {
        return false;
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT oid FROM orders WHERE oid=?",id);
        return rst.next();
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT oid FROM orders ORDER BY oid DESC LIMIT 1;");
        return rst.next() ? String.format("OID-%03d", (Integer.parseInt(rst.getString("oid").replace("OID-", "")) + 1)) : "OID-001";
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public entity.Order search(String oid) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM orders WHERE oid=?";
        ResultSet rst = SQLUtil.execute(sql);
        rst.next();
        return new Order(oid, rst.getString("date"), rst.getString("customerId"), rst.getString("customerName"), rst.getBigDecimal("orderTotal"));
    }

    @Override
    public void specialMethod() {

    }
}