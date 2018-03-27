package Storage;

import CatalogItems.CatalogItem.CatalogItem;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TextFile {
    private String fileLocation = "C://";

    public TextFile()
    {

    }

    public void createNewTextFile(String userName)
    {
        if(!findTextFileBasedOn(userName))
        {
            List<String> lines = Arrays.asList("The first line", "The second line");
            Path file = Paths.get("SavedFiles"+userName+".txt");
            try {
                Files.write(file, lines, Charset.forName("UTF-8"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else
        {
            System.out.println("File Already created choose another name or load the already created file");
        }
    }

    public void saveToTextFile(String userName, ArrayList<CatalogItem> catalogItems)
    {
        if(findTextFileBasedOn(userName))
        {

        }
        else
        {
            System.out.println("This name has not yet been used please create the user and then save");
        }
    }

    public ArrayList<CatalogItem> loadCatalog(String userName)
    {
        return null;
    }

    public boolean findTextFileBasedOn(String parm)
    {
        try (Stream<Path> paths = Files.walk(Paths.get("SavedFiles"))) {
            paths.filter(Files::isRegularFile).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
