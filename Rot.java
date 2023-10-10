class Rot {

    // new array of points3d to hold the post rotation values

    /*
     * static double xr, yr, zr;
     * static Point3D[] rotated = {new Point3D(xr, yr, zr),new Point3D(xr, yr, zr),
     * new Point3D(xr, yr, zr), new Point3D(xr, yr, zr),
     * new Point3D(xr, yr, zr), new Point3D(xr, yr, zr),
     * new Point3D(xr, yr, zr), new Point3D(xr, yr, zr)};
     */

    // translating cube and arbitrary point to origin
    static Point3D[] arbPoint(Point3D[] v, double arbX, double arbY, double arbZ) {
        for (int i = 0; i < v.length; i++) {
            v[i].x -= arbX;
            v[i].y -= arbY;
            v[i].z -= arbZ;
        }
        return v;
    }

    // rotating each coordinate around the x axis
    static Point3D[] initRotate_X(Point3D[] v, double angle) {
        angle = angle * (Math.PI / 180);
        for (int i = 0; i < v.length; i++) {

            v[i].y = ((v[i].y * Math.cos(angle)) + (v[i].z * Math.sin(angle)));
            v[i].z = ((v[i].y * (-1) * Math.sin(angle)) + (v[i].z * Math.cos(angle)));
        }
        return v;
    }

    // rotating each coordinate around the y axis
    static Point3D[] initRotate_Y(Point3D[] v, double angle) {
        angle = angle * (Math.PI / 180);
        for (int i = 0; i < v.length; i++) {
            v[i].x = ((v[i].x * Math.cos(angle)) + (v[i].z * (-1) * Math.sin(angle)));
            v[i].z = ((v[i].x * Math.sin(angle)) + (v[i].z * Math.cos(angle)));
        }

        return v;

    }

    // rotating each coordinatre around z axis
    static Point3D[] initRotate_Z(Point3D[] v, double angle) {
        angle = angle * (Math.PI / 180);
        for (int i = 0; i < v.length; i++) {
            v[i].x = ((v[i].x * Math.cos(angle)) + (v[i].y * Math.sin(angle)));
            v[i].y = ((v[i].x * (-1) * Math.sin(angle)) + (v[i].y * Math.cos(angle)));
        }

        return v;
    }

    // pt 2 of arb point
    static Point3D[] arbPoint2(Point3D[] v, double arbX, double arbY, double arbZ) {
        for (int i = 0; i < v.length; i++) {
            v[i].x += arbX;
            v[i].y += arbY;
            v[i].z += arbZ;
        }

        return v;
    }

}