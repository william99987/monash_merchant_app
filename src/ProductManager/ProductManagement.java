package ProductManager;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

import BrowseAndShop.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductManagement
{
    private Map<Integer, Product> products;
    private static final String FILE_PATH = "ProductInfo.txt";

    public ProductManagement()
    {
        this.products = new HashMap<>();
    }

    private Map<Integer, Product> loadProductsFromFile()
    {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int productId = Integer.parseInt(parts[0]);
                String name = parts[1];
                String brand = parts[2];
                String category = parts[3];
                String subcategory = parts[4];
                String description = parts[5];
                double price = Double.parseDouble(parts[6]);
                products.put(productId, new Product(productId, name, brand, category, subcategory, description, price));
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }

    public static List<Integer> extractProductIds(String filePath) {
        List<Integer> productIds = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int productId = Integer.parseInt(parts[0]);
                productIds.add(productId);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return productIds;
    }

    public static void printAllProducts() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            System.out.println("Product Information:");
            System.out.println("| ProductId | Name | Brand | Category | Subcategory | Description | Price |");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addProduct(Product product)
    {
        ProductManagement productManagement = new ProductManagement();
        products = productManagement.loadProductsFromFile();
        if(!products.containsKey(product.getProductId()))
        {
            products.put(product.getProductId(), product);
            productManagement.writeProductsTofile(FILE_PATH);
            System.out.println("Product added successfully: " + product);
        }
        else
        {
            System.out.println("Product id already exists");
        }
    }

    public void updateProduct(int id, String name, String brand, String category, String subcategory, String description, double price)
    {
        ProductManagement productManagement = new ProductManagement();
        products = productManagement.loadProductsFromFile();
        if (products.containsKey(id))
        {
            Product product = products.get(id);
            product.setName(name);
            product.setBrand(brand);
            product.setCategory(category);
            product.setSubcategory(subcategory);
            product.setDescription(description);
            product.setPrice(price);
            productManagement.writeProductsTofile(FILE_PATH);
            System.out.println("Product updated successfully: " + product);
            //
        }
        else
        {
            System.out.println("Product not found with ID: " + id);
        }
    }

    public void removeProduct(int id)
    {
        ProductManagement productManagement = new ProductManagement();
        products = productManagement.loadProductsFromFile();
        if (products.remove(id) != null) {
            System.out.println("Product removed successfully with ID: " + id);
            productManagement.writeProductsTofile(FILE_PATH);
        } else {
            System.out.println("No product found with ID: " + id);
        }
    }

    public void writeProductsTofile(String filePath)
    {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath)))
        {
            for(Product product : products.values())
            {
                writer.write(productToFileFormat(product));
            }
            System.out.println("Products have been written to the file successfully.");
        } catch (IOException e) {
            System.out.println("Failed to write products to file: " + e.getMessage());
        }
    }

    public String productToFileFormat(Product product)
    {
        return String.format("%d,%s,%s,%s,%s,%s,%.2f%n",
                product.getProductId(),
                product.getName(),
                product.getBrand(),
                product.getCategory(),
                product.getSubcategory(),
                product.getDescription(),
                product.getPrice());
    }
}
