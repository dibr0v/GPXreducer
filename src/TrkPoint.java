public class TrkPoint {

    private double lon;
    private double lat;
    private double ele;
    private String time;

    public TrkPoint(String lon, String lat, String ele, String time){
        this.lon = Double.parseDouble(lon);
        this.lat = Double.parseDouble(lat);
        this.ele = Double.parseDouble(ele);
        this.time = time;
    }

    @Override
    public String toString() {
        return lon+" "+lat+" "+ele+" "+time;
    }
}