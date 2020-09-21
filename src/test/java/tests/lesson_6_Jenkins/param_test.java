package tests.lesson_6_Jenkins;

import org.junit.jupiter.api.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class param_test {

    @Test
    @Tag("param")
    void paramTest()  {
        String b = System.getProperty("bb"); // take from terminal gradle params_test -Dbb=salad

        assertThat("salad", equalTo(b));
    }
}
