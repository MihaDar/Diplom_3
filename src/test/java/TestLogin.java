import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.LoginPage;
import site.nomoreparties.stellarburgers.HomePage;
import site.nomoreparties.stellarburgers.PasswordRecoveryPage;
import site.nomoreparties.stellarburgers.RegisterPage;

public class TestLogin extends DataTests {


    @Before
    public void CreateUser(){
        userApiClient.createUser(email, password, name);
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной странице.")
    public void buttonSignInToAccountHomePage() {
        HomePage homePage = new HomePage(driver);
        homePage.clickableButtonSignInToAccount();
        homePage.clickButtonSignInToAccount();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.visibilityTextLogin();
        loginPage.inputFieldEmail(email);
        loginPage.inputFieldPassword(password);
        loginPage.clickButtonSignIn();
        Assert.assertTrue(homePage.visibilityTextAssembleBurger());
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет» на главной странице.")
    public void buttonPersonalAccountHomePage() {
        HomePage homePage = new HomePage(driver);
        homePage.clickableButtonPersonalAccount();
        homePage.clickButtonPersonalAccount();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.visibilityTextLogin();
        loginPage.inputFieldEmail(email);
        loginPage.inputFieldPassword(password);
        loginPage.clickButtonSignIn();
        Assert.assertTrue(homePage.visibilityTextAssembleBurger());
    }

    @Test
    @DisplayName("Вход через кнопку «Войти» в форме регистрации.")
    public void buttonLoginRegisterPage() {
        HomePage homePage = new HomePage(driver);
        homePage.clickableButtonPersonalAccount();
        homePage.clickButtonPersonalAccount();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.visibilityTextLogin();
        loginPage.clickButtonRegister();
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.visibilityTextRegistration();
        registerPage.clickButtonSignIn();
        loginPage.inputFieldEmail(email);
        loginPage.inputFieldPassword(password);
        loginPage.clickButtonSignIn();
        Assert.assertTrue(homePage.visibilityTextAssembleBurger());
    }

    @Test
    @DisplayName("Вход через кнопку «Войти» в форме восстановления пароля.")
    public void buttonLoginPasswordRecoveryPage() {
        HomePage homePage = new HomePage(driver);
        homePage.clickableButtonPersonalAccount();
        homePage.clickButtonPersonalAccount();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.visibilityTextLogin();
        loginPage.clickButtonRecoverPassword();
        PasswordRecoveryPage passwordRecoveryPage = new PasswordRecoveryPage(driver);
        passwordRecoveryPage.visibilityTextLogin();
        passwordRecoveryPage.clickButtonSignin();
        loginPage.inputFieldEmail(email);
        loginPage.inputFieldPassword(password);
        loginPage.clickButtonSignIn();
        Assert.assertTrue(homePage.visibilityTextAssembleBurger());
    }
}
