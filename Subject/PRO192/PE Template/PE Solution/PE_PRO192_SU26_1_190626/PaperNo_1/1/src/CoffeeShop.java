/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author NgoAnhHuy
 */
public class CoffeeShop {

    private int id;
    private String storeName;
    private double pricePerCup;
    private int numberOfCups;

    public CoffeeShop() {
    }

    public CoffeeShop(int id, String storeName, double pricePerCup, int numberOfCups) {
        this.id = id;
        this.storeName = storeName;
        this.pricePerCup = pricePerCup;
        this.numberOfCups = numberOfCups;
    }

    public String getStoreName() {
        if (storeName == null || storeName.isEmpty()) {
            return storeName;
        }
        return storeName.substring(0, 1).toUpperCase() + storeName.substring(1).toLowerCase();
    }

    public double getTotalRevenue() {
        if (numberOfCups >= 100) {
            return pricePerCup * numberOfCups * 1.2;
        } else {
            return pricePerCup * numberOfCups;
        }
    }

    public double getProfitRevenue(double costPerCup) {
        return getTotalRevenue() - (costPerCup * numberOfCups);
    }

    @Override
    public String toString() {
        String nameUpper = (storeName != null) ? storeName.toUpperCase() : "";
        return String.format("%s:%.2f", nameUpper, getTotalRevenue());
    }
}
