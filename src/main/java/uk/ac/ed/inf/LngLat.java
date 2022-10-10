package uk.ac.ed.inf;

public record LngLat( double lng, double lat) {

    public LngLat( double lng, double lat) {
        this.lng = lng;
        this.lat = lat;
    }
    
    public inCentralArea() {
        /** I would basically like to compare if the co-ordinates are within the bounds of the central area,
        * then return true. Will need to think about the singleton class for access to the central co-ordinates
        
        if (central1 <= lng <= central2) && (central3 <= lat <= central4) {
            return True
        } else {
            return False
        }
    }
    
    public distanceTo( LngLat coord){
        double a
        double b
        double c
        
        b = (abs(coord.lng - lng))^2
        c = (abs(coord.lat - lat))^2
        a = b^2 + c^2
        return a
    }
    
    /** difference of +/- 10^(-12) is fine
    public closeTo( LngLat coord){
        if (abs(coord.lng - lng)) <= 10^(-12){
            return True
        } else{
            return False
        }
    }
    
    /** straight line of 0.00015
    public nextPosition( int angle){
    
    double newLng
    double newLat
    
    /** We need to adjust for the angles
    
    newLng = lng + 0.00015*math.sin(angle)
    newLat = lat + 0.00015*math.cos(angle)
    
    LngLat nextCoord = new LngLat( newLng, newLat)
    return nextCoord
    }
}
