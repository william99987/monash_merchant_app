package BrowseAndShop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileIO 
{   
    //read products from file
    public ArrayList<BrowseAndShop.Product> readProductsFromFile()
    {
        ArrayList<BrowseAndShop.Product> products = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader("ProductInfo.txt")))
        {
            String line;
            while ((line = br.readLine()) != null) 
            {
                String[] productInfo = line.split(","); // the data is comma-separated
                int productId = Integer.parseInt(productInfo[0]);
                String name = productInfo[1];
                String brand = productInfo[2];
                String category = productInfo[3];
                String subcategory = productInfo[4];
                String description = productInfo[5];
                double price = Double.parseDouble(productInfo[6]);

                BrowseAndShop.Product product = new Product(productId, name, brand, category, subcategory, description, price);
                products.add(product);
            }
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }

        return products;
    }


    
}
