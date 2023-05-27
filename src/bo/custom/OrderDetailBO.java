package bo.custom;

import bo.SuperBO;
import model.OrderDetailDTO;
import java.sql.SQLException;
import java.util.ArrayList;

public interface OrderDetailBO extends SuperBO {
    ArrayList<OrderDetailDTO> getAllOrderDetail() throws SQLException, ClassNotFoundException;
    boolean addOrderDetail(OrderDetailDTO dto) throws SQLException, ClassNotFoundException;
    boolean updateOrderDetail(OrderDetailDTO dto) throws SQLException, ClassNotFoundException;
    boolean existOrderDetail(String id) throws SQLException, ClassNotFoundException;
    String generateNewID() throws SQLException, ClassNotFoundException;
    boolean deleteOrderDetail(String id) throws SQLException, ClassNotFoundException;
    OrderDetailDTO searchOrderDetail(String id) throws SQLException, ClassNotFoundException;
}