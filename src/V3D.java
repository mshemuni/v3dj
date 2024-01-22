

public class V3D {
    double _x, _y, _z;
    double eps = 0.001;

    /**
     * This is a constructor method.
     *
     * @param x the x coordinate of the vector.
     * @param y the y coordinate of the vector.
     * @param z the z coordinate of the vector.
     */
    V3D(double x, double y, double z) {
        this._x = x;
        this._y = y;
        this._z = z;
    }


    /**
     * This is a constructor method.
     */
    V3D() {
        this._x = this._y = this._z = 0;
    }


    /**
     * This is a constructor method.
     *
     * @param points the x, y, and z coordinates of the vector.
     */
    V3D(double[] points) throws Exception {
        if (points.length != 3) {
            throw new Exception("V3D needs 3 points");
        }
        this._x = points[0];
        this._y = points[1];
        this._z = points[2];
    }


    /**
     * Creates a vector from polar.
     *
     * @param point Polar object of a polar coordinates.
     * @return A vector at polar point.
     */
    public static V3D FromPolar(Polar point) {
        double x = point._r * Math.sin(point._theta) * Math.cos(point._phi);
        double y = point._r * Math.sin(point._theta) * Math.sin(point._phi);
        double z = point._r * Math.cos(point._theta);
        return new V3D(x, y, z);
    }


    /**
     * Creates a vector from polar.
     *
     * @param r     radius of polar coordinate.
     * @param phi   phi angle of polar coordinate.
     * @param theta theta angle of polar coordinate.
     * @return A vector at polar point.
     */
    public static V3D FromPolar(double r, double phi, double theta) {
        double x = r * Math.sin(theta) * Math.cos(phi);
        double y = r * Math.sin(theta) * Math.sin(phi);
        double z = r * Math.cos(theta);
        return new V3D(x, y, z);
    }


    /**
     * Checks if the two vectors are the same.
     *
     * @return true if two vectors are the same, false otherwise.
     */
    boolean IsSame(V3D other) {
        return Math.abs(this._x - other._x) < eps &&
                Math.abs(this._y - other._y) < eps &&
                Math.abs(this._z - other._z) < eps;
    }


    /**
     * Returns a copy of the vector.
     *
     * @return The copy of the vector.
     */
    V3D Copy() {
        return new V3D(this._x, this._y, this._z);
    }


    /**
     * Calculates the dot product of two vectors.
     *
     * @param other the other vector.
     * @return calculated dot product of this and other.
     */
    double Dot(V3D other) {
        return this._x * other._x + this._y * other._y + this._z * other._z;
    }


    /**
     * Calculates the cross product of two vectors.
     *
     * @param other the other vector.
     * @return calculated cross product of this and other.
     */
    V3D Cross(V3D other) {
        return new V3D(
                this._y * other._z - this._z * other._y,
                this._z * other._x - this._x * other._z,
                this._x * other._y - this._y * other._x);
    }

    /**
     * Scales a vector.
     *
     * @param scalar the scalar value.
     * @return scaled vector.
     */
    V3D Scale(double scalar) {
        return new V3D(
                this._x * scalar,
                this._y * scalar,
                this._z * scalar
        );
    }


    /**
     * Multiplies a vector by another one (cross product).
     *
     * @param other the other vector.
     * @return calculated cross product of this and other.
     */
    V3D Mul(V3D other) {
        return this.Cross(other);
    }


    /**
     * Multiplies a vector by a scalar (scale).
     *
     * @param other the scalar.
     * @return scaled vector.
     */
    V3D Mul(double other) {
        return this.Scale(other);
    }

    /**
     * Divides a vector by a scalar (scale).
     *
     * @param other the scalar.
     * @return scaled vector.
     */
    V3D Div(double other) {
        return this.Scale(1.0 / other);
    }


    /**
     * Adds two vectors.
     *
     * @param other the other vector.
     * @return the calculated vector.
     */
    V3D Add(V3D other) {
        return new V3D(
                this._x + other._x,
                this._y + other._y,
                this._z + other._z
        );
    }


    /**
     * Adds a scalar to the vectors.
     *
     * @param other the scalar.
     * @return the calculated vector.
     */
    V3D Add(double other) {
        return new V3D(
                this._x + other,
                this._y + other,
                this._z + other
        );
    }


    /**
     * Subtracts two vectors.
     *
     * @param other the other vector.
     * @return the calculated vector.
     */
    V3D Sub(V3D other) {
        return new V3D(
                this._x - other._x,
                this._y - other._y,
                this._z - other._z
        );
    }


    /**
     * Subtracts a scalar from vectors.
     *
     * @param other the other vector.
     * @return the calculated vector.
     */
    V3D Sub(double other) {
        return new V3D(
                this._x - other,
                this._y - other,
                this._z - other
        );
    }


    /**
     * Calculates the distance of two points.
     *
     * @param other the other vector.
     * @return the calculated distance.
     */
    double Dist(V3D other) {
        return Math.sqrt(
                Math.pow(this._x - other._x, 2) + Math.pow(this._y - other._y, 2) + Math.pow(this._z - other._z, 2)
        );
    }


    /**
     * Calculates the length of the vector.
     *
     * @return the length.
     */
    double Mag() {
        return this.Dist(new V3D());
    }


    /**
     * Calculates the heading of the vector.
     *
     * @return the calculated heading as a Polar object. r is 0.
     */
    Polar Heading() {
        double r = this.Mag();
        return new Polar(
                0,
                Math.acos(this._z / r),
                Math.atan2(this._y, this._x)
        );

    }


    /**
     * Calculates the unit vector.
     *
     * @return the unit vector.
     */
    V3D Unit() {
        double mag = this.Mag();
        return this.Div(mag);
    }


    /**
     * Calculates the angle between two vectors.
     *
     * @param other the other vector.
     * @return the angle between.
     */
    double AngleBetween(V3D other) throws Exception {
        if (this.Mag() == 0 || other.Mag() == 0) {
            throw new Exception("Cannot calculate angle between a vector with 0 length");
        }
        V3D unit_other = other.Unit();
        V3D unit_self = this.Unit();
        if (unit_self.IsSame(unit_other)) {
            return 0;
        }
        return Math.acos(this.Dot(other) / (this.Mag() * other.Mag()));
    }


    /**
     * Calculates the normal vector of two vectors.
     *
     * @param other the other vector.
     * @return the calculated normal vector.
     */
    V3D Normal(V3D other) {
        return this.Mul(other).Unit();
    }


    /**
     * Checks if two vector are parallel.
     *
     * @param other the other vector.
     * @return true if two vectors are parallel.
     */
    boolean IsParallel(V3D other) {
        return this.Mul(other).Mag() == 0;
    }


    /**
     * Checks if two vector are perpendicular.
     *
     * @param other the other vector.
     * @return true if two vectors are perpendicular.
     */
    boolean IsPerpendicular(V3D other) {
        return this.Dot(other) == 0;
    }


    /**
     * Checks if two vector are neither parallel nor perpendicular.
     *
     * @param other the other vector.
     * @return true if two vectors are neither parallel nor perpendicular.
     */
    boolean IsNonparallel(V3D other) {
        return !(this.IsParallel(other) || this.IsPerpendicular(other));
    }


    /**
     * Rotates a vector around another one.
     *
     * @param other the other vector.
     * @param angle the angle of rotation.
     * @return the rotated vector.
     */
    V3D RotateAbout(V3D other, double angle) {
        return this.Mul(Math.cos(angle)).Add(other.Mul(this).Mul(Math.sin(angle))).Add(other.Mul(other.Dot(this)).Mul(1 - Math.cos(angle)));
    }

    /**
     * Rotates a vector around major axis.
     *
     * @param alpha the angle of rotation around x axes.
     * @param beta the angle of rotation around y axes.
     * @param gamma the angle of rotation around z axes.
     * @return the rotated vector.
     */
     V3D Rotate(double alpha, double beta, double gamma) {
        V3D vec = this.Copy();
        double x = vec._x;
        double y = vec._y * Math.cos(alpha) - vec._z * Math.sin(alpha);
        double z = vec._y * Math.sin(alpha) + vec._z * Math.cos(alpha);
        vec = new V3D(x, y, z);

        x = vec._x * Math.cos(beta) + vec._z * Math.sin(beta);
        y = vec._y;
        z = -vec._x * Math.sin(beta) + vec._z * Math.cos(beta);
        vec = new V3D(x, y, z);

        x = vec._x * Math.cos(gamma) - vec._y * Math.sin(gamma);
        y = vec._x * Math.sin(gamma) + vec._y * Math.cos(gamma);
        z = vec._z;
        vec = new V3D(x, y, z);

        return vec;
    }

    /**
     * Prints the vector
     */
    void Print() {
        System.out.printf("Vector(x=%f, y=%f, z=%f)", this._x, this._y, this._z);
    }

}
