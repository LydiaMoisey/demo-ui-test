package by.itacademy.moiseenkolydia.web;

public class OnlinerPage {
    public static final String URL = "https://www.onliner.by/";
    public static final String COPYRIGHT = "//div[@class='footer-style__copy']";
    public static final String BTN_ENTER = "//div[@class='auth-bar__item auth-bar__item--text']";
    public static final String INPUT_LOGIN = "//input[@placeholder='Ник или e-mail']";
    public static final String INPUT_PASS = "//input[@type='password']";
    public static final String LOGIN_ERROR = "//*[@id='auth-container']/div/div[2]/div/form/div[1]/div/div[2]/div/div";
    public static final String PASSWORD_ERROR = "//*[@id='auth-container']/div/div[2]/div/form/div[2]/div/div";
    public static final String CREDS_ERROR = "//div[contains (@class,'auth-form__description_error')]";
    public static final String BTN_SUBMIT = "//div[@id='auth-container']//button[@type='submit']";
    public static final String FORM_TITLE = "//div[contains(@class, 'auth-form__title')]";
    public static final String PROFILE = "//a[@class='b-top-profile__preview js-toggle-bar']";
    public static final String OPEN_PROFILE = "//*[@id='userbar']/div/div[1]/div/div[1]/div[1]/div[1]/div/a";
    public static final String PERSONAL_TAB = "//a[@href='/personal']";
    public static final String EMAIL = "//*[@id='container']/div/div/div/div/div/div/div/div[2]/div[2]/div/div/div/div/div/div[3]/div/div[1]/div/div/div[2]/div/span";
}