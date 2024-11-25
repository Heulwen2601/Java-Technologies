package org.example.lab05.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.lab05.DAO.ProductDAO;
import org.example.lab05.Models.Product;

import java.io.IOException;
import java.util.List;

@WebServlet("/products")
public class ProductServlets extends HttpServlet {
    private ProductDAO productDAO;

    @Override
    public void init() throws ServletException {
        this.productDAO = new ProductDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productDAO.getAll();
        req.setAttribute("products", products);
        req.getRequestDispatcher("/WEB-INF/jsp/products.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String deleteProductId = req.getParameter("deleteProductId");

        if (deleteProductId != null) {
            productDAO.removeById(Integer.parseInt(deleteProductId));
            resp.sendRedirect("/Lab05_war_exploded/products");
        }
        else {
            String productName = req.getParameter("productname");
            double productPrice = Double.parseDouble(req.getParameter("productprice"));

            Product product = new Product(productName, productPrice);

            Integer success = productDAO.add(product);

            if (success != null) {
                resp.sendRedirect("/Lab05_war_exploded/products");
            } else {
                req.setAttribute("error", "Failed to add product");
            }
        }

    }
}
