
public class Polar {
    double _r, _phi, _theta;


    /**
     * Constructor method
     * @param r the radius.
     * @param phi the phi.
     * @param theta the theta.
     *
     */

    Polar(double r, double phi, double theta) {
        this._r = r;
        this._phi = phi;
        this._theta = theta;
    }

    V3D Vector(){
        return new V3D(
                this._r * Math.sin(this._theta) * Math.cos(this._phi),
                this._r * Math.sin(this._theta) * Math.sin(this._phi),
                this._r * Math.cos(this._theta)

        );
    }


    /**
     * Prints the polar object
     */
    void Print(){
        System.out.printf("Polar(r=%f, phi=%f, theta=%f)", this._r, this._phi, this._theta);
    }
}