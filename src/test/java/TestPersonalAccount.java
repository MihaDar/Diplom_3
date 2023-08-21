import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.HomePage;
import site.nomoreparties.stellarburgers.LoginPage;
import site.nomoreparties.stellarburgers.ProfilePage;

public class TestPersonalAccount extends DataTests {

    @Before
    public void CreateUser(){
        userApiClient.createUser(email, password, name);
    }

    @Test
    @DisplayName("Переход в личный кабинет по клику на «Личный кабинет»")
    public void transferInPersonalAccount() {
        HomePage homePage = new HomePage(driver);
        homePage.clickableButtonPersonalAccount();
        homePage.clickButtonPersonalAccount();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.visibilityTextLogin();
        loginPage.inputFieldEmail(email);
        loginPage.inputFieldPassword(password);
        loginPage.clickButtonSignIn();
        homePage.clickButtonPersonalAccount();
        ProfilePage profilePage = new ProfilePage(driver);
        Assert.assertTrue(profilePage.visibilityTextProfile());
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на «Конструктор»")
    public void transferOutPersonalAccountClickConstructor() {
        HomePage homePage = new HomePage(driver);
        homePage.clickableButtonPersonalAccount();
        homePage.clickButtonPersonalAccount();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.visibilityTextLogin();
        loginPage.inputFieldEmail(email);
        loginPage.inputFieldPassword(password);
        loginPage.clickButtonSignIn();
        homePage.clickButtonPersonalAccount();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickButtonConstructor();
        Assert.assertTrue(homePage.visibilityTextAssembleBurger());
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на «Stellar Burgers»")
    public void transferOutPersonalAccountClickStellarBurgers() {
        HomePage homePage = new HomePage(driver);
        homePage.clickableButtonPersonalAccount();
        homePage.clickButtonPersonalAccount();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.visibilityTextLogin();
        loginPage.inputFieldEmail(email);
        loginPage.inputFieldPassword(password);
        loginPage.clickButtonSignIn();
        homePage.clickButtonPersonalAccount();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickLogoStellarBurgers();
        Assert.assertTrue(homePage.visibilityTextAssembleBurger());
    }

    @Test
    @DisplayName("Выход из аккаунта по клику на кнопку «Выйти» в личном кабинете")
    public void logOutPersonalAccount() {
        HomePage homePage = new HomePage(driver);
        homePage.clickableButtonPersonalAccount();
        homePage.clickButtonPersonalAccount();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.visibilityTextLogin();
        loginPage.inputFieldEmail(email);
        loginPage.inputFieldPassword(password);
        loginPage.clickButtonSignIn();
        homePage.clickButtonPersonalAccount();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickableButtonSignOut();
        profilePage.clickButtonLogOut();
        Assert.assertTrue(loginPage.visibilityTextLogin());
    }
}
