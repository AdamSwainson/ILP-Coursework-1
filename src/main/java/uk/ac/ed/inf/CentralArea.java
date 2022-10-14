package uk.ac.ed.inf;

import java.io.IOException;
import java.net.URL;

public static final CentralArea {
    
    private static CentralArea obj;
    
    public LngLat[] GetCentralArea() {
        try {
            URL defaultUrl = new URL("https://ilp-rest.azurewebsites.net/");
            LngLat[]  = new ObjectMapper().readValue(defaultUrl, LngLat[].class);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

    public static CentralArea getInstance(){
        if (obj == null){
            obj = new CentralArea();
        }
        return obj;
    }
}
