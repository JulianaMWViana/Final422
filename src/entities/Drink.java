package entities;

import enums.DrinkType;

/**
 *
 * @author Juliana
 */
public class Drink extends Food {

    private DrinkType type;

    public Drink(DrinkType type, int quantity, double price) {
        super(quantity, price);
        this.type = type;
    }
    
    public DrinkType getType() {
        return type;
    }

    public void setType(DrinkType type) {
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
        final Drink other = (Drink) obj;
        if (this.type != other.type) {
            return false;
        }
        return true;
    }

    
}
