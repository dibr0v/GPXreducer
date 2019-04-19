import java.util.ArrayList;

public class Main {

    public static void main(String[] args){
        ArrayList<TrkPoint> points = new GPXparser().parse("recources/test_file.gpx");
        for (TrkPoint i: points) {
            System.out.println(i.toString());
        }
        System.out.println(points.size());
    }
}
