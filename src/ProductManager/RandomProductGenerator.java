package ProductManager;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class RandomProductGenerator {

    public static void main(String[] args) {
        RandomProductGenerator generator = new RandomProductGenerator();
        String productData = generator.generateProductData(10);
        String filePath = "RandomProductInfo.txt";
        generator.writeToFile(filePath, productData);
    }

    private String generateProductData(int numEntries) {
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        String[] names = {"apple", "banana", "carrot", "bread", "butter", "milk", "eggs", "cheese", "chicken", "beef", "pasta", "rice"};
        String[] brands = {"BrandA", "BrandB", "BrandC", "BrandD", "BrandE"};
        String[] categories = {"Fruits", "Bakery", "Meat", "Dairy", "Pasta", "Rice", "Vegetables", "Drinks", "Snacks", "Frozen", "Canned", "Household", "Personal Care", "Pet Supplies", "Baby Products", "Health & Beauty", "Electronics", "Home & Garden", "Fashion", "Sports & Outdoors", "Toys & Games", "Books & Media", "Automotive", "Gifts & Occasions", "Other"};
        String[] subcategories = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        String[] descriptions = {"Latest model", "New release", "Top seller", "High demand", "Budget friendly"};

        for (int i = 0; i < numEntries; i++) {
            long productId = 1000000000L + random.nextInt(1000000001);
            String name = names[random.nextInt(names.length)];
            String brand = brands[random.nextInt(brands.length)];
            String category = categories[random.nextInt(categories.length)];
            String subcategory = subcategories[random.nextInt(subcategories.length)];
            String description = descriptions[random.nextInt(descriptions.length)];
            double price = 50.0 + (1500.0 - 50.0) * random.nextDouble();
            builder.append(String.format("%d,%s,%s,%s,%s,%s,%.2f%n", productId, name, brand, category, subcategory, description, price));
        }

        return builder.toString();
    }

    private void writeToFile(String filePath, String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
