package Storage;

import CatalogItems.CatalogItem.Book;
import CatalogItems.CatalogItem.CatalogItem;
import CatalogItems.CatalogItem.Movie;

import javax.sound.sampled.Line;
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
            Path file = Paths.get("..//SavedFiles//"+userName+".txt");
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
        List<String> lines = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        if(findTextFileBasedOn(userName))
        {
            for (CatalogItem catItem: catalogItems) {
                if(catItem.getClass().getName().equalsIgnoreCase("CatalogItems.CatalogItem.book"))
                {
                    lines.add("Book:");
                }
                else {
                    lines.add("Movie:");
                }
                temp = new StringBuilder();
                temp.append(catItem.getTitle()+"_");
                temp.append(catItem.getCreator()+"_");
                temp.append(catItem.getDescription()+"_");
                temp.append(catItem.getYear()+"_");
                temp.append(catItem.getGenre()+"_");
                temp.append(catItem.getRating()+"_");
                if(catItem.getClass().getName().equalsIgnoreCase("CatalogItems.CatalogItem.book"))
                {
                    temp.append(((Book) catItem).getStartDate()+"_");
                    temp.append(((Book) catItem).getFinishedDate()+"_");
                }
                else if(catItem.getClass().getName().equalsIgnoreCase("CatalogItems.CatalogItem.movie"))
                {
                    temp.append(((Movie) catItem).getWatchedDate()+"_");
                }
                lines.add(temp.toString());
            }
            Path file = Paths.get("SavedFiles/"+userName+".txt");
            try {
                Files.write(file, lines, Charset.forName("UTF-8"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else
        {
            System.out.println("This name has not yet been used please create the user and then save");
        }
    }

    public ArrayList<CatalogItem> loadCatalog(String userName)
    {
        ArrayList<CatalogItem> catalogItems = new ArrayList<>();
        if(findTextFileBasedOn(userName))
        {
            Path file = Paths.get("SavedFiles/"+userName+".txt");
            try {
                List<String> lines = Files.readAllLines(file);
                CatalogItem catalogItem = null;
                for (String line:lines) {
                    if(line.equalsIgnoreCase("book:"))
                    {
                        catalogItem = new Book();
                    }
                    else if(line.equalsIgnoreCase("movie:"))
                    {
                        catalogItem = new Movie();
                    }
                    else
                    {
                        String[] details = line.split("_",20);
                        if(catalogItem.getClass().getName().equalsIgnoreCase("CatalogItems.CatalogItem.book"))
                        {
                            catalogItem = new Book(details[0],details[1],details[3],Integer.parseInt(details[4]),details[5],Integer.parseInt(details[6]),details[7],details[8]);
                        }
                        else if(catalogItem.getClass().getName().equalsIgnoreCase("CatalogItems.CatalogItem.movie"))
                        {
                            catalogItem = new Movie(details[0],details[1],details[3],Integer.parseInt(details[4]),details[5],Integer.parseInt(details[6]),details[7]);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("User could not be found");
        }
        return catalogItems;
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
