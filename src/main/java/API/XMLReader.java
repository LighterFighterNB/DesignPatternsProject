package API;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;

public class XMLReader {
    private BookAPI bookAPI;

    public XMLReader()
    {
        bookAPI = new BookAPI();
    }

    private Document createXML(String query)
    {
        String XMLtext = bookAPI.basicSearch(query);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db;
        Document doc = null;
        try
        {
            db = dbf.newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(XMLtext));
            try
            {
                doc = db.parse(is);
            }
            catch (SAXException e)
            {
                System.out.println("The document cannot be parsed");
            }
            catch (IOException e)
            {
                System.out.println("The document cannot be parsed");
            }
        }
        catch (ParserConfigurationException e1)
        {
            System.out.println("It cannot be parsed.");
        }
        return doc;
    }

    public ArrayList<String> getBooksTitle(String query)
    {
        Document doc = createXML(query);
        int length = doc.getDocumentElement().getElementsByTagName("title").getLength();
        ArrayList<String> titles = new ArrayList<>();
        for (int i=0; i<length; i++)
        {
            String title  = doc.getDocumentElement().getElementsByTagName("title").item(i).getTextContent();
            titles.add(title);
        }

        for (int i=0; i<titles.size(); i++)
        {
            System.out.println(titles.get(i));
        }
        return titles;
    }

    public HashMap<String, String> createBookDetails(String query)
    {
        Document doc = createXML(query);
        HashMap<String, String> bookDetails = new HashMap<>();
        bookDetails.put("Title", doc.getDocumentElement().getElementsByTagName("title").item(1).getTextContent());
        bookDetails.put("Year", doc.getDocumentElement().getElementsByTagName("original_publication_year").item(1).getTextContent());
        bookDetails.put("Rated", doc.getDocumentElement().getElementsByTagName("average_rating").item(1).getTextContent());
        bookDetails.put("Author", doc.getDocumentElement().getElementsByTagName("name").item(1).getTextContent());

        return bookDetails;
    }
}
