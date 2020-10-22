package tests.lesson_17_api_postman;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class apiAutoTests {
    @BeforeAll
    static void beforeEach() { RestAssured.baseURI = "http://demowebshop.tricentis.com";}


    @Test
    void addToCartTest() {
        String data = "product_attribute_72_5_18=53&product_attribute_72_6_19=54&product_attribute_72_3_20=57&addtocart_72.EnteredQuantity=1";

        given()
                .cookie("Nop.customer=cf758996-fa4b-4308-807e-5b909b86587e; ARRAffinity=27a67e33786f8ab23a30ad511ae8eba575b52d88316f57912aa47193a6f9d384; __utmc=78382081; __utmz=78382081.1603355531.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); NopCommerce.RecentlyViewedProducts=RecentlyViewedProductIds=14; __utma=78382081.1616179319.1603355531.1603355531.1603358522.2; __utmt=1; __atuvc=4%7C43; __atuvs=5f914f3a87e295e6001; __utmb=78382081.7.10.1603358522")
                .contentType(ContentType.URLENC)
                .body(data)
                .when()
                .post("/addproducttocart/catalog/14/1/1")
                .then()
                .statusCode(200)
                .body("success", is(true));
    }


    @Test
    void deleteFromCart() {
        String data = "removefromcart: 1513932\n" +
                "itemquantity1513932: 1\n" +
                "updatecart: Update shopping cart\n" +
                "discountcouponcode: \n" +
                "giftcardcouponcode: \n" +
                "CountryId: 0\n" +
                "StateProvinceId: 0\n";

        given()
                .cookie("Nop.customer=cf758996-fa4b-4308-807e-5b909b86587e; ARRAffinity=27a67e33786f8ab23a30ad511ae8eba575b52d88316f57912aa47193a6f9d384; __utmc=78382081; __utmz=78382081.1603355531.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); NopCommerce.RecentlyViewedProducts=RecentlyViewedProductIds=14; __utma=78382081.1616179319.1603355531.1603355531.1603358522.2; __atuvc=4%7C43; __atuvs=5f914f3a87e295e6001; __utmt=1; __utmb=78382081.17.10.1603358522")
                .contentType(ContentType.URLENC)
                .body(data)
                .when()
                .post("/cart")
                .then()
                .statusCode(200)
                .body("success", is(true));
    }
}

