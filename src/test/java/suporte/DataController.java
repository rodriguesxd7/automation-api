package suporte;

import java.util.HashMap;
import java.util.Map;

public class DataController {
    private static Map<String, String> data;

    public DataController(Map<String, String> hashmap) {
        data = hashmap;
    }

    public static Map<String, String> getData() {
        if (data == null) {
            data = new HashMap();
        }

        return data;
    }

    public static void put(String param, String value) {
        getData().put(param, value);
    }

    public static String get(String param) {
        return (String)getData().get(param);
    }

    public static void remove(String param) {
        getData().remove(param);
    }
}