import java.util.ArrayList;

public class CoordsUtility {

    public static final double R = 6371e3; // Earth's radius in meters

    /**
     * Calculates distance in meters between two points or cumulative distance if list given
     * http://www.movable-type.co.uk/scripts/latlong.html
     */
    public static double calcDistance(TrkPoint a, TrkPoint b){

        double φ1 = Math.toRadians(a.getLat());
        double φ2 = Math.toRadians(b.getLat());
        double Δφ = Math.toRadians(b.getLat()-a.getLat());
        double Δλ = Math.toRadians(b.getLon()-a.getLon());

        double temp = Math.sin(Δφ/2) * Math.sin(Δφ/2) + Math.cos(φ1) * Math.cos(φ2) * Math.sin(Δλ/2) * Math.sin(Δλ/2);
        temp = 2 * Math.atan2(Math.sqrt(temp), Math.sqrt(1-temp));

        double result = R * temp;

        return result;
    }

    public static double calcDistance(ArrayList<TrkPoint> points){
        double result = 0;

        TrkPoint temp = points.get(0);
        for (int i = 1; i < points.size(); i++) {
            result += calcDistance(points.get(i), temp);
            temp = points.get(i);
        }

        return result;
    }
}
