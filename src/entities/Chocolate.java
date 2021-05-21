package entities;

import enums.ChocolateType;

/**
 *
 * @author Juliana
 */
public class Chocolate extends Food {
    
    private ChocolateType type;

    public Chocolate(ChocolateType type, int quantity, double price) {
        super(quantity, price);
        this.type = type;
    }

    public ChocolateType getType() {
        return type;
    }

    public void setType(ChocolateType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type + "\n €: " + this.getPrice();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Chocolate other = (Chocolate) obj;
        if (this.type != other.type) {
            return false;
        }
        return true;
    }
    
}
