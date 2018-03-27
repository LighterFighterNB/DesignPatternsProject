package API;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;

public class XMLReader {
    private BookAPI bookAPI;

    public XMLReader()
    {
        bookAPI = new BookAPI();
    }

    public Document createXML(String query)
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
                //String title = doc.getDocumentElement().getElementsByTagName("title").item(0).getTextContent();
                //System.out.println(title);
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
}
