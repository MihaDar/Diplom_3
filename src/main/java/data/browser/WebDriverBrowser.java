package data.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBrowser {

    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site";

    //private final static Browser CURRENT_BROWSER = Browser.CHROME_BROWZER;
    private final static Browser CURRENT_BROWSER = Browser.YANDEX_BROWZER;

    public static WebDriver browserDriverSetUp() {
        WebDriver driver = null;
        switch (CURRENT_BROWSER) {
            case YANDEX_BROWZER:
                System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
                driver = new ChromeDriver();
                break;
            case CHROME_BROWZER:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
        }
        return driver;
    }
}
