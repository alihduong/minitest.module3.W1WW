package service;

import model.Products;

import java.util.ArrayList;

public class ServiceProduct {
    private final static ArrayList<Products> productList;
    static {
        productList = new ArrayList<>();
        productList.add(new Products(1, "Iphone 13", 3500000, 15, "pro max"));
        productList.add(new Products(2, "Ipad pro", 4000000, 20, "pro max"));
        productList.add(new Products(3, "Macbook pro", 9200000, 15, "pro 16 inch"));
        productList.add(new Products(4, "Macbook air", 3500000, 15, "air 12 inch"));
    }


    public ArrayList<Products> getProductList(){
        return productList;
    }

    public ArrayList<Products> sortProductListAsc() {
        productList.sort((o1, o2) -> (int) (o1.getPrice() - o2.getPrice()));
        return productList;
    }

    public ArrayList<Products> sortProductListDesc() {
        productList.sort((o1, o2) -> (int) (o2.getPrice() - o1.getPrice()));
        return productList;
    }
}
