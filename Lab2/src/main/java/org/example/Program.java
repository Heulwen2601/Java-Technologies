package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Program {
    //String url = "jdbc:mysql://127.0.0.1:3306/lab2?user=root";
    private final ProductDAO productDAO;
    private Connection connection;

    public Program() {
        productDAO = new ProductDAO();
    }

    private void setConnection(String url) throws SQLException {
//        String username = args[1];
//        String password = args[2];
        connection = DriverManager.getConnection(url);
        productDAO.setConnection(connection);
    }

    private void showAllProducts() throws SQLException {
        List<Product> productList = productDAO.readAll();
        for (Product product : productList) {
            System.out.println(product.toString());
        }
    }

    private void showOneProduct() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập ID sản phẩm: ");
        long id = sc.nextLong();
        Product product = productDAO.read(id);
        if (product != null) {
            System.out.println(product.toString());
        } else {
            System.out.println("Không tìm thấy sản phẩm!");
        }
    }

    private void addProduct() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập thông tin sản phẩm mới");
        System.out.print("Nhập ID sản phẩm: ");
        long id = sc.nextLong();
        sc.nextLine();
        System.out.print("Nhập tên sản phẩm: ");
        String name = sc.nextLine();
        System.out.print("Nhập giá sản phẩm: ");
        Double price = sc.nextDouble();
        sc.nextLine();
        System.out.print("Nhập màu sản phẩm: ");
        String color = sc.nextLine();
        Product product = new Product(id, name, price, color);
        productDAO.add(product);
    }

    private void updateProduct() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập ID sản phẩm cần cập nhật: ");
        long id = sc.nextLong();
        sc.nextLine();
        System.out.print("Nhập tên mới: ");
        String name = sc.nextLine();
        System.out.print("Nhập giá mới: ");
        Double price = sc.nextDouble();
        sc.nextLine();
        System.out.print("Nhập màu mới: ");
        String color = sc.nextLine();
        Product product = new Product(id, name, price, color);
        productDAO.update(product);
    }

    private void deleteProduct() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập ID sản phẩm cần xóa: ");
        long id = sc.nextLong();
        productDAO.delete(id);
    }

    private void createProductTable() throws SQLException {
        productDAO.createProductTable();
    }

    public void showMenu() {
        System.out.println("Chọn tùy chọn");
        System.out.println("1. Xem tất cả sản phẩm");
        System.out.println("2. Xem chi tiết sản phẩm theo ID");
        System.out.println("3. Thêm sản phẩm mới");
        System.out.println("4. Cập nhật sản phẩm");
        System.out.println("5. Xóa sản phẩm theo ID");
        System.out.println("6. Thoát");
        System.out.print("Your choice: ");
    }

    public static void main(String[] args) {
        Program program = new Program();
        try {
            program.setConnection(args[0]);
            program.createProductTable();

            int choice = 0;
            while (choice != 6) {
                program.showMenu();
                Scanner sc = new Scanner(System.in);
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        program.showAllProducts();
                        System.out.println();
                        break;
                    case 2:
                        program.showOneProduct();
                        System.out.println();
                        break;
                    case 3:
                        program.addProduct();
                        System.out.println();
                        break;
                    case 4:
                        program.updateProduct();
                        System.out.println();
                        break;
                    case 5:
                        program.deleteProduct();
                        System.out.println();
                        break;
                    case 6:
                        System.out.println("Thoát chương trình.");
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ.");
                        break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (program.connection != null && !program.connection.isClosed()) {
                    program.connection.close();
                    System.out.println("Đã đóng kết nối với cơ sở dữ liệu.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

  }
}
