import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Client {
    private static final DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    private static News news;
    public News getNews() {
        return news;
    }

    Client() {
        updateData();
    }

    public static void updateData() {
        // Public function to be able to update the data.
        try {
            fetchData();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
    private static void fetchData() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(Constants.API_LINK.rawValue))
                .build();
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String body = response.body();
        InputStream input = client.send(request, HttpResponse.BodyHandlers.ofInputStream()).body();

        dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
        DocumentBuilder dBuilder = dbf.newDocumentBuilder();
        Document doc = dBuilder.parse(input);
        Element element = doc.getDocumentElement();
        NodeList nodeList = element.getElementsByTagName(Constants.ITEM.rawValue);
        String[] titles = new String[nodeList.getLength()];
        String[] dates = new String[nodeList.getLength()];
        String[] links = new String[nodeList.getLength()];
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;
                titles[i] = eElement.getElementsByTagName(Constants.TITLE.rawValue)
                        .item(0).getTextContent()
                        .replaceAll(Constants.REGEX.rawValue, "");
                dates[i] = eElement.getElementsByTagName(Constants.PUBLISH_DATE.rawValue).item(0).getTextContent();
                links[i] = eElement.getElementsByTagName(Constants.LINK.rawValue).item(0).getTextContent();
            }
        }
        news = new News(titles, dates, links);
    }
}
