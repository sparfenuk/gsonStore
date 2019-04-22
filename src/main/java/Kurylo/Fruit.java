package Kurylo;

import java.util.Date;

public class Fruit {

    public Type type;
    private int expirationDays;
    private Date deliveryDate;
    private double price;

    public Fruit() {
    }

    public Fruit(int expirationDays, Date deliveryDate, double price) {
        this.expirationDays = expirationDays;
        this.deliveryDate = deliveryDate;
        this.price = price;
    }

    public int getExpirationDays() {
        return expirationDays;
    }

    public void setExpirationDays(int expirationDays) {
        this.expirationDays = expirationDays;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
