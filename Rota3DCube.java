import java.util.Scanner;

public class Rota3DCube {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        // parameter variables
        double ax, ay, az;
        double alpha;
        String axisOfRot = "";

        // prompt menu , get user inputs
        System.out.println("Enter the following parameters: ");
        System.out.println("1. Arbitrary Point A(a1, a2, a3) ");
        // arbitrary point
        ax = input.nextDouble();
        ay = input.nextDouble();
        az = input.nextDouble();

        // angle of rotation
        System.out.println("2. Desired Angle of Rotation ");
        alpha = input.nextDouble();

        // principle axis of rotation
        System.out.println("3. Principle Axis of Rotation (x_axis, y_axis, or z_axis)");
        axisOfRot = input.next();

        // original cube position
        Point3D[] original = {
                new Point3D(0, 0, 0), new Point3D(1, 0, 0),
                new Point3D(1, 0, 1), new Point3D(0, 0, 1),
                new Point3D(0, 1, 1), new Point3D(1, 1, 1),
                new Point3D(1, 1, 0), new Point3D(0, 1, 0) };

        Point3D[] actual = {
                new Point3D(0, 0, 0), new Point3D(1, 0, 0),
                new Point3D(1, 0, 1), new Point3D(0, 0, 1),
                new Point3D(0, 1, 1), new Point3D(1, 1, 1),
                new Point3D(1, 1, 0), new Point3D(0, 1, 0) };

        // cube positioning
        // check whether angle of rotation is in range & axis is x, y, or z
        // check what axis is being rotated around

        if (axisOfRot.equals("x_axis")) {

            actual = Rot.arbPoint(actual, ax, ay, az);
            actual = Rot.initRotate_X(actual, alpha);
            actual = Rot.arbPoint2(actual, ax, ay, az);
        }

        else if (axisOfRot.equals("y_axis")) {

            actual = Rot.arbPoint(actual, ax, ay, az);
            actual = Rot.initRotate_Y(actual, alpha);
            actual = Rot.arbPoint2(actual, ax, ay, az);

        }

        else if (axisOfRot.equals("z_axis")) {
            actual = Rot.arbPoint(actual, ax, ay, az);
            actual = Rot.initRotate_Z(actual, alpha);
            actual = Rot.arbPoint2(actual, ax, ay, az);

        }

        // output statement
        System.out.printf("\nRotate unit cube " + "%.6f" + " radians about "
                + axisOfRot + " at point " + "(" + "%.6f" + " " + "%.6f" + ", " + "%.6f" + ")",
                (alpha * (Math.PI / 180)), ax, ay, az);

        // print initial vertices
        System.out.println("\n\tInitial Vertices");

        // output all old and new vertices coordinates
        int num = 0;
        for (int i = 0; i < original.length; i++) {
            System.out.printf("\n" + num + ": %.6f" + " " + "%.6f" + " " + "%.6f", original[i].x, original[i].y,
                    original[i].z);
            num += 1;
        }

        // print rotated vertices
        System.out.println("\nRotated Vertices");
        int newnum = 0;
        for (int i = 0; i < actual.length; i++) {
            System.out.printf("\n" + newnum + ": %.6f" + " " + "%.6f" + " " + "%.6f", actual[i].x, actual[i].y,
                    actual[i].z);
            newnum += 1;

        }
    }
}