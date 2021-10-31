package ss12_java_collection.baitap.democollection.service;


import ss12_java_collection.baitap.democollection.entity.Product;
import ss12_java_collection.baitap.democollection.repository.ProductRepository;
import ss12_java_collection.baitap.democollection.ultils.SortProductByPriceDesc;

import java.util.Collections;
import java.util.List;

public class ProductService {
    private ProductRepository productRepository = new ProductRepository();


    public void addProduct(Product p) {
        productRepository.addProduct(p);
    }

    public boolean editProduct(Product p) {
        return productRepository.editProduct(p);
    }

    public boolean deleteProduct(int id) {
        return productRepository.deleteProduct(id);
    }
    public List<Product> getProductList() {
        return productRepository.getProductList();
    }
    public Product getProductById(int id) {
        return productRepository.getProductById(id);
    }

    public List<Product> findProductByName(String name) {
        return productRepository.findProductByName(name);
    }
    public void sortByPriceDesc(List<Product> list){
        Collections.sort(list, new SortProductByPriceDesc());
    }
}
