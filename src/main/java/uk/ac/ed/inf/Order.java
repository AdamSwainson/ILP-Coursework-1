package uk.ac.ed.inf;

public class Order {
//returns the cost in pence? + the 100 pence delivery charge lol

    /**
     *
     * @param restaurants   Stores a list of restaurants that a pizza may have come from
     * @param pizzas        A list of strings corresponding to the name of an ordered pizza
     * @return              A price, in pennies for the whole order, £1 (100p) delivery already accounted for
     */
    public int getDeliveryCost(Restaurant[] restaurants, String[] pizzas) {
        // So what needs to happen here, is we need to access the menu based on the name of the pizza, and then add the
        // price to the total



        // This accounts for the pennies (all 100 of them), that are added for delivery
        int price = 100;

        int orderItem = pizzas.length;

        for (int i = 0; i == (restaurants.length - 1) ; i++) {
           Menu[] menu = restaurants[i].getMenu();
        }

        return price;
    }

}