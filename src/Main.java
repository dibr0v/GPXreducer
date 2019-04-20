import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

import static java.time.temporal.ChronoUnit.DAYS;

public class Main {

    public static void main(String[] args){
        ArrayList<TrkPoint> points = new GPXparser().parse("recources/test_file_orig.gpx");

        TrkPoint paris = new TrkPoint("2.349014", "48.864716","0", "2018-12-31T00:00:00Z", null);
        TrkPoint kyoto = new TrkPoint("135.753082", "35.028309","0", "2019-01-01T01:00:00Z", null);
        System.out.println(CoordsUtility.calcDistance(paris, kyoto)/1000+" km");
        System.out.println(CoordsUtility.calcDuration(paris, kyoto)/3600.0+" hrs");

        //System.out.println(CoordsUtility.calcDistance(points));
        //System.out.println(CoordsUtility.calcDuration(points.get(0), points.get(5)));

        /*
        for(TrkPoint i: points)
            System.out.println(i.toString());
        */

        /*
        CoordsUtility CU = new CoordsUtility();
        double m;
        long sec;
        for(int i = 1 ; i < points.size(); i++){
            m = CoordsUtility.calcDistance(points.get(i-1), points.get(i));
            sec = CoordsUtility.calcDuration(points.get(i-1), points.get(i));
            if(sec == 0) {
                System.out.println(m + " meters for " + sec + " seconds (" + m / sec * 3.6 + "km/h)");
                System.out.println(points.get(i-1));
                System.out.println(points.get(i));
                System.out.println();
            }
        }
        System.out.println(CU.calcDistance(points)+" "+CU.calcDuration(points));
        */
    }
}
