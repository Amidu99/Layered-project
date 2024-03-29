package model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/

public class OrderDTO {
    private String oid;
    private LocalDate date;
    private String customerId;
    private String customerName;
    private BigDecimal orderTotal;
    List<OrderDetailDTO> orderDetails;

    public OrderDTO() {
    }

    public OrderDTO(String oid, LocalDate date, String customerId) {
        this.oid = oid;
        this.date = date;
        this.customerId = customerId;
    }

    public OrderDTO(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) {
        this.oid = orderId;
        this.date = orderDate;
        this.customerId = customerId;
        this.orderDetails = orderDetails;
    }

    public OrderDTO(String oid, LocalDate date, String customerId, String customerName, BigDecimal orderTotal) {
        this.oid = oid;
        this.date = date;
        this.customerId = customerId;
        this.customerName = customerName;
        this.orderTotal = orderTotal;
    }

    public OrderDTO(String oid, String date, String customerId, String customerName, BigDecimal orderTotal) {
        this.oid = oid;
        this.date = LocalDate.parse(date);
        this.customerId = customerId;
        this.customerName = customerName;
        this.orderTotal = orderTotal;
    }

    public List<OrderDetailDTO> getOrderDetails() {
        return orderDetails;
    }

    public String getOrderId() {
        return oid;
    }

    public void setOrderId(String orderId) {
        this.oid = oid;
    }

    public LocalDate getOrderDate() {
        return date;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.date = orderDate;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public BigDecimal getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(BigDecimal orderTotal) {
        this.orderTotal = orderTotal;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "orderId='" + oid + '\'' +
                ", orderDate=" + date +
                ", customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", orderTotal=" + orderTotal +
                '}';
    }
}