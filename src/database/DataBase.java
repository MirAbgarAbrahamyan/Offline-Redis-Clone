package database;

import java.util.*;

public class DataBase {
    public static Map<String, Object> db = new LinkedHashMap<>();

    public static void addString(String key, String value) {
        db.put(key, value);
    }

    public static void addList(String key, List<String> value) {
        db.put(key, value);
    }

    public static void addMap(String key, Map<String, String> value) {
        db.put(key, value);
    }

    public static void addSet(String key, Set<String> value) {
        db.put(key, value);
    }

    public static void showDB() {
        db.forEach((key, value) -> System.out.println(key + " = " + value));
    }
}
