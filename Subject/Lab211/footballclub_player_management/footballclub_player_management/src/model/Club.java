package model;

import java.math.BigDecimal;

public class Club extends FootballEntity {
    private String name;
    private String sponsorBrand;
    private double budget;

    public Club(String id, String name, String sponsorBrand, double budget) {
        super(id);
        this.name = name;
        this.sponsorBrand = sponsorBrand;
        this.budget = budget;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSponsorBrand() {
        return sponsorBrand;
    }

    public void setSponsorBrand(String sponsorBrand) {
        this.sponsorBrand = sponsorBrand;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    @Override
    public String toDataString() {
        return getId() + ", " + name + ", " + sponsorBrand + ", " + formatBudget(budget);
    }

    private String formatBudget(double value) {
        return BigDecimal.valueOf(value).stripTrailingZeros().toPlainString();
    }
}
