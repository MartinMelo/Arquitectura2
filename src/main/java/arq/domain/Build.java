package arq.domain;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by Martin Alejandro on 4/11/2016.
 */
public class Build {

    public static Object build(String data,Class clase){
        try {
            return new ObjectMapper().readValue(data, clase);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
