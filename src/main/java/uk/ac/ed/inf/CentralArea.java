package uk.ac.ed.inf;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;

public class CentralArea {
    private static CentralArea obj = new CentralArea();

    private CentralArea() {

        //I think this is a misplay, should be outside the constructor, and the constructor is called to impart the
        // values received from the parsing
        try {
            URL defaultUrl = new URL("https://ilp-rest.azurewebsites.net/");
            obj = new ObjectMapper().readValue(defaultUrl, CentralArea.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static CentralArea getCentralArea(){
        return obj;
    }
}
