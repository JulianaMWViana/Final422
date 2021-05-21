package entities;

/**
 *
 * @author Juliana
 */
public class Food {
    
    private int quantity;
    private double price;

    public Food(int quantity, double price) {
        this.quantity = quantity;
        this.price = price;
    }
    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
}
