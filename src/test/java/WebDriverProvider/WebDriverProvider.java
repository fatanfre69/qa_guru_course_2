package WebDriverProvider;

//public class WebDriverProvider implements Supplier<WebDriver> {
//
//    @Override
//    public WebDriver get() {
//        final String browserName = System.getProperty("browser.name");
//        if ("chrome".equals(browserName)) {
//            WebDriverManager.chromedriver().setup();
//            return new ChromeDriver();
//        }
//        if ("firefox".equals(browserName)) {
//            WebDriverManager.firefoxdriver().setup();
//            return new FirefoxDriver();
//        }
//        throw new RuntimeException("Unknown browser name: " + browserName);
//    }
//}
