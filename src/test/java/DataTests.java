import data.browser.WebDriverBrowser;
import data.user.UserApiClient;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import static data.browser.WebDriverBrowser.BASE_URL;

public class DataTests {

    public String name = "Диплом";
    public String email = "diplom_qa_java_21@yandex.ru";
    public String password = "123456";
    public String invalidPassword = "123";


    public WebDriver driver;
    public UserApiClient userApiClient = new UserApiClient();

    @Before
    public void setUp() {
        driver = WebDriverBrowser.browserDriverSetUp();
        driver.get(BASE_URL);
    }

    @After
    public void teardown() {
        driver.quit();
        userApiClient.deleteUser(email, password);
    }
}
