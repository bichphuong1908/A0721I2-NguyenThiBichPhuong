package ss12_java_collection.baitap.democollection.controller;

import ss12_java_collection.baitap.democollection.entity.Product;
import ss12_java_collection.baitap.democollection.service.ProductService;

import java.util.List;

public class ProductManager {
    public static void main(String[] args) {
            ProductService service = new ProductService();

            Product p1 = new Product(1, "Giay", 230000);
            Product p2 = new Product(2, "Ao", 220000);
            Product p3 = new Product(3, "Quan", 210000);
            Product p4 = new Product(4, "Giay", 200000);
            Product p5 = new Product(5, "Sach", 210000);
            Product p6 = new Product(6, "Vo", 190000);

            service.addProduct(p1);
            service.addProduct(p2);
            service.addProduct(p3);
            service.addProduct(p4);
            service.addProduct(p5);
            service.addProduct(p6);

            List<Product> products = service.getProductList();
            service.sortByPriceDesc(products);
            products.stream().forEach(p -> System.out.println(p));
        }
}
