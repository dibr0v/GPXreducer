import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Parses points from *.gpx file according to
 * http://www.topografix.com/GPX/1/1/
 */
public class GPXparser {

    public ArrayList<TrkPoint> parse(String path){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document document = null;
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.parse(new File(path));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        document.getDocumentElement().normalize();

        NodeList nodeList = document.getElementsByTagName("trkpt");
        if(nodeList.getLength() == 0)
            return null;
        ArrayList<TrkPoint> points = new ArrayList<>();
        String lon, lat, ele, datetime;
        Node extensions;
        for(int i = 0; i < nodeList.getLength(); i++){
            Node node = nodeList.item(i);
            if(node.getNodeType() == Node.ELEMENT_NODE){
                Element element = (Element) node;
                lon = element.getAttribute("lon");
                lat = element.getAttribute("lat");
                ele = element.getElementsByTagName("ele").item(0).getTextContent();
                datetime = element.getElementsByTagName("time").item(0).getTextContent();

                /*
                <extensions>
                    <gpxtpx:TrackPointExtension>
                        <gpxtpx:hr>112</gpxtpx:hr>
                        ...
                    </gpxtpx:TrackPointExtension>
                </extensions>
                */
                extensions = element.getElementsByTagName("extensions").item(0);

                if(     !lon.isEmpty() &&
                        !lat.isEmpty() &&
                        !ele.isEmpty() &&
                        !datetime.isEmpty())
                points.add(new TrkPoint(lon, lat, ele, datetime, extensions));
            }
        }
        return points;
    }
}
