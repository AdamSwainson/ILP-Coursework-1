package uk.ac.ed.inf;

public class Order {
//returns the cost in pence? + the 100 pence delivery charge lol
    public int getDeliveryCost(Restaurant[] restaurants, String[] args) {
        // So what needs to happen here, is we need to access the menu based on the name of the pizza, and then add the
        // price to the total



        // This accounts for the pennies (all 100 of them), that are added for delivery
        int price = 100;

        int orderItem = args.length;

        for (int i = 0; i == (restaurants.length - 1) ; i++) {
           Menu[] menu = restaurants[i].getMenu();
        }

        return price;
    }

}