package enity;

import java.util.Scanner;

public class Category {
    private int id;
    private String name;
    private boolean status;

    public Category() {
    }

    public Category(int id, String name, boolean status) {
        this.id = id;
        this.name = name;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    // inputData ()
    public void inputData(Scanner scanner){
        System.out.println("Nhập vào tên danh mục");
        this.name = scanner.nextLine();
        System.out.println("Nhập vào trạng thái ");
        this.status = Boolean.parseBoolean(scanner.nextLine());
    }
    // displayData()
    public void displayData(){
        System.out.println("ID: "+this.id);
        System.out.println("Name: "+this.name);
        System.out.println("Status: "+(this.status ? "active":"inactive"));
    }
}
