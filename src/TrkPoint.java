import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TrkPoint {

    private double lon;
    private double lat;
    private double ele;
    private LocalDate date;
    private LocalTime time;
    private Node extensions;  // stores possible additional data like heart rate etc.

    public double getLon(){return lon;}
    public double getLat(){return lat;}
    public double getEle(){return ele;}
    public LocalDate getDate(){return date;}
    public LocalTime getTime(){return time;}

    public TrkPoint(String lon, String lat, String ele, String date_time, Node extensions){
        this.lon = Double.parseDouble(lon);
        this.lat = Double.parseDouble(lat);
        this.ele = Double.parseDouble(ele);
        this.date = LocalDate.parse(date_time.substring(0, 10));    //YYYY-MM-DDTHH:MM:SSZ  ISO datetime format
        this.time = LocalTime.parse(date_time.substring(11, 19));
        this.extensions = extensions;
    }

    @Override
    public String toString() {
        StringBuilder sb;
        sb = new StringBuilder(lon+" "+lat+" "+ele+" "+time.toString());
        if(extensions != null)
            sb.append(" "+extensions.getTextContent());
        return sb.toString();
    }
}
