#!/usr/bin/env groovy

/* ------------------------------------------------------------------------------ */

@Grab('commons-io:commons-io:2.4')
@Grab('commons-lang:commons-lang:2.6')
@Grab('org.seleniumhq.selenium:selenium-java:2.+')
@Grab('org.seleniumhq.selenium:selenium-chrome-driver:2.+')
@Grab('org.seleniumhq.selenium:selenium-firefox-driver:2.+')
@Grab('org.seleniumhq.selenium:selenium-htmlunit-driver:2.+')
@Grab('org.seleniumhq.selenium:selenium-ie-driver:2.+')

import org.apache.commons.io.FileUtils
import org.apache.commons.lang.SystemUtils
import org.openqa.selenium.WebDriver
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


/**
 * Непечатные клавиши
 */
enum Keys implements CharSequence {

    /**
     * Клавиша Enter
     */
    ENTER  (org.openqa.selenium.Keys.ENTER),

    /**
     * Клавиша Escape
     */
    ESCAPE  (org.openqa.selenium.Keys.ESCAPE),

    /**
     * Клавиша Enter
     */
    RETURN  (org.openqa.selenium.Keys.RETURN),

    /**
     * Клавиша Пробел
     */
    SPACE  (org.openqa.selenium.Keys.SPACE),

    /**
     * Клавиша Tab
     */
    TAB  (org.openqa.selenium.Keys.TAB)
}


/**
 * Клавиши-модификаторы
 */
enum Modificators implements java.lang.CharSequence {
    /**
     * Клавиша левый Shift
     */
    LEFT_SHIFT  (org.openqa.selenium.Keys.LEFT_SHIFT)
}


// TODO: check for set all data
/**
 * Класс для работы с Датой
 */
class Date {

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

    public Date(java.util.Date date) {
        setDate(date)
    }

    public java.util.Date getDate() {
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
class Cookie {

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

    public Cookie(org.openqa.selenium.Cookie cookie) {
        setCookie(cookie)
    }

    public org.openqa.selenium.Cookie getCookie() {
        return _cookie
    }

    private void setCookie(org.openqa.selenium.Cookie cookie) {
        _cookie = cookie
    }
}


/**
 * Класс веб-элемент
 */
class WebElement {

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

    public WebElement(org.openqa.selenium.WebElement webElement) {
        setWebElement(webElement)
    }

    public org.openqa.selenium.WebElement getWebElement() {
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

    // TODO: add support for Ie, Android(maybe...), Safari
    /**
     * Конструктор
     * @param type Тип браузера("Chrome","Firefox","Htmlunit","Ie")
     */
    public WebDriver(String type) {
        if (null != type) {
            type = type.toLowerCase()
            setWebDriver(type)
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
        // TODO: Maybe need close srcFiles ?
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
     * @param arguments Список аргументов
     */
    public void executeJavaScript(String script, List<Object> arguments) {
        ((org.openqa.selenium.JavascriptExecutor) getWebDriver())
                .executeScript(script, arguments.toArray())
    }


    private org.openqa.selenium.WebDriver _webDriver

    private WebDriver(org.openqa.selenium.WebDriver webDriver) {
        setWebDriver(webDriver)
    }

    public org.openqa.selenium.WebDriver getWebDriver() {
        return _webDriver
    }

    private void setWebDriver(org.openqa.selenium.WebDriver webDriver) {
        _webDriver = webDriver
    }

    // TODO: rewrite this ugly code
    private void setWebDriver(String type) {
        prepareDriver(type)
    }

    private boolean prepareDriver(String type) {
        if ("chrome".equals(type)) {
            if (prepareChromeDriver()) {
                setWebDriver(new org.openqa.selenium.chrome.ChromeDriver())
            }
        } else if ("firefox".equals(type)) {
            if (prepareFirefoxDriver()) {
                setWebDriver(new org.openqa.selenium.firefox.FirefoxDriver())
            }
        } else if ("htmlunit".equals(type)) {
            if (prepareHtmlUnitDriver()) {
                setWebDriver(new org.openqa.selenium.htmlunit.HtmlUnitDriver())
            }
        } else if ("ie".equals(type)) {
            if (prepareIeDriver()) {
                setWebDriver(new org.openqa.selenium.ie.InternetExplorerDriver())
            }
        }
    }

    private boolean prepareChromeDriver() {
        // http://www.mkyong.com/java/how-to-decompress-files-from-a-zip-file/
        // http://chromedriver.storage.googleapis.com/2.21/chromedriver_linux32.zip
        if (SystemUtils.IS_OS_LINUX) {
            if (System.getProperty("sun.arch.data.model") == "32") {
                // println "32 bits!"
                // println SystemUtils.OS_ARCH
                System.setProperty("webdriver.chrome.driver", "drivers/linux32/chromedriver")
                return true
            } else if (System.getProperty("sun.arch.data.model") == "64") {
                System.setProperty("webdriver.chrome.driver", "drivers/linux64/chromedriver")
                return true
            }
        } else if (SystemUtils.IS_OS_WINDOWS) {
            if (System.getProperty("sun.arch.data.model") == "32") {
                System.setProperty("webdriver.chrome.driver", "drivers/windows32/chromedriver.exe")
                return true
            } else if (System.getProperty("sun.arch.data.model") == "64") {
                System.setProperty("webdriver.chrome.driver", "drivers/windows64/chromedriver.exe")
                return true
            }
        }
        return false
    }

    private boolean prepareFirefoxDriver() {
        return true
    }

    private boolean prepareHtmlUnitDriver() {
        return true
    }

    private boolean prepareIeDriver() {
        if (SystemUtils.IS_OS_WINDOWS) {
            if (System.getProperty("sun.arch.data.model") == "32") {
                System.setProperty("webdriver.ie.driver", "drivers/windows32/iedriverserver.exe")
                return true
            } else if (System.getProperty("sun.arch.data.model") == "64") {
                System.setProperty("webdriver.chrome.driver", "drivers/windows64/iedriverserver.exe")
                return true
            }
        }
        return false
    }
}


/**
 * Класс действия пользователя
 */
class Actions {

    /**
     * Статичный методы, для быстрого создания действий
     * @param webDriver Веб драйвер {@link WebDriver}
     */
    public static Actions _(WebDriver webDriver) {
        return new Actions(webDriver)
    }

    /**
     * Конструктор
     * @param webDriver Веб драйвер {@link WebDriver}
     */
    public Actions(WebDriver webDriver) {
        setActions(
                new org.openqa.selenium.interactions.Actions(
                        webDriver.getWebDriver()))
    }

    /**
     * Кликнуть левой кнопкой мыши
     * @return Объект Список действий {@link Actions}
     */
    public Actions click() {
        getActions().click()
        return this
    }

    /**
     * Кликнуть левой кнопкой мыши по веб элементу
     * @param webElement Веб элемент {@link WebElement}
     * @return Объект Список действий {@link Actions}
     */
    public Actions click(WebElement webElement) {
        getActions().click(webElement.getWebElement())
        return this
    }

    /**
     * Кликнуть по содержимому
     * @return Объект Список действий {@link Actions}
     */
    public Actions clickContext() {
        getActions().contextClick()
        return this
    }

    /**
     * Кликнуть по содержимому веб элемента
     * @param webElement Веб элемент {@link WebElement}
     * @return Объект Список действий {@link Actions}
     */
    public Actions clickContext(WebElement webElement) {
        getActions().contextClick(webElement.getWebElement())
        return this
    }

    /**
     * Зажать левую кнопку мыши
     * @return Объект Список действий {@link Actions}
     */
    public Actions clickAndHold() {
        getActions().clickAndHold()
        return this
    }

    /**
     * Зажать левую кнопку мыши на веб элементе
     * @param webElement Веб элемент {@link WebElement}
     * @return Объект Список действий {@link Actions}
     */
    public Actions clickAndHold(WebElement webElement) {
        getActions().clickAndHold(webElement.getWebElement())
        return this
    }

    /**
     * Отпустить левую кнопку мыши
     * @return Объект Список действий {@link Actions}
     */
    public Actions releaseHold() {
        getActions().release()
        return this
    }

    /**
     * Отпустить левую кнопку мыши на веб элементе
     * @param webElement Веб элемент {@link WebElement}
     * @return Объект Список действий {@link Actions}
     */
    public Actions releaseHold(WebElement webElement) {
        getActions().release(webElement.getWebElement())
        return this
    }

    /**
     * Кликнуть левой кнопкой мыши два раза
     * @return Объект Список действий {@link Actions}
     */
    public Actions doubleClick() {
        getActions().doubleClick()
        return this
    }

    /**
     * Кликнуть левой кнопкой мыши два раза на веб элемент
     * @param webElement Веб элемент {@link WebElement}
     * @return Объект Список действий {@link Actions}
     */
    public Actions doubleClick(WebElement webElement) {
        getActions().doubleClick(webElement.getWebElement())
        return this
    }

    /**
     * Нажать клавишу-модификатора и удерживать её
     * @param key Код клавиши-модификатора
     * @return Объект Список действий {@link Actions}
     */
    public Actions keyDown(Modificators key) {
        getActions().keyDown((org.openqa.selenium.Keys) key)
        return this
    }

    /**
     * Нажать клавишу-модификатор на веб элементе и удерживать её
     * @param webElement Веб элемент {@link WebElement}
     * @param key Код клавиши-модификатора
     * @return Объект Список действий {@link Actions}
     */
    public Actions keyDown(WebElement webElement, Modificators key) {
        getActions()
                .keyDown(webElement.getWebElement(), (org.openqa.selenium.Keys) key)
        return this
    }

    /**
     * Отпустить нажатую клавишу-модификатор
     * @param key Код клавиши-модификатора
     * @return Объект Список действий {@link Actions}
     */
    public Actions keyUp(Modificators key) {
        getActions().keyUp((org.openqa.selenium.Keys) key)
        return this
    }

    /**
     * Отпустить нажатую клавишу-модификатор на веб элементе
     * @param webElement Веб элемент {@link WebElement}
     * @param key Код клавиши-модификатора
     * @return Объект Список действий {@link Actions}
     */
    public Actions keyUp(WebElement webElement, Modificators key) {
        getActions()
                .keyUp(webElement.getWebElement(), (org.openqa.selenium.Keys) key)
        return this
    }

    /**
     * Отправить нажатие клавиш
     * @param keys Список клавиш
     * @return Объект Список действий {@link Actions}
     */
    public Actions sendKeys(String keys) {
        getActions().sendKeys(keys)
        return this
    }

    /**
     * Отправить нажатие клавиш веб элементу
     * @param element Веб элемент {@link WebElement}
     * @param keys Список кодов клавиш
     * @return Объект Список действий {@link Actions}
     */
    public Actions sendKeys(WebElement webElement, String keys) {
        getActions().sendKeys(webElement.getWebElement(), keys)
        return this
    }

    /**
     * Сместить курсор мыши на заданные отспупы
     * @param xOffset Смещение по X
     * @param yOffset Смещение по Y
     * @return Объект Список действий {@link Actions}
     */
    public Actions mouseMove(int xOffset, int yOffset) {
        getActions().moveByOffset(xOffset, yOffset)
        return this
    }

    /**
     * Переместить курсор мыши на веб элемент
     * @param element Веб элемент {@link WebElement}
     * @return Объект Список действий {@link Actions}
     */
    public Actions mouseMove(WebElement element) {
        getActions().moveToElement(element.getWebElement())
        return this
    }

    /**
     * Перенести один веб элемент на другой
     * @param source Веб элемент который будет перетаскиваться {@link WebElement}
     * @param target Веб элемент на который будет перетаскиваться веб
     *                элемент {@link WebElement}
     * @return Объект Список действий {@link Actions}
     */
    public Actions dragAndDrop(WebElement source, WebElement target) {
        getActions().dragAndDrop(
                source.getWebElement(),
                target.getWebElement())
        return this
    }

    /**
     * Перенести один веб элемент на заданное расстояние
     * @param webElement Веб элемент {@link WebElement}
     * @param xOffset Смещение по X
     * @param yOffset Смещение по Y
     * @return Объект список действий {@link Actions}
     */
    public Actions dragAndDrop(WebElement webElement, int xOffset, int yOffset) {
        getActions().dragAndDropBy(
                webElement.getWebElement(),
                xOffset,
                yOffset
        )
        return this
    }

    /**
     * Выполнить действия
     */
    public void perform() {
        getActions().perform()
    }


    private org.openqa.selenium.interactions.Actions _actions;

    private Actions(org.openqa.selenium.interactions.Actions actions) {
        setActions(actions)
    }

    private org.openqa.selenium.interactions.Actions getActions() {
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

driver.open("http://google.ru")

driver.quit()

/* ------------------------------------------------------------------------------ */
