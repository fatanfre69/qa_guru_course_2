package tests.lesson_6_Jenkins;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class param_test {

    @Test
    @Tag("param")
    void paramTest()  {
        String a = "tomato";
        String b = "cucumber";
        String c = System.getProperty("cc"); // take from terminal gradle params_test -Dcc=salad

        assertEquals(a + b, c);

        System.out.println("c = " + c);
        assertEquals("salad", c, "c = " + c);
    }
}
