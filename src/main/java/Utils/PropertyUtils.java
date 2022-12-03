package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public final class PropertyUtils {
    private PropertyUtils() {

    }

    public static Map<Object, Object> loadPropertyValuesInMap() {
        Properties prop = new Properties();
        Map<Object, Object> propertyMap = null;
        try {
            try (FileInputStream fis = new FileInputStream(ConstantFilePath.getPathtoresources())) {
                prop.load(fis);
            }
            propertyMap = new HashMap<>(prop);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return propertyMap;
    }

    public static String get(Object key) {
        if (Objects.isNull(key)) {
            throw new RuntimeException("key " + key.toString() + " doesn't exist");
        }
        return (String) loadPropertyValuesInMap().get(key.toString());
    }
}
