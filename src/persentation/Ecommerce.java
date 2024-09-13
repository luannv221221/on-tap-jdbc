package persentation;

import business.CategoryBusiness;
import business.ProductBusiness;
import enity.Category;
import enity.Product;

import java.util.List;
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
                    "7.Tim ten danh muc\n" +
                    "5.Hiển thị danh sách bao gồm số lượng sản phẩm theo danh mục \n" +
                    "6.Thoát\n");
            int choice1 = Integer.parseInt(scanner.nextLine());
            switch (choice1){
                case 1:
                    Ecommerce.createCategory(scanner);
                    break;
                case 2:
                    Ecommerce.findAllCategory();
                    break;
                case 6:
                    check = false;
                    break;
                case 7:
                    Ecommerce.searchCategory(scanner);
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
                    Ecommerce.displayProducts();
                    break;
                case 6:
                    check1 = false;
                    break;
            }
        } while (check1);
    }

    // danh muc
    public static void findAllCategory(){
        List<Category> categories = CategoryBusiness.getAll();
        for (Category category : categories) {
            category.displayData();
        }
    }
    public static void createCategory(Scanner scanner){
        Category category = new Category();
        category.inputData(scanner);
        CategoryBusiness.create(category);
    }
    // xây dựng phương thức cập nhật danh mục
    public static void updateCategory(Scanner scanner){
        // Bước 1. Nhập Id Cần sửa
        System.out.println("Nhap vao id can sua ");
        int idEdit = Integer.parseInt(scanner.nextLine());
        // Hiển thị danh mục tìm được
        Category category = CategoryBusiness.findById(idEdit);
        // show danh mục
        if(category != null){
            System.out.println("Thông tin danh mục ");
            category.displayData();
            // hỏi người dùng muốn update trường nào và nhập thông tin
            boolean isExit = true;
            do {
                System.out.println("Chọn trường muốn cập nhật");
                System.out.println("1. Sửa tên danh mục");
                System.out.println("2. Sửa trạng thái");
                System.out.println("3. Thoát ");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice){
                    case 1:
                        System.out.println("Nhập vào tên mới");
                        category.setName(scanner.nextLine());
                        break;
                    case 2:
                        System.out.println("Nhập vào trạng thái");
                        category.setStatus(Boolean.parseBoolean(scanner.nextLine()));
                        break;
                    case 3:
                        isExit = false;
                        break;
                    default:
                        System.out.println("Sai lua chọn");
                }
            }while (isExit);
            // thực cập nhật trong database gọi đến update của CategoryBusiness
            boolean result = CategoryBusiness.update(category);
            if(result){
                System.out.println("Cập nhật thanh công");
            } else {
                System.err.println("Cập nhật thất bại ");
            }
        } else {
            System.out.println("Koo tim thay danh mục");
        }

    }

    // phương thức xóa danh mục
    public static void deleteCategory(Scanner scanner){
        System.out.println("Mời bạn nhập vào id cần xóa ?");
        int id = Integer.parseInt(scanner.nextLine());
        if(CategoryBusiness.findById(id) != null){
            boolean result = CategoryBusiness.delete(id);
            if(result){
                System.out.println("Xóa thành công ");
            } else {
                System.err.println("Xóa thất bại");
            }
        } else {
            System.err.println("Mã danh mục không tồn tại");
        }
    }

    // phuong thuc tim kiem danh mucj theo ten danh muc
    public static void searchCategory(Scanner scanner){
        System.out.println("Nhap vao tu khoa tim kiem theo ten");
        String keyword = scanner.nextLine();
        List<Category> categories = CategoryBusiness.searchCategoriesByNam(keyword);
        for (Category category : categories) {
            category.displayData();
        }
    }

    // Product
    // phuowng thuc hien thi danh sach danh muc
    public static void displayProducts(){
        List<Product> products = ProductBusiness.getAll();
        for (Product product : products) {
            product.displayData();
        }
    }
}
