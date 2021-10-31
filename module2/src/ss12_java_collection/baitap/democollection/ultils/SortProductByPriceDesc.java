package ss12_java_collection.baitap.democollection.ultils;

import ss12_java_collection.baitap.democollection.entity.Product;

import java.util.Comparator;

public class SortProductByPriceDesc implements Comparator<Product> {


    @Override
    public int compare(Product p1, Product p2) {
        if(p1.getPrice() == p2.getPrice()){
            return p1.getName().compareTo(p2.getName());
        }
        return (int) (p2.getPrice() - p1.getPrice());
    }

}
