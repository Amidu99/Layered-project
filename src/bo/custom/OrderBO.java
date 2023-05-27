package bo.custom;

import model.OrderDTO;
import java.sql.SQLException;
import java.util.ArrayList;

public interface OrderBO {
    //ArrayList<OrderDTO> getAllOrder() throws SQLException, ClassNotFoundException;
    boolean addOrder(OrderDTO dto) throws SQLException, ClassNotFoundException;
    //boolean updateOrder(OrderDTO dto) throws SQLException, ClassNotFoundException;
    boolean existOrder(String id) throws SQLException, ClassNotFoundException;
    String generateNewID() throws SQLException, ClassNotFoundException;
    //boolean deleteOrder(String id) throws SQLException, ClassNotFoundException;
    //OrderDTO searchOrder(String oid) throws SQLException, ClassNotFoundException;
}
