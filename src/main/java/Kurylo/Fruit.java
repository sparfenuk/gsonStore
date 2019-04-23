package Kurylo;

import SP.Type;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Fruit {

    private Type type;
    private int shelfLife;
    public String date;
    private Date Date;
    private double price;

    public Fruit() {
    }

    public Fruit(String type, int shelfLife, String date, double price) {
        this.type = Type.valueOf(type);
        this.shelfLife = shelfLife;
        this.date = date;
        this.price = price;
    }

    public Type getType() {
        return type;
    }

    public void setType(String type) {
        this.type = Type.valueOf(type);
    }

    public int getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(int shelfLife) {
        this.shelfLife = shelfLife;
    }

    public Date getDate() {
        try {
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            return format.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
