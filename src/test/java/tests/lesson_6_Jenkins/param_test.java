package tests.lesson_6_Jenkins;

import org.junit.jupiter.api.*;
import org.junit.platform.commons.logging.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class param_test {
    static Logger logger = LoggerFactory.getLogger(param_test.class);

    @Test
    @Tag("param")
    void paramsTest() {
        String c = System.getProperty("cc", "salad"); // take from terminal gradle params_test -Dcc=salad

//        logger.info("b = " + c);
        System.out.println("a = " + c);
        assertEquals("salad", c, "a = " + c);
    }


    @Test
    @Disabled ("вопрос с синтаксисиом или ... ?")
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

