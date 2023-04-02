import java.util.HashMap;
import java.util.Map;

public class ProtocolEncoder {
    public static String encodeData(HashMap<String, String> dataHashMap) {
        StringBuilder encodedBuilder = new StringBuilder();

        for (Map.Entry<String, String> entry: dataHashMap.entrySet()) {
            String title = entry.getKey();
            String description = entry.getValue();

            encodedBuilder.append(title).append(":\n").append(description);
        }

        return encodedBuilder.toString();
    }

    public static HashMap<String, String> decodeData(String encodedData) {
        HashMap<String, String> dataHashMap = new HashMap<>();
        String[] lines = encodedData.split("\n");

        for (int i=0; i<lines.length; i += 2) {
            assert lines[i].endsWith(":");
            assert i + 1 < lines.length;
            dataHashMap.put(lines[i], lines[i + 1]);
        }

        return dataHashMap;
    }
}
