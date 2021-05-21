package entities;

import enums.CrispsType;

/**
 *
 * @author Juliana
 */
public class Crisps extends Food {

    private CrispsType type;

    public Crisps(CrispsType type, int quantity, double price) {
        super(quantity, price);
        this.type = type;
    }

    public CrispsType getType() {
        return type;
    }

    public void setType(CrispsType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type + "\n €: " + this.getPrice();
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Crisps other = (Crisps) obj;
        if (this.type != other.type) {
            return false;
        }
        return true;
    }

}
