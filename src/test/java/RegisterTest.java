import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import site.nomoreparties.stellarburgers.LoginPage;
import site.nomoreparties.stellarburgers.HomePage;
import site.nomoreparties.stellarburgers.RegisterPage;

public class RegisterTest extends DataTests {


    @Test
    @DisplayName("Успешная регистрация пользователя")
    public void goRegisterPage() {
        HomePage homePage = new HomePage(driver);
        homePage.clickableButtonSignInToAccount();
        homePage.clickButtonSignInToAccount();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.visibilityTextLogin();
        loginPage.clickButtonRegister();
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.visibilityTextRegistration();
        registerPage.inputFieldName(name);
        registerPage.inputFieldEmail(email);
        registerPage.inputFieldPassword(password);
        registerPage.clickButtonRegister();
        Assert.assertTrue(loginPage.visibilityTextLogin());
    }

    @Test
    @DisplayName("При регистрации пользователя c Некорректным паролем")
    public void goRegisterPageInvalidPassword() {
        HomePage homePage = new HomePage(driver);
        homePage.clickableButtonSignInToAccount();
        homePage.clickButtonSignInToAccount();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.visibilityTextLogin();
        loginPage.clickButtonRegister();
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.visibilityTextRegistration();
        registerPage.inputFieldName(name);
        registerPage.inputFieldEmail(email);
        registerPage.inputFieldPassword(invalidPassword);
        registerPage.clickButtonRegister();
        Assert.assertTrue(registerPage.visibilityTextInvalidPassword());
    }
}
