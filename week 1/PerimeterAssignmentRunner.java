import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start with prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // start with countNumPt = 0
        int countNumPt = 0;
        // for each point auxPt in the shape
        for (Point auxPt : s.getPoints()) {
            // update countNumPt by one more point
            countNumPt = countNumPt + 1;
        }
        // countNumPt is the answer
        return countNumPt;
    }

    public double getAverageLength(Shape s) {
        // start with totalPerimeter = 0.0
        double totalPerimeter = 0.0;
        // star with prevPt = the last point
        Point prevPt = s.getLastPoint();
        // star with countNumPt = 0
        int countNumPt = 0;
        // for each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // find distance from prevPt point to currPt
            double currDist = prevPt.distance(currPt);
            // update totalPerimeter by currDist
            totalPerimeter = totalPerimeter + currDist;
            // update prevPt by currPt
            prevPt = currPt;
            // update countNumPt by one more point
            countNumPt = countNumPt + 1;
        }
        // totalPerimeter divided by countNumPt is the answer
        return totalPerimeter / (double)countNumPt;
    }

    public double getLargestSide(Shape s) {
        // start with largestSide = 0.0
        double largestSide = 0.0;
        // start with prevPt = the last point
        Point prevPt = s.getLastPoint();
        // for each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // find distance from prevPt point to currPt
            double currDist = prevPt.distance(currPt);
            // check if currDist is largest than largestSide
            if(currDist > largestSide) {
                // update largestSide by currDist
                largestSide = currDist;
            }
            // update prevPt by currPt
            prevPt = currPt;
        }
        // largestSide is the answer
        return largestSide;
    }

    public double getLargestX(Shape s) {
        // start with largestX = 0.0
        double largestX = 0.0;
        // for each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // find the x coodinate of the currPt point
            double currX = currPt.getX();
            // check if currX is largest than largestX
            if(currX > largestX) {
                // update largestX by currX
                largestX = currX;
            }
        }
        // largestX is the answer
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // start with largestPerimeter = 0.0
        double largestPerimeter = 0.0;
        // start with new DirectoryResource object 
        DirectoryResource dr = new DirectoryResource();
        // for each file f in the directory,
        for (File f : dr.selectedFiles()) {
            // start with new FileResource object 
            FileResource fr = new FileResource(f);
            // start with new Shape object
            Shape s = new Shape(fr);
            // start with length = perimeter of s
            double length = getPerimeter(s);
            // check if length is largest than largestPerimeter
            if(length > largestPerimeter) {
                // update largestPerimeter by length
                largestPerimeter = length;
            }
        }
        // largestPerimeter is the answer
        return largestPerimeter;
    }

    public String getFileWithLargestPerimeter() {
        // start with largestPerimeter = 0.0
        double largestPerimeter = 0.0;
        // start with temp = null
        File temp = null;
        // start with new DirectoryResource object 
        DirectoryResource dr = new DirectoryResource();
        // for each file f in the directory,
        for (File f : dr.selectedFiles()) {
            // start with new FileResource object 
            FileResource fr = new FileResource(f);
            // start with new Shape object
            Shape s = new Shape(fr);
            // start with length = perimeter of s
            double length = getPerimeter(s);
            // check if length is largest than largestPerimeter
            if(length > largestPerimeter) {
                // update largestPerimeter by length
                largestPerimeter = length;
                // update temp by f
                temp = f;
            }
        }
        // the return of getName is the answer
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int numPoints = getNumPoints(s);
        double averageLh = getAverageLength(s);
        double largestSide = getLargestSide(s);
        double largestX = getLargestX(s);
        System.out.println("perimeter = " + length);
        System.out.println("number of points = " + numPoints);
        System.out.println("average length = " + averageLh);
        System.out.println("largest side = " + largestSide);
        System.out.println("largest x = " + largestX);
    }
    
    public void testPerimeterMultipleFiles() {
        double largestPerimeter = getLargestPerimeterMultipleFiles();
        System.out.println("largest perimeter = " + largestPerimeter);
    }

    public void testFileWithLargestPerimeter() {
        String nameLargestPerimeter = getFileWithLargestPerimeter();
        System.out.println(nameLargestPerimeter);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
        pr.testPerimeterMultipleFiles();
        pr.testFileWithLargestPerimeter();
    }
}
