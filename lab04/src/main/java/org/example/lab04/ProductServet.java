package org.example.lab04;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.lab04.models.Product;
import org.example.lab04.models.ResponseDTO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/ProductService/*")
public class ProductServet extends HttpServlet {
    private Gson gson = new Gson();
    private Map<Integer, Product> products = new HashMap<>();

    @Override
    public void init() throws ServletException {
        this.products = new HashMap<>();
        products.put(1, new Product(1, "Iphone", 999));
        products.put(2, new Product(2, "Samsung", 888));
        products.put(3, new Product(3, "Oppo", 777));
    }

    private void sendAsJson(HttpServletResponse response, ResponseDTO product) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        writer.print(gson.toJson(product));
        writer.flush();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        ResponseDTO responseDTO;
        if (id != null) {
            responseDTO = new ResponseDTO(0, "None product", this.products.get(Integer.parseInt(id)));
        }
        else {
            int productId = Integer.parseInt(id);
            if (products.containsKey(productId)) {
                responseDTO = new ResponseDTO(1, "Product exists", products.get(productId));
            }
            else {
                responseDTO = new ResponseDTO(0, "Product does not exist", this.products.get(productId));
            }
        sendAsJson(resp, responseDTO);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product product = gson.fromJson(req.getReader(), Product.class);
        products.put(product.getId(), product);
        sendAsJson(resp, new ResponseDTO(0, "Success", product));
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product product = gson.fromJson(req.getReader(), Product.class);
        if (products.containsKey(product.getId())) {
            products.put(product.getId(), product);
            sendAsJson(resp, new ResponseDTO(0, "Success", product));
        }
        else {
            sendAsJson(resp, new ResponseDTO(404, "Product does not exist", this.products.get(product.getId())));
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        if (products.containsKey(id)) {
            products.remove(id);
            sendAsJson(resp, new ResponseDTO(0, "Success", products.get(id)));
        }
        else {
            sendAsJson(resp, new ResponseDTO(404, "Product does not exist", this.products.get(id)));
        }
    }
}
