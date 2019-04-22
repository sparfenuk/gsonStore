package Kurylo;

import SP.Type;

import java.util.Date;

public class Fruit {

    private Type type;
    private int expirationDays;
    private Date deliveryDate;
    private double price;

    public Fruit() {
    }

    public Fruit(Type type, int expirationDays, Date deliveryDate, double price) {
        this.type = type;
        this.expirationDays = expirationDays;
        this.deliveryDate = deliveryDate;
        this.price = price;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
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
