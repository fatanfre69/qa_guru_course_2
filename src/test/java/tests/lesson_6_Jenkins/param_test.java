package tests.lesson_6_Jenkins;

import org.junit.jupiter.api.*;
import org.junit.platform.commons.logging.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("param")
public class param_test {
    static Logger logger = LoggerFactory.getLogger(param_test.class);

    @Test
    void paramsTest() {
        String c = System.getProperty("cc", "salad"); // take from terminal gradle params_test -Dcc=salad

//        logger.info("b = " + c);
        System.out.println("a = " + c);
        assertEquals("salad", c, "c = " + c);
    }


    @Test
    @Disabled ("вопрос с синтаксисиом или ... ?")
    void paramTest()  {
        String a = "tomato";
        String b = "cucumber";
        String c = System.getProperty("сс"); // take from terminal gradle params_test -Dcc=tomatocucumber
        assertEquals(a + b, c);

//        System.out.println("c = " + c);
//        assertEquals("tomatoucumber", c, "c = " + c);
    }
}

