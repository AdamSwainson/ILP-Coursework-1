package uk.ac.ed.inf;

import java.net.URL;
//Needs to be a factory method
public class Restaurant {

    String name;
    LngLat coord;
    Menu menu;

    /** Class Constructor
     *
     * @param name  String for the name of a restaurant
     * @param coord A LngLat coordinate corresponding to the location of the restaurant
     * @param menu  A Menu Object that stores the menu for a restaurant
     */
    public Restaurant(String name, LngLat coord, Menu menu) {
        this.name = name;
        this.coord = coord;
        this.menu = menu;
    }

    /** Parses the menu items from a restaurant
     *
     * @return  A list of Menu objects, each object containing a name of an item and its price
     */
  public Menu[] getMenu(){

      for (i = 0; i == menu.length)

      return null;
  }

    /**
     *
     * @param serverBaseAddress A URL object containing the base address of the REST server
     * @return                  A list of Restaurant items, with each containing a restaurant name,
     * It's coordinates, and a menu item
     */
  static Restaurant[] getRestaurantsFromRestServer(URL serverBaseAddress) {

      return null;
  }
}
