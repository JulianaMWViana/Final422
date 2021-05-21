package main;

import entities.Chocolate;
import entities.Crisps;
import entities.Drink;
import entities.Food;
import enums.ChocolateType;
import enums.CrispsType;
import enums.DrinkType;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Juliana
 */
public class Main {

    //read the user input
    private static final Scanner scanner = new Scanner(System.in);
    //format the double value
    private static final DecimalFormat format = new DecimalFormat("#.##");

    //static values
    private static final double PRICE_DRINK = 2;
    private static final double PRICE_CRISPS = 1.5;
    private static final double PRICE_CHOCOLATE = 1.2;
    private static final String DOUBLE_TAB = "\t\t";
    private static double amount = 0;
    private static final int INITIAL_QUANTITY = 5;

    //list for foods requested
    private static final List<Food> orders = new ArrayList<>();

    //list for the all items sold
    private static final List<Food> itemsSold = new ArrayList<>();

    //array bidimensional for the machine 
    private static final Food[][] foods = new Food[3][5];

    public static void main(String[] args) {

        boolean execute = true;
        suppliesTheMachine();

        do {
            showItemsInTheMachine();

            System.out.println("Choose a NUMBER. Write cancel to cancel your order. 0 to pay your order. Write admin to see the total value of items sold");

            String codeString = scanner.nextLine();

            if (codeString.equalsIgnoreCase("cancel")) {
                for (Food order : orders) {
                    for (int i = 0; i < foods.length; i++) {
                        for (int j = 0; j < foods[i].length; j++) {
                            if (order.equals(foods[i][j])) {
                                foods[i][j].setQuantity(foods[i][j].getQuantity() + 1);
                            }
                        }
                    }
                }
                orders.clear();
                amount = 0;
                continue;
            }
            if (codeString.equalsIgnoreCase("admin")) {
                System.out.println("All the items sold: ");
                double amountSold = 0;
                for (int i = 0; i < itemsSold.size(); i++) {
                    System.out.println(itemsSold.get(i));
                    amountSold = amountSold + itemsSold.get(i).getPrice();
                }
                System.out.println("Total €" + amountSold);
                continue;
            }
            if (isItValidNumber(codeString)) {
                int code = Integer.parseInt(codeString);
                if (code == 0) {
                    orderPaid();
                    itemsSold.addAll(orders);
                    orders.clear();
                    amount = 0;
                    continue;
                }
                Food food = decreaseAndReturnFood(code, foods);
                addAndShowOrder(food, orders);
            } else {
                System.err.println("Wrong input. Please, use a correct value.");
            }
        } while (execute);
    }

    /**
     * Check if it is a valid number
     *
     * @param nextLine
     * @return
     */
    private static boolean isItValidNumber(String nextLine) {
        try {
            int x = Integer.parseInt(nextLine);
            if (x < 0 || x > 15) {
                throw new NumberFormatException();
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Shows the correct type to print the types
     *
     * @param food
     */
    private static void printTypes(Food food) {
        if (food instanceof Chocolate) {
            System.out.print(((Chocolate) food).getType() + DOUBLE_TAB);
        } else if (food instanceof Crisps) {
            System.out.print(((Crisps) food).getType() + DOUBLE_TAB);
        } else {
            System.out.print(((Drink) food).getType() + DOUBLE_TAB);
        }
    }

    /**
     * Supplies the machine
     */
    private static void suppliesTheMachine() {
        for (int i = 0; i < 3; i++) {
            switch (i) {
                case 0:
                    for (int j = 0; j < 5; j++) {
                        suppliesCrispsType(i, j);
                    }
                    break;
                case 1:
                    for (int j = 0; j < 5; j++) {
                        suppliesDrinkType(i, j);
                    }
                    break;
                default:
                    for (int j = 0; j < 5; j++) {
                        suppliesChocolateType(i, j);
                    }
            }
        }
    }

    /**
     * Supplies Chocolate - Kitkat, Mars, Sneakers, Kinder and Ferrero
     *
     * @param i
     * @param j
     */
    private static void suppliesChocolateType(int i, int j) {
        switch (j) {
            case 0:
                foods[i][j] = new Chocolate(ChocolateType.KITKAT, INITIAL_QUANTITY, PRICE_CHOCOLATE);
                break;
            case 1:
                foods[i][j] = new Chocolate(ChocolateType.MARS, INITIAL_QUANTITY, PRICE_CHOCOLATE);
                break;
            case 2:
                foods[i][j] = new Chocolate(ChocolateType.SNEAKER, INITIAL_QUANTITY, PRICE_CHOCOLATE);
                break;
            case 3:
                foods[i][j] = new Chocolate(ChocolateType.KINDER, INITIAL_QUANTITY, PRICE_CHOCOLATE);
                break;
            case 4:
                foods[i][j] = new Chocolate(ChocolateType.FERRERO, INITIAL_QUANTITY, PRICE_CHOCOLATE);
                break;
            default:
                break;
        }
    }

    /**
     * Show the items
     *
     */
    private static void showItemsInTheMachine() {
        int count = 1;
        System.out.println("****************************Vending Machine****************************");
        for (Food[] food : foods) {
            for (Food food1 : food) {
                System.out.print("Code " + (count++) + DOUBLE_TAB);
            }
            System.out.println("");
            for (Food food1 : food) {
                printTypes(food1);
            }
            System.out.println("");
            for (Food food1 : food) {
                System.out.print("€ " + food1.getPrice() + DOUBLE_TAB);
            }
            System.out.println("");
            for (Food food1 : food) {
                System.out.print("Qtd " + food1.getQuantity() + DOUBLE_TAB);
            }
            System.out.println("");
            System.out.println("");
        }
        System.out.println("");
    }

    /**
     * Supplies Crisps - Doritos, Hunky, Pringles, Tayto and Ruffles
     *
     * @param i
     * @param j
     */
    private static void suppliesCrispsType(int i, int j) {
        switch (j) {
            case 0:
                foods[i][j] = new Crisps(CrispsType.DORITOS, INITIAL_QUANTITY, PRICE_CRISPS);
                break;
            case 1:
                foods[i][j] = new Crisps(CrispsType.HUNKY, INITIAL_QUANTITY, PRICE_CRISPS);
                break;
            case 2:
                foods[i][j] = new Crisps(CrispsType.PRINGLE, INITIAL_QUANTITY, PRICE_CRISPS);
                break;
            case 3:
                foods[i][j] = new Crisps(CrispsType.TAYTO, INITIAL_QUANTITY, PRICE_CRISPS);
                break;
            case 4:
                foods[i][j] = new Crisps(CrispsType.RUFFLES, INITIAL_QUANTITY, PRICE_CRISPS);
                break;
            default:
                break;
        }
    }

    /**
     * Supplies Drink - Coke, guarana, Monster, Pepsi and Water
     *
     * @param i
     * @param j
     */
    private static void suppliesDrinkType(int i, int j) {
        switch (j) {
            case 0:
                foods[i][j] = new Drink(DrinkType.COKE, INITIAL_QUANTITY, PRICE_DRINK);
                break;
            case 1:
                foods[i][j] = new Drink(DrinkType.GUARANA, INITIAL_QUANTITY, PRICE_DRINK);
                break;
            case 2:
                foods[i][j] = new Drink(DrinkType.MONSTER, INITIAL_QUANTITY, PRICE_DRINK);
                break;
            case 3:
                foods[i][j] = new Drink(DrinkType.PEPSI, INITIAL_QUANTITY, PRICE_DRINK);
                break;
            case 4:
                foods[i][j] = new Drink(DrinkType.WATER, INITIAL_QUANTITY, PRICE_DRINK);
                break;
            default:
                break;
        }
    }

    /**
     * Decrease one unit and return the food
     *
     * @param code
     * @param foods
     */
    private static Food decreaseAndReturnFood(int code, Food[][] foods) {
        Food food = null;
        if (code >= 1 && code <= 5) {
            int currentQtd = foods[0][code - 1].getQuantity();
            if (currentQtd == 0) {
                System.out.println("Item " + code + " out-of-stock");
                return food;
            }
            foods[0][code - 1].setQuantity(currentQtd - 1);
            food = foods[0][code - 1];
        } else if (code >= 6 && code <= 10) {
            int currentQtd = foods[1][code - 6].getQuantity();
            if (currentQtd == 0) {
                System.out.println("Item " + code + " out-of-stock");
                return food;
            }
            foods[1][code - 6].setQuantity(currentQtd - 1);
            food = foods[1][code - 6];
        } else {
            int currentQtd = foods[2][code - 11].getQuantity();
            if (currentQtd == 0) {
                System.out.println("Item " + code + " out-of-stock");
                return food;
            }
            foods[2][code - 11].setQuantity(currentQtd - 1);
            food = foods[2][code - 11];
        }
        return food;
    }

    /**
     * Add the food and show the current order
     *
     * @param food
     * @param orders1
     */
    private static void addAndShowOrder(Food food, List<Food> orders) {
        if (food != null) {
            orders.add(food);
            double price = 0;
            System.out.println("**********You ordered:***********");
            for (int i = 0; i < orders.size(); i++) {
                price = orders.get(i).getPrice();
                orders.get(i).getPrice();
                if (orders.get(i) instanceof Chocolate) {
                    System.out.print(" *" + ((Chocolate) orders.get(i)).getType() + ", € " + price + " ");
                } else if (orders.get(i) instanceof Crisps) {
                    System.out.print(" *" + ((Crisps) orders.get(i)).getType() + ", € " + price + " ");
                } else {
                    System.out.print(" *" + ((Drink) orders.get(i)).getType() + ", € " + price + " ");
                }
            }
            amount = amount + price;
            totalAmount();
            System.out.println("");
        }
    }

    private static void orderPaid() {
        System.out.println("------------Order Paid:------------");
        for (int i = 0; i < orders.size(); i++) {
            System.out.println(orders.get(i));
        }
        totalAmount();
    }

    private static void totalAmount() {
        System.out.println("Total €" + format.format(amount));
    }
}
