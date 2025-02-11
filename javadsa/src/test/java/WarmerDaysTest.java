import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import com.digiteched.javadsa.applications.WarmerDays;

public class WarmerDaysTest {
    @Test
    public void SolutionATest() {
        int[] temps = { 73, 74, 75, 71, 69, 72, 76, 73 };
        int[] expected = { 1, 1, 4, 2, 1, 1, 0, 0 };

        int[] result = WarmerDays.solutionA(temps);
        assertArrayEquals(expected, result);
    }

    @Test
    public void SolutionBTest() {
        int[] temps = { 73, 74, 75, 71, 69, 72, 76, 73 };
        int[] expected = { 1, 1, 4, 2, 1, 1, 0, 0 };

        int[] result = WarmerDays.solutionB(temps);
        assertArrayEquals(expected, result);
    }
}
