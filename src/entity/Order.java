package entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Order {
    private String oid;
    private LocalDate date;
    private String customerId;
    private String customerName;
    private BigDecimal orderTotal;

    public Order() {
    }

    public Order(String oid, LocalDate date, String customerId) {
        this.oid = oid;
        this.date = date;
        this.customerId = customerId;
    }

    public Order(String oid, LocalDate date, String customerId, String customerName, BigDecimal orderTotal) {
        this.oid = oid;
        this.date = date;
        this.customerId = customerId;
        this.customerName = customerName;
        this.orderTotal = orderTotal;
    }

    public Order(String oid, String date, String customerId, String customerName, BigDecimal orderTotal) {
        this.oid = oid;
        this.date = LocalDate.parse(date);
        this.customerId = customerId;
        this.customerName = customerName;
        this.orderTotal = orderTotal;
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
}
