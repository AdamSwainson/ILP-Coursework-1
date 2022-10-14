package uk.ac.ed.inf;

public record LngLat(
        double lng,
        double lat)
{

        /** Class constructor
         *
         * @param lng A double corresponding to the longitudinal co-ordinate of the point
         * @param lat A double corresponding to the latitudinal co-ordinate of the point
         */
    public LngLat( double lng, double lat) {
        this.lng = lng;
        this.lat = lat;
    }

    /** Finds if the drone has entered the central area
     *
     * @return True if the current co-ordinate of the drone is within the central area, false otherwise
     */
    public boolean inCentralArea() {

        LngLat coord = new LngLat(lng, lat);
        return InPoly.isInside(CentralArea.getCentralArea(), coord);
    }

    /** Calculates the straight-line distance between the position of the drone and a chosen co-ordinate
     *
     * @param  coord A LngLat co-ordinate
     * @return       The straight-line distance between the drones position and the parameter co-ordinate
     */
    public double distanceTo( LngLat coord) {

        double a;
        double b;
        double c;

        b = (Math.abs(coord.lng - lng));
        c = (Math.abs(coord.lat - lat));
        a = b*b + c*c;
        return a;
    }

    //Math.pow(10, -12)) for the rounding errors

    /** This method checks to see if two points are considered close to each other, meaning strictly closer than
     * 0.00015 degrees of each other
     *
     * @param  coord A LngLat co-ordinate that is checked against the current position of the drone
     * @returns      True if they are less than one straight-line movement away from each other, false otherwise
     */
    public boolean closeTo( LngLat coord) {

        if (Math.abs((coord.lng - lng)) < 0.00015) {
            return true;
        }
        return false;
    }

    /** Calculates the vertical and horizontal components of a movement in the given direction
     * adds it to the vertical and horizontal coordinates to find the position after the
     * movement
     *
     * @param  angle The angle of the direction of movement, taking 0 as east, moving anticlockwise
     * @return       The coordinate that will be reached after executing the movement
     */
    public LngLat nextPosition( int angle) {

        double newLng;
        double newLat;

        // We need to adjust for the angles

        newLng = lng + 0.00015*Math.sin(angle);
        newLat = lat + 0.00015*Math.cos(angle);

        LngLat nextCoord = new LngLat( newLng, newLat);
        return nextCoord;
    }
}
