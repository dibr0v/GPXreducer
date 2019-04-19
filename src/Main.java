import java.util.ArrayList;

public class Main {

    public static void main(String[] args){
        ArrayList<TrkPoint> points = new GPXparser().parse("recources/test_file_orig.gpx");

        TrkPoint paris = new TrkPoint("2.349014", "48.864716","0", "0");
        TrkPoint kyoto = new TrkPoint("135.753082", "35.028309","0", "0");

        System.out.println(CoordsUtility.calcDistance(paris, kyoto));
        System.out.println(CoordsUtility.calcDistance(points));
        /*
        for (TrkPoint i: points) {
            System.out.println(i.toString());
        }
        System.out.println(points.size());
        */
    }
}
