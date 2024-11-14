package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements Repository<Product, Long> {

    private Connection connection;

    private final String SQL_SELECT = "SELECT * FROM product";
    private final String SQL_INSERT = "INSERT INTO product (id, name, price, color) VALUES (?, ?, ?, ?)";
    private final String SQL_DELETE = "DELETE FROM product WHERE id = ?";
    private final String SQL_UPDATE = "UPDATE product SET name = ?, price = ?, color = ? WHERE id = ?";
    private final String SQL_SELECT_BY_ID = "SELECT * FROM product WHERE id = ?";
    private final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS product";
    private final String SQL_CREATE_TABLE = "CREATE TABLE product (id INT PRIMARY KEY, name VARCHAR(200) NOT NULL, price DOUBLE NOT NULL, color VARCHAR(200) NOT NULL)";

    public ProductDAO(Connection connection) {
        this.connection = connection;
    }

    public ProductDAO() {
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Long add(Product product) {
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_INSERT);
            ps.setLong(1, product.getId());
            ps.setString(2, product.getName());
            ps.setDouble(3, product.getPrice());
            ps.setString(4, product.getColor());
            ps.executeUpdate();
            System.out.println("Thêm sản phẩm thành công");
            return product.getId();
        } catch (SQLException e) {
            System.out.println("Lỗi khi thêm sản phẩm: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Product> readAll() {
        List<Product> result = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_SELECT);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                long id = rs.getLong("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String color = rs.getString("color");
                Product product = new Product(id, name, price, color);
                result.add(product);
            }
        } catch (SQLException e) {
            System.out.println("Lỗi khi đọc sản phẩm: " + e.getMessage());
        }
        return result;
    }

    @Override
    public Product read(Long id) {
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_SELECT_BY_ID);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String color = rs.getString("color");
                return new Product(id, name, price, color);
            }
        } catch (SQLException e) {
            System.out.println("Lỗi khi đọc sản phẩm theo ID: " + e.getMessage());
        }
        return null;
    }

    @Override
    public boolean update(Product product) {
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_UPDATE);
            ps.setString(1, product.getName());
            ps.setDouble(2, product.getPrice());
            ps.setString(3, product.getColor());
            ps.setLong(4, product.getId());
            ps.executeUpdate();
            System.out.println("Cập nhật sản phẩm thành công");
            return true;
        } catch (SQLException e) {
            System.out.println("Lỗi khi cập nhật sản phẩm: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(Long id) {
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_DELETE);
            ps.setLong(1, id);
            ps.executeUpdate();
            System.out.println("Xóa sản phẩm thành công");
            return true;
        } catch (SQLException e) {
            System.out.println("Lỗi khi xóa sản phẩm: " + e.getMessage());
            return false;
        }
    }

    public boolean createProductTable() {
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_DROP_TABLE);
            ps.executeUpdate();
            ps = connection.prepareStatement(SQL_CREATE_TABLE);
            ps.executeUpdate();
            System.out.println("Tạo bảng sản phẩm thành công");
            return true;
        } catch (SQLException e) {
            System.out.println("Lỗi khi tạo bảng sản phẩm: " + e.getMessage());
            return false;
        }
    }
}
