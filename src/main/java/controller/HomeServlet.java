package controller;

import model.Products;
import service.ServiceProduct;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "HomeServlet", value = "/HomeServlet")
public class HomeServlet extends HttpServlet {
    private final ServiceProduct productService = new ServiceProduct();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action(request, response);
    }

    public void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "sortAsc":
                sortAscProduct(request, response);
                break;
            case "sortDesc":
                sortDescProduct(request, response);
            default:
                displayAllProduct(request, response);
        }
    }
    private void sortDescProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Products> productList = productService.sortProductListDesc();
        request.setAttribute("products", productList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view.jsp");
        requestDispatcher.forward(request, response);
    }

    private void sortAscProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Products> productList = productService.sortProductListAsc();
        request.setAttribute("products", productList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view.jsp");
        requestDispatcher.forward(request, response);
    }

    private void displayAllProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Products> productList = productService.getProductList();
        request.setAttribute("products", productList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view.jsp");
        requestDispatcher.forward(request, response);
    }
}
