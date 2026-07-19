
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author NgoAnhHuy
 */
public class OrderList extends ArrayList<Order> {
    public double getAverageAmount() {
        double sum = 0;
        int count = 0;

        for (Order order : this) {
            if (order.getItemCount() > 3
                    && order.getTotalAmount() >= 1000) {

                sum += order.getTotalAmount();
                count++;
            }
        }

        if (count == 0) {
            return 0;
        }

        double average = sum / count;

        return Math.round(average * 10.0) / 10.0;
    }

    public double getMaxAmount() {
        double max = 0;

        for (Order order : this) {
            String customerName = order.getCustomerName();

            if (order.getItemCount() >= 2
                    && customerName != null
                    && customerName.toUpperCase().startsWith("A")) {

                if (order.getTotalAmount() > max) {
                    max = order.getTotalAmount();
                }
            }
        }

        return Math.round(max * 10.0) / 10.0;
    }
    
}
