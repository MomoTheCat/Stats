import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Stations;

import java.util.Arrays;
import java.util.List;

/**
 * Created by szymon on 01.03.2017.
 */
public class JsonParser {
    private static ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }


//    public static List<Stations> parseStations(JSONObject json) {
//        List<Stations> stations = null;
//        try {
//            stations = Arrays.asList(mapper.readValue(json.getJSONObject("network").toString(),
//                    Stations[].class));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return stations;
//    }
}
