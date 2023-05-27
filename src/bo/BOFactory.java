package bo;

import bo.custom.impl.*;

public class BOFactory {
    private static bo.BOFactory boFactory;

    private BOFactory() {
    }

    public static bo.BOFactory getBoFactory() {
        return (boFactory == null) ? boFactory = new bo.BOFactory() : boFactory;
    }

    public enum BOTypes {
        CUSTOMER, ITEM, ORDER, ORDER_DETAILS, PLACE_ORDER
    }

    public SuperBO getBO(bo.BOFactory.BOTypes type) {
        switch (type) {
            case CUSTOMER:
                return new CustomerBOImpl();
            case ITEM:
                return new ItemBOImpl();
            case ORDER:
                return new OrderBOImpl();
            case ORDER_DETAILS:
                return new OrderDetailBOImpl();
            case PLACE_ORDER:
                return new PlaceOrderBOImpl();
            default:
                return null;
        }
    }
}