package dao.custom;

import dao.CrudDAO;
import entity.OrderDetail;

public interface OrderDetailsDAO extends CrudDAO<OrderDetail> {
    //public boolean saveOrderDetails(OrderDetailDTO dto) throws SQLException, ClassNotFoundException;
    public void specialMethod();
}
