#!/usr/bin/env groovy

/* ------------------------------------------------------------------------------ */

@Grab('commons-io:commons-io:2.4')
@Grab('commons-lang:commons-lang:2.6')
@Grab('org.seleniumhq.selenium:selenium-java:2.52.0')
@Grab('org.seleniumhq.selenium:selenium-chrome-driver:2.52.0')
@Grab('org.seleniumhq.selenium:selenium-firefox-driver:2.52.0')
@Grab('org.seleniumhq.selenium:selenium-htmlunit-driver:2.52.0')
@Grab('org.seleniumhq.selenium:selenium-ie-driver:2.52.0')

import org.apache.commons.io.FileUtils
import org.apache.commons.lang.SystemUtils
import org.openqa.selenium.WebDriver

import javax.imageio.ImageIO
import java.awt.Color
import java.awt.image.BufferedImage
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.Dimension
import org.openqa.selenium.Point
import static org.openqa.selenium.OutputType.FILE
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.htmlunit.HtmlUnitDriver
import org.openqa.selenium.ie.InternetExplorerDriver

/* ------------------------------------------------------------------------------ */

/*
 groovydoc -public -classpath ${HOME}/.sdkman/groovy/current/lib/ -d output -windowtitle "Groovy Selenium Wrapper" -header "Groovy Selenium Wrapper" -footer "" -doctitle ""  *.groovy *.java
*/

/**
 *
 */
class Keys
{
    /**
     * Клавиша Enter
     */
    public static CharSequence ENTER = org.openqa.selenium.Keys.ENTER

    /**
     * Клавиша Escape
     */
    public static CharSequence ESCAPE = org.openqa.selenium.Keys.ESCAPE

    /**
     * Клавиша Enter
     */
    public static CharSequence RETURN = org.openqa.selenium.Keys.RETURN

    /**
     * Клавиша Пробел
     */
    public static CharSequence SPACE = org.openqa.selenium.Keys.SPACE

    /**
     * Клавиша Tab
     */
    public static CharSequence TAB = org.openqa.selenium.Keys.TAB
}


/**
 * Класс для работы с Датой
 */
class Date
{
    /**
     * Конструктор
     */
    public Date() {
        setDate(new java.util.Date())
    }

    /**
     * Вернуть год
     * @return Год - целое число
     */
    public int getYear() {
        return  getDate().getYear()
    }

    /**
     * Установить год
     * @param year Год - целое число
     */
    public void setYear(int year) {
        getDate().setYear(year)
    }

    /**
     * Вернуть месяц
     * @return Месяц от 1 до 12
     */
    public int getMonth() {
        return getDate().getMonth()
    }

    /**
     * Установить месяц
     * @param month Месяц от 1 до 12
     */
    public void setMonth(int month) {
        _date.setMonth(month)
    }

    /**
     * Вернуть день
     * @return День от 1 до 28,29,30,31(в зависимости от месяца и года)
     */
    public int getDay() {
        return getDate().getDay()
    }

    /**
     * Установить день
     * @param day День от 1 до 28,29,30,31(в зависимости от месяца и года)
     */
    public void setDay(int day) {
        getDate().setDay(day)
    }

    /**
     * Вернуть часы
     * @return Часы от 0 до 23
     */
    public int getHours() {
        return getDate().getHours()
    }

    /**
     * Установить часы
     * @param hours Часы от 0 до 23
     */
    public void setHours(int hours) {
        getDate().setHours(hours)
    }

    /**
     * Вернуть минуты
     * @return Минуты от 0 до 59
     */
    public int getMinutes() {
        return getDate().getMinutes()
    }

    /**
     * Установить минуты
     * @param minutes Минуты от 0 до 59
     */
    public void setMinutes(int minutes) {
        getDate().setMinutes(minutes)
    }

    /**
     * Вернуть секунды
     * @return Секунды от 0 до 59
     */
    public int getSeconds() {
        return getDate().getSeconds()
    }

    /**
     * Установить секунды
     * @param seconds Секунды от 0 до 59
     */
    public void setSeconds(int seconds) {
        getDate().setSeconds(seconds)
    }


    private java.util.Date _date;

    /** @hide */
    public Date(java.util.Date date) {
        setDate(date)
    }

    /** @hide */
    public java.util.Date getDate() {
        return _date;
    }

    /** @hide */
    public setDate(java.util.Date date) {
        _date = date
    }
}


/**
 * Класс для работы с Cookie-файлами
 */
class Cookie
{
    /**
     * Конструктор
     */
    public Cookie() {
        setCookie(null)
    }

    /**
     *
     * @return
     */
    public String getDomain() {
        if (null == getCookie()) {
            return null
        }
        return getCookie().getDomain()
    }

    /**
     *
     * @param domain
     */
    public void setDomain(String domain) {
        setCookie(new org.openqa.selenium.Cookie(
                getName(),
                getValue(),
                domain,
                getPath(),
                getExpiry().getDate()))
    }

    /**
     *
     * @return
     */
    public String getPath() {
        if (null == getCookie()) {
            return null
        }
        return getCookie().getPath()
    }

    /**
     *
     * @param path
     */
    public void setPath(String path) {
        setCookie(new org.openqa.selenium.Cookie(
                getName(),
                getValue(),
                getDomain(),
                path,
                getExpiry().getDate()))
    }

    /**
     *
     * @return
     */
    public String getName() {
        if (null == getCookie()) {
            return null
        }
        return getCookie().getName()
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        setCookie(new org.openqa.selenium.Cookie(
                name,
                getValue(),
                getDomain(),
                getPath(),
                getExpiry().getDate()))
    }

    /**
     *
     * @return
     */
    public String getValue() {
        if (null == getCookie()) {
            return null
        }
        return getCookie().getValue()
    }

    /**
     *
     * @param value
     */
    public void setValue(String value) {
        setCookie(new org.openqa.selenium.Cookie(
                getName(),
                value,
                getDomain(),
                getPath(),
                getExpiry().getDate()))
    }

    /**
     *
     * @return
     */
    public Date getExpiry() {
        if (null == getCookie()) {
            return null
        }
        return new Date(getCookie().getExpiry())
    }

    /**
     *
     * @param expiry
     */
    public void setExpiry(Date expiry) {
        setCookie(new org.openqa.selenium.Cookie(
                getName(),
                getValue(),
                getDomain(),
                getPath(),
                expiry.getDate()))
    }


    private org.openqa.selenium.Cookie _cookie;

    /** @hide */
    public Cookie(org.openqa.selenium.Cookie cookie) {
        setCookie(cookie)
    }

    /** @hide */
    public org.openqa.selenium.Cookie getCookie() {
        return _cookie
    }

    /** @hide */
    public void setCookie(org.openqa.selenium.Cookie cookie) {
        _cookie = cookie
    }
}


/**
 * Класс веб-элемент
 */
class WebElement
{
    /**
     *
     * @return
     */
    public int getX() {
        return getWebElement().getLocation().getX()
    }

    /**
     *
     * @return
     */
    public int getY() {
        return getWebElement().getLocation().getY()
    }

    /**
     *
     * @return
     */
    public int getWidth() {
        return getWebElement().getSize().getWidth()
    }

    /**
     *
     * @return
     */
    public int getHeight() {
        return getWebElement().getSize().getHeight()
    }

    /**
     *
     * @return
     */
    public boolean isDisplayed() {
        return getWebElement().isDisplayed()
    }

    /**
     *
     * @return
     */
    public boolean isEnabled() {
        return getWebElement().isEnabled()
    }

    /**
     *
     * @return
     */
    public boolean isSelected() {
        return getWebElement().isSelected()
    }

    /**
     *
     * @param cssPath
     * @return
     */
    public WebElement findElement(String cssPath) {
        return new WebElement(getWebElement().findElement(org.openqa.selenium.By.cssSelector(cssPath)))
    }

    /**
     *
     * @param cssPath
     * @return
     */
    public List<WebElement> findElements(String cssPath) {
        return getWebElement().findElements(org.openqa.selenium.By.cssSelector(cssPath)).collect(new WebElement(it))
    }


    private org.openqa.selenium.WebElement _webElement;

    /** @hide */
    public WebElement(org.openqa.selenium.WebElement webElement) {
        setWebElement(webElement)
    }

    /** @hide */
    public org.openqa.selenium.WebElement getWebElement() {
        return _webElement
    }

    /** @hide */
    public void setWebElement(org.openqa.selenium.WebElement webElement) {
        _webElement = webElement
    }
}


/**
 * Класс-драйвер для взаимодействия с браузером
 */
class WebDriver {

    /**
     * Конструктор
     * @param type Тип браузера("Chrome","Firefox","Htmlunit","Ie")
     */
    public WebDriver(String type) {}

    /**
     * Открыть страницу сайта в браузере
     * @param url Адрес страницы сайта
     */
    public void open(String url) {
        getWebDriver().get(url)
    }

    /**
     * Закрыть браузер
     */
    public void quit() {
        getWebDriver().quit()
    }

    /**
     * Вернуть адрес страницы
     * @return Адрес страницы
     */
    public String getUrl() {
        return getWebDriver().getCurrentUrl()
    }

    /**
     * Вернуть заголовок страницы
     * @return Заголовок страницы
     */
    public String getTitle() {
        return getWebDriver().getTitle()
    }

    /**
     * Сделать и сохранить скриншот экрана
     * @param screenshotSavePath Путь куда сохранить скриншот
     */
    public void getScreenshot(String screenshotSavePath) {}

    /**
     * Вернуть положение окна браузера по X относительно верхнего левого угла
     * @return
     */
    public int getX() {
        return getWebDriver().manage().window().getPosition().getX()
    }

    /**
     *
     * @param x
     */
    public void setX(int x) {
        getWebDriver().manage().window().setPosition(new org.openqa.selenium.Point(x, getY()))
    }

    /**
     *
     * @return
     */
    public int getY() {
        return getWebDriver().manage().window().getPosition().getY()
    }

    /**
     *
     * @param y
     */
    public void setY(int y) {
        getWebDriver().manage().window().setPosition(new org.openqa.selenium.Point(getX(), y))
    }

    /**
     *
     * @return
     */
    public int getWidth() {
        return getWebDriver().manage().window().getSize().getWidth()
    }

    /**
     *
     * @param width
     */
    public void setWidth(int width) {
        getWebDriver().manage().window().setSize(new org.openqa.selenium.Dimension(width, getHeight()))
    }

    /**
     *
     * @return
     */
    public int getHeight() {
        return getWebDriver().manage().window().getSize().getHeight()
    }

    /**
     *
     * @param height
     */
    public void setHeight(int height) {
        getWebDriver().manage().window().setSize(new org.openqa.selenium.Dimension(getWidth(), height))
    }

    /**
     *
     */
    public void maximize() {
        getWebDriver().manage().window().maximize()
    }

    /**
     *
     * @param cssPath
     * @return
     */
    public WebElement findElement(String cssPath) {
        return new WebElement(getWebDriver().findElement(org.openqa.selenium.By.cssSelector(cssPath)))
    }

    /**
     *
     * @param cssPath
     * @return
     */
    public List<WebElement> findElements(String cssPath) {
        return getWebDriver().findElements(org.openqa.selenium.By.cssSelector(cssPath)).collect(new WebElement(it))
    }

    /**
     *
     * @return
     */
    public List<Cookie> getCookies() {
        return getWebDriver().manage().getCookies().collect(new Cookie(it))
    }

    /**
     *
     * @param cookie
     */
    public void addCoockie(Cookie cookie) {
        getWebDriver().manage().addCookie(cookie.getCookie())
    }

    /**
     *
     * @param cookie
     */
    public void deleteCookie(Cookie cookie) {
        getWebDriver().manage().deleteCookie(cookie.getCookie())
    }

    /**
     *
     */
    public void deleteAllCookies() {
        getWebDriver().manage().deleteAllCookies()
    }

    /**
     *
     * @param script
     */
    public void executeJavaScript(String script) {
        getWebDriver()
    }


    private org.openqa.selenium.WebDriver _webDriver;

    /** @hide */
    public WebDriver(org.openqa.selenium.WebDriver webDriver) {
        setWebDriver(webDriver)
    }

    /** @hide */
    public org.openqa.selenium.WebDriver getWebDriver() {
        return _webDriver
    }

    /** @hide */
    public void setWebDriver(org.openqa.selenium.WebDriver webDriver) {
        _webDriver = webDriver
    }
}


/**
 * Класс действия пользователя
 */
class Actions
{
    /**
     * Конструктор
     */
    public Actions() {}

    /**
     *
     * @return
     */
    public Actions click() {
        return this
    }

    /**
     *
     * @return
     */
    public Actions clickContext() {
        return this
    }

    /**
     *
     * @return
     */
    public Actions clickAndHold() {
        return this
    }

    /**
     *
     * @return
     */
    public Actions releaseHold() {
        return this
    }

    /**
     *
     * @return
     */
    public Actions doubleClick() {
        return this
    }

    /**
     *
     * @param key
     * @return
     */
    public Actions keyDown(def key) {
        return this
    }

    /**
     *
     * @param key
     * @return
     */
    public Actions keyUp(def key) {
        return this
    }

    /**
     *
     * @param keys
     * @return
     */
    public Actions sendKeys(def keys) {
        return this
    }

    /**
     *
     * @param x
     * @param y
     * @return
     */
    public Actions mouseMove(int x, int y) {
        return this
    }

    /**
     *
     * @param xOffset
     * @param yOffset
     * @return
     */
    public Actions mouseMoveByOffset(int xOffset, int yOffset) {
        return this
    }

    /**
     *
     * @param element
     * @return
     */
    public Actions mouseMoveToElement(WebElement element) {
        return this
    }

    /**
     *
     * @return
     */
    public Actions dragAndDrop() {
        return this
    }

    /**
     *
     * @param driver
     */
    public void perform(WebDriver driver) {}
}

/* ------------------------------------------------------------------------------ */

def driver = new WebDriver("Chrome")
driver.setWidth(1024)
driver.setHeight(768)

driver.open("http://madagascartc.ru")
def elem = driver.findElement("#elem")
assert(null != elem)
def actions = new Actions()
actions
        .mouseMoveToElement(elem)
        .click()
        .perform(driver)


driver.quit()

/* ------------------------------------------------------------------------------ */
