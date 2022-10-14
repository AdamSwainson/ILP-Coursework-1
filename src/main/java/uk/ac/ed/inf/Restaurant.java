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

  public Menu[] getMenu(){
        // This will utilise the menu class, to return
      return null;
  }

  static Restaurant[] getRestaurantsFromRestServer(URL serverBaseAddress) {

      return null;
  }
}
