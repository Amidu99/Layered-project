package dao.custom;

import dao.CrudDAO;
import model.OrderDetailDTO;

public interface OrderDetailsDAO extends CrudDAO<OrderDetailDTO> {
    //public boolean saveOrderDetails(OrderDetailDTO dto) throws SQLException, ClassNotFoundException;
    public void specialMethod();
}
