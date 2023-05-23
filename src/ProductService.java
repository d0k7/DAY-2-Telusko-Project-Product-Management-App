import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductService {
    List<Product> products = new ArrayList<>();

    public void addProduct(Product p) {
        products.add(p);
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProduct(String name) {
        return products.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public List<Product> getProductWithText(String text) {
        String str = text.toLowerCase();
        return products.stream()
                .filter(p -> p.getName().toLowerCase().contains(str)
                        || p.getType().toLowerCase().contains(str)
                        || p.getPlace().toLowerCase().contains(str))
                .collect(Collectors.toList());
    }

    public List<Product> getProductsByPlace(String place) {
        return products.stream()
                .filter(p -> p.getPlace().equalsIgnoreCase(place))
                .collect(Collectors.toList());
    }

    public List<Product> getOutOfWarrantyProducts() {
        int currentYear = 2023; // Assuming the current year is 2023
        return products.stream()
                .filter(p -> p.getWarranty() <= currentYear)
                .collect(Collectors.toList());
    }
}
