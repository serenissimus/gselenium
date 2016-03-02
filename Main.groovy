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

// http://chromedriver.storage.googleapis.com/index.html?path=2.21/
// TODO: add multiplatform support
System.setProperty("webdriver.chrome.driver", "drivers/linux32/chromedriver")

/* ------------------------------------------------------------------------------ */

/*
 groovydoc \
    -d docs \
    -public \
    -classpath ${HOME}/.sdkman/candidates/groovy/current/lib \
    -windowtitle "Groovy Selenium Wrapper" \
    -header "Groovy Selenium Wrapper" \
    -footer "" \
    -doctitle "" \
    *.groovy *.java
*/


// TODO: test for sending keys into web elements
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


// TODO: check for set all data
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

    Date(java.util.Date date) {
        setDate(date)
    }

    java.util.Date getDate() {
        return _date;
    }

    private void setDate(java.util.Date date) {
        _date = date
    }
}


// TODO: see sun.misc.unsafe usage for less noisy constructor
// TODO: of original Cookie class

// TODO: check for set all data

// TODO: check what happens with Date - value of year field is very small

// TODO: getExpiry - check for null
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
     * Вернуть домен
     * @return Домен
     */
    public String getDomain() {
        if (null == getCookie()) {
            return null
        }
        return getCookie().getDomain()
    }

    /**
     * Установить домен
     * @param domain Домен
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
     * Вернуть путь
     * @return Путь
     */
    public String getPath() {
        if (null == getCookie()) {
            return null
        }
        return getCookie().getPath()
    }

    /**
     * Установить путь
     * @param path Путь
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
     * Вернуть имя
     * @return Имя
     */
    public String getName() {
        if (null == getCookie()) {
            return null
        }
        return getCookie().getName()
    }

    /**
     * Установить имя
     * @param name Имя
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
     * Вернуть значение
     * @return Значение
     */
    public String getValue() {
        if (null == getCookie()) {
            return null
        }
        return getCookie().getValue()
    }

    /**
     * Установить значение
     * @param value Значение
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
     * Вернуть дату "протухания"
     * @return Дата "протухания" {@link Date}
     */
    public Date getExpiry() {
        if (null == getCookie()) {
            return null
        }
        if (null == getCookie().getExpiry()) {
            return null
        }
        return new Date(getCookie().getExpiry())
    }

    /**
     * Установить дату "протухания"
     * @param expiry Дата "протухания" {@link Date}
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

    Cookie(org.openqa.selenium.Cookie cookie) {
        setCookie(cookie)
    }

    org.openqa.selenium.Cookie getCookie() {
        return _cookie
    }

    private void setCookie(org.openqa.selenium.Cookie cookie) {
        _cookie = cookie
    }
}


/**
 * Класс веб-элемент
 */
class WebElement
{
    /**
     * Вернуть координату X вернего левого угла элемента
     * @return Координата X
     */
    public int getX() {
        return getWebElement().getLocation().getX()
    }

    /**
     * Вернуть координату Y вернего левого угла элемента
     * @return Координата Y
     */
    public int getY() {
        return getWebElement().getLocation().getY()
    }

    /**
     * Вернуть ширину элемента
     * @return Ширина
     */
    public int getWidth() {
        return getWebElement().getSize().getWidth()
    }

    /**
     * Вернуть высоту элемента
     * @return Высота
     */
    public int getHeight() {
        return getWebElement().getSize().getHeight()
    }

    // TODO: подумать над тем как бы получше именовать
    // TODO: подумать над правильным JavaDoc
    /**
     * Элемент отображается на странице?
     * @return Отображается?
     */
    public boolean isDisplayed() {
        return getWebElement().isDisplayed()
    }

    // TODO: подумать над тем как бы получше именовать
    // TODO: подумать над правильным JavaDoc
    /**
     * Элемент включён?
     * @return Включён?
     */
    public boolean isEnabled() {
        return getWebElement().isEnabled()
    }

    // TODO: подумать над тем как бы получше именовать
    // TODO: подумать над правильным JavaDoc
    /**
     * Элемент выбран?
     * @return Выбран?
     */
    public boolean isSelected() {
        return getWebElement().isSelected()
    }


    private org.openqa.selenium.WebElement _webElement;

    WebElement(org.openqa.selenium.WebElement webElement) {
        setWebElement(webElement)
    }

    org.openqa.selenium.WebElement getWebElement() {
        return _webElement
    }

    private void setWebElement(org.openqa.selenium.WebElement webElement) {
        _webElement = webElement
    }
}


/**
 * Класс-драйвер для взаимодействия с браузером
 */
class WebDriver {

    // TODO: add support for Ie, Opera(maybe...), Android(maybe...), Safari
    /**
     * Конструктор
     * @param type Тип браузера("Chrome","Firefox","Htmlunit","Ie")
     */
    public WebDriver(String type) {
        if (null != type) {
            type = type.toLowerCase()
        }
        if ("chrome".equals(type)) {
            setWebDriver(new org.openqa.selenium.chrome.ChromeDriver())
        } else if ("firefox".equals(type)) {
            setWebDriver(new org.openqa.selenium.firefox.FirefoxDriver())
        } else if ("htmlunit".equals(type)) {
            setWebDriver(new org.openqa.selenium.htmlunit.HtmlUnitDriver())
        } else if ("ie".equals(type)) {
            setWebDriver(new org.openqa.selenium.ie.InternetExplorerDriver())
        }
        assert (null != getWebDriver())
    }

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
    public void getScreenshot(String screenshotSavePath) {
        File scrFile =
                ((org.openqa.selenium.TakesScreenshot) getWebDriver())
                        .getScreenshotAs(OutputType.FILE)
        FileUtils.copyFile(scrFile, new File(screenshotSavePath))
    }

    /**
     * Вернуть положение окна браузера по X относительно верхнего левого угла
     * @return Координата X окна браузера
     */
    public int getX() {
        return getWebDriver()
                    .manage()
                    .window()
                    .getPosition()
                    .getX()
    }

    /**
     * Установить положение окна браузера по X относительно верхнего левого угла
     * @param x Координата X окна браузера
     */
    public void setX(int x) {
        getWebDriver()
                .manage()
                .window()
                .setPosition(new org.openqa.selenium.Point(x, getY()))
    }

    /**
     * Вернуть положение окна браузера по Y относительно верхнего левого угла
     * @return Координата Y окна браузера
     */
    public int getY() {
        return getWebDriver()
                    .manage()
                    .window()
                    .getPosition()
                    .getY()
    }

    /**
     * Установить положение окна браузера по Y относительно верхнего левого угла
     * @param y Координата Y окна браузера
     */
    public void setY(int y) {
        getWebDriver()
                .manage()
                .window()
                .setPosition(new org.openqa.selenium.Point(getX(), y))
    }

    /**
     * Вернуть ширину окна браузера
     * @return Ширина окна браузера
     */
    public int getWidth() {
        return getWebDriver()
                    .manage()
                    .window()
                    .getSize()
                    .getWidth()
    }

    /**
     * Установить ширину окна браузера
     * @param width Ширина окна браузера
     */
    public void setWidth(int width) {
        getWebDriver()
                .manage()
                .window()
                .setSize(new org.openqa.selenium.Dimension(width, getHeight()))
    }

    /**
     * Вернуть высоту окна браузера
     * @return Высота окна браузера
     */
    public int getHeight() {
        return getWebDriver()
                    .manage()
                    .window()
                    .getSize()
                    .getHeight()
    }

    /**
     * Установить высоту окна браузера
     * @param height Высота окна браузера
     */
    public void setHeight(int height) {
        getWebDriver()
                .manage()
                .window()
                .setSize(new org.openqa.selenium.Dimension(getWidth(), height))
    }

    /**
     * Максимализировать("распахнуть") окно браузера во весь экран
     */
    public void maximize() {
        getWebDriver().manage().window().maximize()
    }

    /**
     * Найти элемент по CSS пути
     * @param cssPath CSS путь(селектор) элемента
     * @return Веб элемент или null если не найден {@link WebElement}
     */
    public WebElement findElement(String cssPath) {
        try {
            return new WebElement(
                    getWebDriver()
                            .findElement(
                                org.openqa.selenium.By.cssSelector(cssPath)))
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return null
        }
    }

    /**
     * Найти элементы по CSS пути
     * @param cssPath CSS путь(селектор) элементов
     * @return Список веб элементов {@link WebElement}
     */
    public List<WebElement> findElements(String cssPath) {
        return getWebDriver()
                    .findElements(org.openqa.selenium.By.cssSelector(cssPath))
                .collect({ new WebElement(it) })
    }

    /**
     * Вернуть список Cookie файлов
     * @return Сисок Cookie файлов  {@link Cookie}
     */
    public List<Cookie> getCookies() {
        return getWebDriver().manage().getCookies().collect({ new Cookie(it) })
    }

    /**
     * Добавить Cookie файл
     * @param cookie Cookie файл для добавления {@link Cookie}
     */
    public void addCoockie(Cookie cookie) {
        getWebDriver().manage().addCookie(cookie.getCookie())
    }

    /**
     * Удалить Cookie файл
     * @param cookie Cookie файл для удаления  {@link Cookie}
     */
    public void deleteCookie(Cookie cookie) {
        getWebDriver().manage().deleteCookie(cookie.getCookie())
    }

    /**
     * Удалить все Cookie файлы
     */
    public void deleteAllCookies() {
        getWebDriver().manage().deleteAllCookies()
    }

    // TODO: Maybe can override ellipsis by list(see toArray method)
    /**
     * Выполнить JavaScript строку
     * @param script Строка JavaScript
     * @param args Необязательные аргументы в JavaScript(могут быть получены в
     *              JavaScript через arguments[<номер аргумента>]
     */
    public void executeJavaScript(String script, Object ...args) {
        ((org.openqa.selenium.JavascriptExecutor) getWebDriver())
                .executeScript(script, args)
    }


    private org.openqa.selenium.WebDriver _webDriver

    WebDriver(org.openqa.selenium.WebDriver webDriver) {
        setWebDriver(webDriver)
    }

    org.openqa.selenium.WebDriver getWebDriver() {
        return _webDriver
    }

    private void setWebDriver(org.openqa.selenium.WebDriver webDriver) {
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
    public Actions(WebDriver webDriver) {
        setActions(
                new org.openqa.selenium.interactions.Actions(
                        webDriver.getWebDriver()))
    }

    /**
     *
     * @return
     */
    public Actions click() {
        getActions().click()
        return this
    }

    /**
     *
     * @param webElement
     * @return
     */
    public Actions click(WebElement webElement) {
        getActions().click(webElement.getWebElement())
        return this
    }

    /**
     *
     * @return
     */
    public Actions clickContext() {
        getActions().contextClick()
        return this
    }

    /**
     *
     * @param webElement
     * @return
     */
    public Actions clickContext(WebElement webElement) {
        getActions().contextClick(webElement.getWebElement())
        return this
    }

    /**
     *
     * @return
     */
    public Actions clickAndHold() {
        getActions().clickAndHold()
        return this
    }

    /**
     *
     * @param webElement
     * @return
     */
    public Actions clickAndHold(WebElement webElement) {
        getActions().clickAndHold(webElement.getWebElement())
        return this
    }

    /**
     *
     * @return
     */
    public Actions releaseHold() {
        getActions().release()
        return this
    }

    /**
     *
     * @param webElement
     * @return
     */
    public Actions releaseHold(WebElement webElement) {
        getActions().release(webElement.getWebElement())
        return this
    }

    /**
     *
     * @return
     */
    public Actions doubleClick() {
        getActions().doubleClick()
        return this
    }

    /**
     *
     * @param webElement
     * @return
     */
    public Actions doubleClick(WebElement webElement) {
        getActions().doubleClick(webElement.getWebElement())
        return this
    }

    /**
     *
     * @param key
     * @return
     */
    public Actions keyDown(CharSequence key) {
        getActions().keyDown((org.openqa.selenium.Keys) key)
        return this
    }

    /**
     *
     * @param webElement
     * @param key
     * @return
     */
    public Actions keyDown(WebElement webElement, CharSequence key) {
        getActions()
                .keyDown(webElement.getWebElement(), (org.openqa.selenium.Keys) key)
        return this
    }

    /**
     *
     * @param key
     * @return
     */
    public Actions keyUp(CharSequence key) {
        getActions().keyUp((org.openqa.selenium.Keys) key)
        return this
    }

    /**
     *
     * @param webElement
     * @param key
     * @return
     */
    public Actions keyUp(WebElement webElement, CharSequence key) {
        getActions()
                .keyUp(webElement.getWebElement(), (org.openqa.selenium.Keys) key)
        return this
    }

    /**
     *
     * @param keys
     * @return
     */
    public Actions sendKeys(CharSequence ...keys) {
        getActions().sendKeys(keys)
        return this
    }

    /**
     *
     * @param keys
     * @return
     */
    public Actions sendKeys(WebElement webElement, CharSequence ...keys) {
        getActions().sendKeys(webElement.getWebElement(), keys)
        return this
    }

    /**
     *
     * @param xOffset
     * @param yOffset
     * @return
     */
    public Actions mouseMove(int xOffset, int yOffset) {
        getActions().moveByOffset(xOffset, yOffset)
        return this
    }

    /**
     *
     * @param element
     * @return
     */
    public Actions mouseMove(WebElement element) {
        getActions().moveToElement(element.getWebElement())
        return this
    }

    /**
     *
     * @param element
     * @param xOffset
     * @param yOffset
     * @return
     */
    public Actions mouseMove(WebElement element, int xOffset, int yOffset) {
        getActions().moveToElement(element.getWebElement(), xOffset, yOffset)
        return this
    }

    /**
     *
     * @param source
     * @param target
     * @return
     */
    public Actions dragAndDrop(WebElement source, WebElement target) {
        getActions().dragAndDrop(
                source.getWebElement(),
                target.getWebElement())
        return this
    }

    /**
     *
     * @param webElement
     * @param xOffset
     * @param yOffset
     * @return
     */
    public Actions dragAndDrop(WebElement webElement, int xOffset, int yOffset) {
        getActions().dragAndDropBy(
                source.getWebElement(),
                xOffset,
                yOffset
        )
        return this
    }

    /**
     *
     * @param driver
     */
    public void perform() {
        getActions().perform()
    }


    private org.openqa.selenium.interactions.Actions _actions;

    Actions(org.openqa.selenium.interactions.Actions actions) {
        setActions(actions)
    }

    public org.openqa.selenium.interactions.Actions getActions() {
        return _actions
    }

    private setActions(org.openqa.selenium.interactions.Actions actions) {
        _actions = actions
    }
}

/* ------------------------------------------------------------------------------ */

def driver = new WebDriver("Chrome")
driver.setX(0)
driver.setY(0)
driver.setWidth(1024)
driver.setHeight(768)

driver.open("http://madagascartc.ru")
def element = driver.findElement("#section-first")
def elements = driver.findElements("p")

println element
println elements

println "-------------------------"
println element.getX()
println element.getY()
println element.getWidth()
println element.getHeight()
println element.isDisplayed()
println element.isEnabled()
println element.isSelected()

for (def e in elements) {
    println "-------------------------"
    println e.getX()
    println e.getY()
    println e.getWidth()
    println e.getHeight()
    println e.isDisplayed()
    println e.isEnabled()
    println e.isSelected()
}

def cookies = driver.getCookies()
for (def c in cookies) {
    println "-------------------------"
    println c.getDomain()
    println c.getPath()
    println c.getName()
    println c.getValue()
    if (null != c.getExpiry()) {
        print "  "
        println c.getExpiry().getYear()
        print "  "
        println c.getExpiry().getMonth()
        print "  "
        println c.getExpiry().getDay()
        print "  "
        println c.getExpiry().getHours()
        print "  "
        println c.getExpiry().getMinutes()
        print "  "
        println c.getExpiry().getSeconds()
    }
}

def elementShops = driver.findElement("body > div.header > div.menu > div.container > div > div:nth-child(1) > div > ul > li:nth-child(1) > a")
def actions = new Actions(driver)
actions
        .mouseMove(elementShops)
        .click()
        .perform()

sleep(5000)

driver.quit()

/* ------------------------------------------------------------------------------ */
