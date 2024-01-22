import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class PolarTest {
    double eps = 0.001;
    @Test
    public void testConstruction(){
        Polar point = new Polar(1, 0, Math.PI/2);
        assertEquals(point._r, 1);
        assertTrue(Math.abs(point._theta - Math.PI/2) < eps);
        assertEquals(point._phi, 0);

    }
    @Test
    public void testVector(){
        Polar point = new Polar(1, 0, Math.PI/2);
        assertTrue(point.Vector().IsSame(new V3D(1, 0, 0)));

    }
}
