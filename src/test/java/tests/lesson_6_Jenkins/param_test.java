package tests.lesson_6_Jenkins;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class param_test {

    @Test
    @Tag("param")
    void paramTest()  {
        int a = 2;
        String bb = System.getProperty("bb");
        int b = Integer.parseInt(bb);  // take from terminal< gradle simple tests -Dbb=3

        assertEquals(a * b, 6);
    }
}
