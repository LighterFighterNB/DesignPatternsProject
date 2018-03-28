package API;

import java.util.ArrayList;
import java.util.HashMap;

public class XMLReaderAdapter implements APIReader{

    XMLReader xmlReader;

    public XMLReaderAdapter(XMLReader newXmlReader)
    {
        xmlReader = newXmlReader;
    }

    public ArrayList<String> getTitles(String query)
    {
        ArrayList<String> booksTitle = xmlReader.getBooksTitle(query);
        return booksTitle;
    }

    public HashMap<String, String> createDetails(String query)
    {
        HashMap<String, String> bookDetails = xmlReader.createBookDetails(query);
        return bookDetails;
    }
}
