package uk.ac.ed.inf;

public class Menu {

        String name;
        int priceInPence;

        /** Class Constructor
         *
         * @param name          A string which stores the name of an item on the menu
         * @param priceInPence  An int storing the price of said menu item in pennies
         */
    public Menu(String name, int priceInPence) {
        this.name = name;
        this.priceInPence = priceInPence;
    }
}