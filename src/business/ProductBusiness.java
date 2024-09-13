package business;

import enity.Category;
import enity.Product;
import util.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductBusiness {
    // Lấy về danh sách
    public static List<Product> getAll(){
        List<Product> products = new ArrayList<>();
        Connection connection = null;
        try {
            // b1 Tạo đối tượng kết nois
            connection = ConnectionDB.onpenConnection();
            // b2 viết câu lệnh truy vấn
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM product");
            // b3 thực thi
            ResultSet resultSet = statement.executeQuery();
            // b4 duyêt dữ liệu từ resulSet và gán vào categories
            while (resultSet.next()){
                // duyệt từng dòng dữ liệu trong resulSet
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getFloat("price"));
                product.setCategoryId(resultSet.getInt("category_id"));
                product.setStatus(resultSet.getBoolean("status"));
                products.add(product);
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
        }

        return products;
    }
}
