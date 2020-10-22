package tests.lesson_14_selenide;

import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.*;

public class examples {

//    @Test
//    void examples1() {
//        int number=1;
//    Assumptions.assumeTrue(true,numbe=1);
//            Assumptions.assumeFalse(false,1);
//    }


    @Test
    void examples2() {
        actions().moveToElement($("")).moveByOffset(10,10).
                clickAndHold().moveByOffset(200,-50).release().perform();
//        DragAndDrop некий

//        new Book().publishing().author().build();

        Assumptions.assumeTrue(true,"");
//        как работает?
    }

}
