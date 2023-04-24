package data2;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class relate {
    public List<String> relate(String des, String[] characters) {
        List<String> characterList = new ArrayList<>();
        for (String character : characters) {
            if (des.contains(character)) {
                characterList.add(character);
            }
        }

        return characterList;
    }
}
