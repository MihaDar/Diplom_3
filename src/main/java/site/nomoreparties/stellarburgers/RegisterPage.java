package site.nomoreparties.stellarburgers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {

    private WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    //Текст "Регистрация"
    private final By textRegistration = By.xpath(".//h2[text()='Регистрация']");

    //Поле "Имя"
    private final By fieldName = By.xpath(".//label[text() = 'Имя']/parent::*/input");

    //Поле Email
    private final By fieldEmail = By.xpath(".//label[text() = 'Email']/parent::*/input");

    //Поле "Пароль"
    private final By fieldPassword = By.xpath(".//label[text() = 'Пароль']/parent::*/input");

    //Кнопка "Зарегистрироваться"
    private final By buttonRegister = By.xpath(".//button[text()='Зарегистрироваться']");

    //Кнопка "Войти" под формой регистрации
    private final By buttonSignIn = By.xpath(".//a[text()='Войти']");

    //Некорректный пароль
    private final By textInvalidPassword = By.xpath(".//p[text()='Некорректный пароль']");


    //"Видимость текста Регистрация")
    public void visibilityTextRegistration(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(textRegistration));
    }

    //"Ввод в поле Имя"
    public void inputFieldName (String name){
        driver.findElement(fieldName).sendKeys(name);
    }

    //"Ввод в поле Email"
    public void inputFieldEmail (String email){
        driver.findElement(fieldEmail).sendKeys(email);
    }

    //"Ввод в поле пароль
    public void inputFieldPassword (String password){
        driver.findElement(fieldPassword).sendKeys(password);
    }

    //"Клик по кнопке Зарегистрироваться"
    public void clickButtonRegister() {
        driver.findElement(buttonRegister).click();
    }

    //"Клик по кнопке Войти"
    public void clickButtonSignIn() {
        driver.findElement(buttonSignIn).click();
    }

    //"Видимость текстаНекорректный пароль"
    public boolean visibilityTextInvalidPassword() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(textInvalidPassword));
        return true;
    }
}
