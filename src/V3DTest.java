import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class V3DTest {
    double eps = 0.001;

    @Test
    public void testConstruction() throws Exception {
        V3D v3ctor1 = new V3D();
        V3D v3ctor2 = new V3D(0, 0, 0);
        V3D v3ctor3 = new V3D(new double[]{0, 0, 0});

        assertTrue(v3ctor1.IsSame(v3ctor2));
        assertTrue(v3ctor2.IsSame(v3ctor3));
    }

    @Test
    public void testConstructionException() {
        assertThrows(Exception.class, () -> {
            new V3D(new double[]{0, 0, 0, 0});
        });
    }

    @Test
    public void testIsSame() {
        V3D v3ctor1 = new V3D(0, 0, 0);
        V3D v3ctor2 = new V3D(0, 0, 0);
        V3D v3ctor3 = new V3D(1, 0, 0);

        assertTrue(v3ctor1.IsSame(v3ctor2));
        assertFalse(v3ctor2.IsSame(v3ctor3));
    }

    @Test
    public void testCopy() {
        V3D v3ctor1 = new V3D(0, 0, 0);
        V3D v3ctor2 = v3ctor1.Copy();

        assertTrue(v3ctor1.IsSame(v3ctor2));
    }

    @Test
    public void testDot() {
        V3D v3ctor1 = new V3D(1, 2, 3);
        V3D v3ctor2 = new V3D(4, 5, 6);

        assertEquals(v3ctor1.Dot(v3ctor2), 32);
    }

    @Test
    public void testCross() {
        V3D v3ctor1 = new V3D(1, 2, 3);
        V3D v3ctor2 = new V3D(4, 5, 6);

        assertTrue(v3ctor1.Cross(v3ctor2).IsSame(new V3D(-3, 6, -3)));
    }

    @Test
    public void testScale() {
        V3D v3ctor1 = new V3D(1, 2, 3);
        V3D v3ctor2 = v3ctor1.Scale(2);

        assertTrue(v3ctor2.IsSame(new V3D(2, 4, 6)));
    }

    @Test
    public void testMulScalarInteger() {
        V3D v3ctor1 = new V3D(1, 2, 3);
        V3D v3ctor2 = v3ctor1.Mul(2);
        V3D v3ctor3 = v3ctor1.Scale(2);


        assertTrue(v3ctor2.IsSame(v3ctor3));
    }

    @Test
    public void testMulScalarDouble() {
        V3D v3ctor1 = new V3D(1, 2, 3);
        V3D v3ctor2 = v3ctor1.Mul(2.2);
        V3D v3ctor3 = v3ctor1.Scale(2.2);


        assertTrue(v3ctor2.IsSame(v3ctor3));
    }

    @Test
    public void testMulVector() {
        V3D v3ctor1 = new V3D(1, 2, 3);
        V3D v3ctor2 = new V3D(4, 5, 6);
        V3D v3ctor3 = v3ctor1.Mul(v3ctor2);
        V3D v3ctor4 = v3ctor1.Cross(v3ctor2);


        assertTrue(v3ctor3.IsSame(v3ctor4));
    }

    @Test
    public void testDivInteger() {
        V3D v3ctor1 = new V3D(2, 4, 6);
        V3D v3ctor2 = v3ctor1.Div(2);

        assertTrue(v3ctor2.IsSame(new V3D(1, 2, 3)));
    }

    @Test
    public void testDivDouble() {
        V3D v3ctor1 = new V3D(2, 4, 6);
        V3D v3ctor2 = v3ctor1.Div(2.0);

        assertTrue(v3ctor2.IsSame(new V3D(1, 2, 3)));
    }

    @Test
    public void testAddVector() {
        V3D v3ctor1 = new V3D(1, 2, 3);
        V3D v3ctor2 = new V3D(2, 4, 6);
        V3D v3ctor3 = v3ctor1.Add(v3ctor2);


        assertTrue(v3ctor3.IsSame(new V3D(3, 6, 9)));
    }

    @Test
    public void testAddInteger() {
        V3D v3ctor1 = new V3D(1, 2, 3);
        V3D v3ctor2 = v3ctor1.Add(2);

        assertTrue(v3ctor2.IsSame(new V3D(3, 4, 5)));
    }

    @Test
    public void testAddDouble() {
        V3D v3ctor1 = new V3D(1, 2, 3);
        V3D v3ctor2 = v3ctor1.Add(2.0);

        assertTrue(v3ctor2.IsSame(new V3D(3, 4, 5)));
    }


    @Test
    public void testSubVector() {
        V3D v3ctor1 = new V3D(1, 2, 3);
        V3D v3ctor2 = new V3D(2, 4, 6);
        V3D v3ctor3 = v3ctor1.Sub(v3ctor2);


        assertTrue(v3ctor3.IsSame(new V3D(-1, -2, -3)));
    }

    @Test
    public void testSubInteger() {
        V3D v3ctor1 = new V3D(1, 2, 3);
        V3D v3ctor2 = v3ctor1.Sub(2);

        assertTrue(v3ctor2.IsSame(new V3D(-1, 0, 1)));
    }

    @Test
    public void testSubDouble() {
        V3D v3ctor1 = new V3D(1, 2, 3);
        V3D v3ctor2 = v3ctor1.Sub(2.0);

        assertTrue(v3ctor2.IsSame(new V3D(-1, 0, 1)));
    }

    @Test
    public void testDist() {
        V3D v3ctor1 = new V3D(1, 1, 1);
        V3D v3ctor2 = new V3D(1, 1, 2);

        assertEquals(v3ctor1.Dist(v3ctor2), 1);
    }

    @Test
    public void testMag() {
        V3D v3ctor1 = new V3D(0, 0, 1);

        assertEquals(v3ctor1.Mag(), 1);
    }

    @Test
    public void testHeading() {
        V3D v3ctor1 = new V3D(1, 2, 3);
        Polar polar = v3ctor1.Heading();
        assertTrue(Math.abs(polar._phi - 0.640522) < eps);
        assertTrue(Math.abs(polar._theta - 1.107148) < eps);
    }

    @Test
    public void testUnit() {
        V3D v3ctor1 = new V3D(10, 10, 30);
        V3D unit = v3ctor1.Unit();
        assertTrue(Math.abs(unit.Mag() - 1) < eps);
    }

    @Test
    public void testAngleBetween() throws Exception {
        V3D v3ctor1 = new V3D(1, 0, 0);
        V3D v3ctor2 = new V3D(0, 1, 0);
        double angle = v3ctor1.AngleBetween(v3ctor2);
        assertTrue(Math.abs(angle - Math.PI / 2) < eps);
    }

    @Test
    public void testAngleBetweenException() {
        V3D v3ctor1 = new V3D(0, 0, 0);
        V3D v3ctor2 = new V3D(0, 1, 0);
        assertThrows(Exception.class, () -> {
            double angle = v3ctor1.AngleBetween(v3ctor2);
        });
    }

    @Test
    public void testNormal() throws Exception {
        V3D v3ctor1 = new V3D(1, 0, 0);
        V3D v3ctor2 = new V3D(0, 1, 0);
        V3D v3ctor3 = v3ctor1.Normal(v3ctor2);
        assertTrue(Math.abs(v3ctor1.AngleBetween(v3ctor3) - Math.PI / 2) < eps);
        assertTrue(Math.abs(v3ctor2.AngleBetween(v3ctor3) - Math.PI / 2) < eps);
    }

    @Test
    public void testIsParallel() {
        V3D v3ctor1 = new V3D(1, 0, 0);
        V3D v3ctor2 = new V3D(10, 0, 0);
        V3D v3ctor3 = new V3D(10, 1, 0);
        assertTrue(v3ctor1.IsParallel(v3ctor2));
        assertFalse(v3ctor1.IsParallel(v3ctor3));
    }

    @Test
    public void testIsPerpendicular() {
        V3D v3ctor1 = new V3D(1, 0, 0);
        V3D v3ctor2 = new V3D(0, 1, 0);
        V3D v3ctor3 = new V3D(1, 1, 0);
        assertTrue(v3ctor1.IsPerpendicular(v3ctor2));
        assertFalse(v3ctor1.IsPerpendicular(v3ctor3));
    }

    @Test
    public void testIsNonparallel() {
        V3D v3ctor1 = new V3D(1, 0, 0);
        V3D v3ctor2 = new V3D(1, 1, 1);
        V3D v3ctor3 = new V3D(0, 1, 0);
        V3D v3ctor4 = new V3D(0, 0, 1);
        assertTrue(v3ctor1.IsNonparallel(v3ctor2));
        assertFalse(v3ctor1.IsNonparallel(v3ctor3));
        assertFalse(v3ctor1.IsNonparallel(v3ctor4));
    }

    @Test
    public void testRotateAbout() {
        V3D v3ctor1 = new V3D(1, 0, 0);
        V3D v3ctor2 = new V3D(0, 1, 0);
        V3D v3ctor3 = v3ctor1.RotateAbout(v3ctor2, Math.PI);
        assertTrue(v3ctor3.IsSame(new V3D(-1, 0, 0)));
    }

    @Test
    public void testRotate() {
        V3D v3ctor1 = new V3D(1, 0, 0);
        V3D v3ctor2 = v3ctor1.Rotate(0, Math.PI, 0);
        assertTrue(v3ctor2.IsSame(new V3D(-1, 0, 0)));
    }

    @Test
    public void testFromPolarPolar() {
        V3D v3ctor1 = V3D.FromPolar(new Polar(1, 0, Math.PI/2));
        assertTrue(v3ctor1.IsSame(new V3D(1, 0, 0)));
    }

    @Test
    public void testFromPolarDouble() {
        V3D v3ctor1 = V3D.FromPolar(1, 0, Math.PI/2);
        assertTrue(v3ctor1.IsSame(new V3D(1, 0, 0)));
    }

}
