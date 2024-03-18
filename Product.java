import java.io.*;

public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String category;
    private double price;

    public Product(int id, String name, String category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public void printDetails() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Category: " + category);
        System.out.println("Price: " + price);
    }

    public static void main(String[] args) {
        // Serialize the object
        Product product = new Product(1, "Laptop", "Electronics", 999.99);
        serializeObject(product);

        // Deserialize the object
        Product deserializedProduct = deserializeObject();
        System.out.println("Deserialized Product Details:");
        deserializedProduct.printDetails();
    }

    public static void serializeObject(Product product) {
        try {
            FileOutputStream fileOut = new FileOutputStream("product.ser");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(product);
            objectOut.close();
            fileOut.close();
            System.out.println("Product serialized successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Product deserializeObject() {
        Product product = null;
        try {
            FileInputStream fileIn = new FileInputStream("product.ser");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            product = (Product) objectIn.readObject();
            objectIn.close();
            fileIn.close();
            System.out.println("Product deserialized successfully.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return product;
    }
}
