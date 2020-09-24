package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.remote.*;
import com.codeborne.selenide.WebDriverProvider;

import java.net.*;

import static org.openqa.selenium.remote.BrowserType.CHROME;

public class CustomWebDriver implements WebDriverProvider {
    @Override
    public WebDriver createDriver(DesiredCapabilities capabilities) {
        capabilities.setBrowserName(CHROME);
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        capabilities.setCapability("videoFrameRate", 24);

        capabilities.setCapability(ChromeOptions.CAPABILITY, getChromeOptions());
        WebDriverManager.chromedriver().setup();

        if(System.getProperty("remote_driver_url") != null) {
            return new RemoteWebDriver(getRemoteWebdriverUrl(), capabilities);
        } else {
            return new ChromeDriver(capabilities);
        }
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--lang=ru");

        return chromeOptions;
    }

    private URL getRemoteWebdriverUrl() {
        try {
            return new URL(System.getProperty("remote_driver_url"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
