package enity;

import java.util.Scanner;

public class Product {
    private int id;
    private String name;
    private float price;
    private int categoryId;
    private boolean status;

    public Product() {
    }

    public Product(int id, String name, float price, int categoryId, boolean status) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.categoryId = categoryId;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void inputData(Scanner scanner){
        // nhập thông tin
    }
    public void displayData(){
        // Hiển thij thông tin
    }
}
