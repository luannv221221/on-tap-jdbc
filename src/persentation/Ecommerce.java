package persentation;

import java.util.Scanner;

public class Ecommerce {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("==============MENU==============\n" +
                    "1. Quản lý danh mục\n" +
                    "2. Quản lý sản phẩm\n" +
                    "3. Thoát \n");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice){
                case 1:
                    Ecommerce.menuCategory(scanner);
                    break;
                case 2:
                    Ecommerce.menuProduct(scanner);
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Sai lựa chọn");
            }
        } while (true);
    }

    // menu danh mục
    public static void menuCategory(Scanner scanner){
        boolean check = true;
        do {
            System.out.println("=======CATEGORY MANAGER========\n" +
                    "1.Thêm mới danh mục\n" +
                    "2.Hiển thị danh sách\n" +
                    "3.Sửa danh mục\n" +
                    "4.Xóa danh mục\n" +
                    "5.Hiển thị danh sách bao gồm số lượng sản phẩm theo danh mục \n" +
                    "6.Thoát\n");
            int choice1 = Integer.parseInt(scanner.nextLine());
            switch (choice1){
                case 1:
                    Ecommerce.createCategory();
                    break;
                case 2:
                    break;
                case 6:
                    check = false;
                    break;
            }
        } while (check);
    }
    // menu product
    public static void menuProduct(Scanner scanner){
        boolean check1 = true;
        do {
            System.out.println("========PRODUCT MANAGER========\n" +
                    "1.Thêm mới sản phẩm\n" +
                    "2.Hiển thị danh sách\n" +
                    "3.Sửa sản phẩm \n" +
                    "4.Xóa sản phẩm\n" +
                    "5.Tìm kiếm sản phẩm theo tên\n" +
                    "6Thoát\n");
            int choice1 = Integer.parseInt(scanner.nextLine());
            switch (choice1){
                case 1:
                    break;
                case 2:
                    break;
                case 6:
                    check1 = false;
                    break;
            }
        } while (check1);
    }

    public static void createCategory(){


    }
}
