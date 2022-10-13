package uk.ac.ed.inf;

public class CentralArea {
    private static CentralArea obj = new CentralArea();

    // bounding-box.geojson is the important one here
    private CentralArea() {
        obj = Download("https://ilp-rest.azurewebsites.net/", "centralArea");
    }

    public static CentralArea getCentralArea(){
        return obj;
    }
}
