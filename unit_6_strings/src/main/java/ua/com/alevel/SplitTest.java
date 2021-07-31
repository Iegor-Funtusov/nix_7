package ua.com.alevel;

import java.util.ArrayList;
import java.util.List;

public class SplitTest {

    public void run() {
        String props = "host=127.0.0.1\n" +
                "port= 8080";

        List<KeyValue> keyValues = new ArrayList<>();

        String[] strings1 = props.split("\n");
        for (String s : strings1) {
            String[] split = s.split("=");
            keyValues.add(new KeyValue(split[0].trim(), split[1].trim()));
        }
    }

    private class KeyValue {

        private String key;
        private String value;

        public KeyValue(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
