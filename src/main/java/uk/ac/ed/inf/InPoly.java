package uk.ac.ed.inf;

/* The basis of this class is that if a point is in a polygon, then an infinitely long straight
 * line will intersect it an odd amount of times if it is inside the polygon, and an even amount
 * if it is outside (In the general case). Heavily inspired by:
 * https://www.geeksforgeeks.org/how-to-check-if-a-given-point-lies-inside-a-polygon/
 */

public class InPoly {
    static double INF = 100000;

    /*This function checks to see if, from 3 collinear points, point q is on the line segment pr
     */
    static boolean onSegment(LngLat p, LngLat q, LngLat r) {

        if (q.lng() <= Math.max(p.lng(), r.lng()) &&
                q.lng() >= Math.min(p.lng(), r.lng()) &&
                q.lat() <= Math.max(p.lat(), r.lat()) &&
                q.lat() >= Math.min(p.lng(), r.lng()))
        {
            return true;
        }
        return false;
    }

    /* This function works out the orientation of 3 points, meaning which way do we rotate from p
     * to r through q. If there is no rotation (collinear), return 0, clockwise returns 1 and
     * anticlockwise returns 2
     */
    static int orientation(LngLat p, LngLat q, LngLat r) {

        int val = (int)((q.lat() - p.lat()) * (r.lng() - q.lng())
                - (q.lng() - p.lng()) * (r.lat() - q.lat()));

        if (val == 0) {
            return 0;
        } else if (val > 0) {
            return 1;
        }
        return 2;
    }


    /* If p1q1 and p2q2 intersect, then return true, otherwise false
     */
    static boolean doIntersect(LngLat p1, LngLat q1, LngLat p2, LngLat q2) {

        // Find the four orientations needed for
        // general and special cases
        int o1 = orientation(p1, q1, p2);
        int o2 = orientation(p1, q1, q2);
        int o3 = orientation(p2, q2, p1);
        int o4 = orientation(p2, q2, q1);

        // General case
        if ((o1 != o2) && (o3 != o4)) {
            return true;
        }

        // Special Cases
        // p1, q1 and p2 are collinear and
        // p2 lies on segment p1q1
        if ((o1 == 0) && onSegment(p1, p2, q1)) {
            return true;
        }

        // p1, q1 and p2 are collinear and
        // q2 lies on segment p1q1
        if ((o2 == 0) && onSegment(p1, q2, q1)) {
            return true;
        }

        // p2, q2 and p1 are collinear and
        // p1 lies on segment p2q2
        if ((o3 == 0) && onSegment(p2, p1, q2)) {
            return true;
        }

        // p2, q2 and q1 are collinear and
        // q1 lies on segment p2q2
        if ((o4 == 0) && onSegment(p2, q1, q2)) {
            return true;
        }

        // Doesn't fall in any of the above cases
        return false;
    }

    /*Returns true if the coordinate p is within polygon[]
     */
    static boolean isInside(LngLat polygon[], LngLat p) {

        // Create a point for line segment from p to infinite
        LngLat horizontalCoord = new LngLat(INF, p.lat());

        /* Counts the number of edges the horizontal line goes through, as they will
         * be counted twice
         */


        int n = polygon.length;
        int pointsTouched = 0;
        int intersections = 0;
        int currentCoord = 0;

        do {
            int nextCoord = (currentCoord + 1) % n;

            if (polygon[currentCoord].lat() == p.lat()) {
                pointsTouched++;
            }
            // Check if the line segment from 'p' to
            // 'extreme' intersects with the line
            // segment from 'polygon[i]' to 'polygon[next]'
            if (doIntersect(polygon[currentCoord], polygon[nextCoord], p, horizontalCoord)) {
                // If the point 'p' is collinear with line
                // segment 'i-next', then check if it lies
                // on segment. If it lies, return true, otherwise false
                if (orientation(polygon[currentCoord], p, polygon[nextCoord]) == 0) {
                    return onSegment(polygon[currentCoord], p, polygon[nextCoord]);
                }

                intersections++;
            }
            currentCoord = nextCoord;
        } while (currentCoord != 0);

        // Reduce the count by decrease amount
        // as these points would have been added twice
        intersections -= pointsTouched;

        // Return true if count is odd, false otherwise
        return (intersections % 2 == 1);
    }
}