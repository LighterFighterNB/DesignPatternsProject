package API;

import java.util.ArrayList;
import java.util.HashMap;

public interface APIReader {
    ArrayList<String> getTitles (String query);
    HashMap<String, String> createDetails (String query);
}
