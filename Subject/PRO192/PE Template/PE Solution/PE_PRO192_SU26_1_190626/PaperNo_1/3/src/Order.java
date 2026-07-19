/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author NgoAnhHuy
 */
public class Order {

    private int orderId;
    private String customerName;
    private double totalAmount;
    private int itemCount;

    public Order(int orderId, String customerName,
                 double totalAmount, int itemCount) {

        this.orderId = orderId;
        this.customerName = customerName;
        this.totalAmount = totalAmount;
        this.itemCount = itemCount;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public int getItemCount() {
        return itemCount;
    }

    @Override
    public String toString() {
        return orderId + "-" + customerName + "-" + String.format("%.1f", totalAmount) + "-" + itemCount;
    }
}