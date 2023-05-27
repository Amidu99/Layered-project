package bo.custom.impl;

import bo.custom.OrderBO;
import dao.custom.OrderDAO;
import dao.custom.impl.OrderDAOImpl;
import model.OrderDTO;
import java.sql.SQLException;

public class OrderBOImpl implements OrderBO {
    OrderDAO orderDAO = new OrderDAOImpl();

    @Override
    public boolean addOrder(OrderDTO dto) throws SQLException, ClassNotFoundException {
        return orderDAO.add(dto);
    }

    @Override
    public boolean existOrder(String id) throws SQLException, ClassNotFoundException {
        return orderDAO.exist(id);
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return orderDAO.generateNewID();
    }
}