## Класс Date
[тег]: Date
```java
// Класс для работы с датой
class Date

    // Конструктор
    Date()

     // Вернуть год
     //   возвращает: Целое число
    int getYear()

    // Установить год
    //   параметр year: Целое число
    void setYear(int year)

     // Вернуть месяц
     //   возвращает: Целое число от 1 до 12 включительно
    int getMonth()

    // Устаовить месяц
    //   параметр month: Целое число от 1 до 12 включительно
    void setMonth(int month)

    // Вернуть день
    //   возвращает: Целое число от 1 до 28,29,30,31 включительно
    //               в зависости от месяца и года
    int getDay()

    // Установить день
    //   параметр day: Целое число от 1 до 28,29,30,31 включительно
    //                 в зависости от месяца и года
    void setDay(int day)

    // Вернуть часы
    //   возвращает: Целое число от 0 до 23 включительно
    int getHours()

    // Установить часы
    //   параметр hours: Целое число от 0 до 23 включительно
    void setHours(int hours)

    // Вернуть минуты
    //   возвращает: Целое число от 0 до 59 включительно
    int getMinutes()

    // Установить минуты
    //   параметр minutes: Целое число от 0 до 59 включительно
    void setMinutes(int minutes)

    // Вернуть секунды
    //   возвращает: Целое число от 0 до 59 включительно
    int getSeconds()

    // Установить секунды
    //   параметр seconds: Целое число от 0 до 59 включительно
    void setSeconds(int seconds)
```

#### Пример работы с классом Date

Получаем дату "протухания" Cookie
```java
// получаем дату у Cookie
def date = cookie.getExpiry()

// !!! обязательно надо проверить что дата установлена
if (date != null) {
    // печатаем в консоль информацию
    println "Год протухания = " + date.getYear()
    println "Месяц протухания = " + date.getMonth()
    println "День протухания = " + date.getDay()
    println "Часы протухания = " + date.getHours()
    println "Минуты протухания = " + date.getMinutes()
    println "Секунды протухания = " + date.getSeconds()
}
```

Меняем дату у Cookie
```java
// создаём объект
def newDate = new Date()

// устанавливаем время
newDate.setYear(200)
newDate.setMonth(1)
newDate.setDay(1)
newDate.setHours(12)
newDate.setMinutes(10)
newDate.setSeconds(56)

// устанавливаем дату на Cookie
cookie.setExpiry(newDate)
```


## Класс Cookie
[тег]: Cookie
```java
// Класс для работы с Cookie
class Cookie

    // Конструктор
    Cookie()

    // Вернуть домен
    //   возвращает: Строка
    String getDomain()

    // Установить домен
    //   параметр domain: Строка
    void setDomain(String domain)

    // Вернуть путь
    //   возвращает: Строка
    String getPath()

    // Установить путь
    //   параметр path: Строка
    void setPath(String path)

    // Вернуть имя
    //   возвращает: Строка
    String getName()

    // Установить имя
    //   параметр name: Строка
    void setName(String name)

    // Вернуть значение
    //   возвращает: Строка
    String getValue()

    // Установить значение
    //   параметр value: Строка
    void setValue(String value)

    // !!! Может вернуть null если сервер не установил дату "протухания" cookie !!!
    // Вернуть дату "протухания" cookie
    //   возвращает: Объект класса Date или null
    Date getExpiry()

    // Установить дату "протухания" cookie
    //   параметр expiry: Объект класса Date
    void setExpiry(Date expiry)
```

#### Пример работы с классом Cookie

Получение списка Cookie и их распечатка(неполная)
```java
// получаем список Cookie
def cookies = webDriver.getCookies()

// запускаем цикл прохода по списку Cookie
for (def i = 0; i < cookies.length; ++i) {

    // печатаем имя Cookie
    println "Имя = " + cookies[i].getName()

    // печатаем значение Cookie
    println "Значение = " + cookies[i].getValue()
}
```

Установка Cookie сессии для "КиноПоиск"
```java
// создаём Cookie
def cookieKinopoisk = new Cookie()

// заполняем его информацией
cookieKinopoisk.setDomain(".kinopoisk.ru")
cookieKinopoisk.setPath("/")
cookieKinopoisk.setName("PHPSESSID")
cookieKinopoisk.setValue("1122aabbccddffee")
// дату "протухания" не задаём(при желании можно задать - см. пример работы с Датой)

// устанавливаем Cookie
webDriver.addCoockie(cookieKinopoisk)
```

Удаляем Cookie от google
```java
// получаем список Cookie
def allCookies = webDriver.getCookies()

// запускаем цикл прохода по списку Cookie
for (def j = 0; j < allCookies.length; ++j) {

    // проверяем что домен у Cookie содержит "google"
    if (allCookies[j].getDomain().contains("google")) {

        // удаляем эти Cookie
        webDriver.deleteCookie(allCookies[j])
    }
}
```


## Класс WebElement
[тег]: WebElement
```java
// Класс для работы с веб элементами на странице
class WebElement

    // Вернуть координату X вернего левого угла веб элемента от верхнего левого
    // угла веб страницы
    //   возвращает: Целое число
    int getX()

    // Вернуть координату Y вернего левого угла элемента от верхнего левого
    // угла веб страницы
    //   возвращает: Целое число
    int getY()

    // Вернуть ширину веб элемента
    //   возвращает: Целое число
    int getWidth()

    // Вернуть высоту веб элемента
    //   возвращает: Целое число
    int getHeight()

    // Виден ли веб элемент странице?
    //   возвращает: Булевское значение
    boolean isDisplayed()

    // Включен ли веб элемент?
    //   возвращает: Булевское значение
    boolean isEnabled()

    // Выбран ли веб элемент?
    //   возвращает: Булевское значение
    boolean isSelected()
```

#### Пример работы с классом WebElement

Получение веб элемента
```java
// ищем нащ веб элемент по CSS-селектору через WebDriver
def elementInput = webDriver.findElement("#inp")

// !!! может вернуть null если элемент не найден
// проверяем что веб элемент найден
if (elementInput != null) {
    println "Виден ли = " + elementInput.isDisplayed()
    println "Включен ли = " + elementInput.isEnabled()
    println "Выбран ли = " + elementInput.isSelected()
}
```

Получение списка веб элементов
```java
// получаем список картинок по CSS-селектору
// если не найдётся ни одна картинка, то размер массива будет 0 
def elementsImg = webDriver.findElements("img")

// запускаем цикл прохода по списку картинок
for (def i = 0; i < elementsImg.length; ++i) {

    // печатаем координаты и размер каждой картинки
    println "X = " + elementsImg[i].getX()
    println "Y = " + elementsImg[i].getY()
    println "Width = " + elementsImg[i].getWidth()
    println "Height = " + elementsImg[i].getHeight() 
}
```


## Класс WebDriver
[тег]: WebDriver
```java
// Класс для взаимодействия с веб браузером
class WebDriver 

    // Конструктор с параметром типа браузера
    //   параметр type: Строка ("Chrome","Firefox","Htmlunit","Ie")
    WebDriver(String type)

    // Открыть страницу сайта в браузере
    //   параметр url: Строка адрес
    void open(String url)
    
    // Закрыть браузер
    void quit()

    // Вернуть адрес страницы
    //   возвращает: Строка
    String getUrl()

    // Вернуть заголовок страницы
    //   возвращает: Строка
    String getTitle()

    // Сделать и сохранить скриншот экрана по пути
    //   параметр screenshotSavePath: Строка
    void getScreenshot(String screenshotSavePath)

    // Вернуть положение окна браузера по X относительно верхнего левого угла
    //   возвращает: Целое число
    int getX()

    // Установить положение окна браузера по X относительно верхнего левого угла
    //   параметр x: Целое число
    void setX(int x) 

    // Вернуть положение окна браузера по Y относительно верхнего левого угла
    //   возвращает: Целое число
    int getY()
    
    // Установить положение окна браузера по Y относительно верхнего левого угла
    //   параметр y: Целое число
    void setY(int y)
    
    // Вернуть ширину окна браузера
    //   возвращает: Целое число
    int getWidth()

    // Установить ширину окна браузера
    //   параметр width: Целое число
    void setWidth(int width)

    // Вернуть высоту окна браузера
    //   возвращает: Целое число
    int getHeight()

    // Установить высоту окна браузера
    //   параметр height: Целое число
    void setHeight(int height) 

    // Максимализировать("распахнуть") окно браузера во весь экран
    void maximize()

    // !!! Может вернуть null если веб элемент не найден !!!
    // Найти и вернуть веб элемент по CSS селектору
    //   параметр cssPath: Строка
    //   возвращает: Объект класса WebElement или null
    WebElement findElement(String cssPath)

    // Найти и вернуть список веб элементов по CSS селектору
    //   параметр cssPath: Строка
    //   возвращает: Список объектов класса WebElement
    List<WebElement> findElements(String cssPath)

    // Вернуть список Cookie
    //   возвращает: Список объектов класса Cookie 
    List<Cookie> getCookies()

    // Добавить Cookie
    //   параметр cookie: Объект класса Cookie
    void addCoockie(Cookie cookie)
    
    // Удалить Cookie
    //   параметр cookie: Объект класса Cookie
    void deleteCookie(Cookie cookie)

    // Удалить все Cookie
    void deleteAllCookies()
    
    // Выполнить JavaScript. Параметры для скрипта передаются вторым параметром.
    // Параметры внутри JavaScript можно получить через
    // "arguments[<индекс аргумента>]"
    //   параметр script: Строка
    //   параметр arguments: Список объектов
    void executeJavaScript(String script, List<Object> arguments)
```

#### Пример работы с классом WebDriver

```java
```


## Класс Actions
[тег]: Actions
```java
// Класс для создания цепочек действия и выполнения их в браузере
class Actions

    // Конструктор с параметром на текущий WebDriver
    //   параметр webDriver: Объект класса WebDriver
    Actions(WebDriver webDriver)

    // Кликнуть левой кнопкой мыши
    //   возвращает: Объект класса Actions
    Actions click()

    // Кликнуть левой кнопкой мыши по заданному веб элементу
    //   параметр webElement: Объект класса WebElement
    //   возвращает: Объект класса Actions
    Actions click(WebElement webElement)

    // Кликнуть по содержимому
    //   возвращает: Объект класса Actions
    Actions clickContext()
    
    // Кликнуть по содержимому заданного веб элемента
    //   параметр webElement: Объект класса WebElement
    //   возвращает: Объект класса Actions
    Actions clickContext(WebElement webElement)
    
    // Зажать левую кнопку мыши
    //   возвращает: Объект класса Actions
    Actions clickAndHold()

    // Зажать левую кнопку мыши на заданный веб элементе
    //   параметр webElement: Объект класса WebElement
    //   возвращает: Объект класса Actions
    Actions clickAndHold(WebElement webElement) 

    // Отпустить левую кнопку мыши
    //   возвращает: Объект класса Actions
    Actions releaseHold()

    // Отпустить левую кнопку мыши на заданном веб элементе
    //   параметр webElement: Объект класса WebElement
    //   возвращает: Объект класса Actions
    Actions releaseHold(WebElement webElement)

    // Кликнуть левой кнопкой мыши два раза
    //   возвращает: Объект класса Actions
    Actions doubleClick()

    // Кликнуть левой кнопкой мыши два раза по заданному веб элементу
    //   параметр webElement: Объект класса WebElement
    //   возвращает: Объект класса Actions
    Actions doubleClick(WebElement webElement)

    // Нажать клавишу-модификатор и удерживать её
    //   параметр key: Клавиша-модификатор
    //   возвращает: Объект класса Actions
    Actions keyDown(Modificators key)

    // Нажать клавишу-модификатор на заданном веб элементе и удерживать её
    //   параметр webElement: Объект класса WebElement
    //   параметр key: Клавиша-модификатор
    //   возвращает: Объект класса Actions
    Actions keyDown(WebElement webElement, Modificators key)

    // Отпустить нажатую клавишу-модификатор
    //   параметр key: Клавиша-модификатор
    //   возвращает: Объект класса Actions
    Actions keyUp(Modificators key)
    
    // Отпустить нажатую клавишу-модификатор на заданном веб элементе
    //   параметр webElement: Объект класса WebElement
    //   параметр key: Клавиша-модификатор
    //   возвращает: Объект класса Actions
    Actions keyUp(WebElement webElement, Modificators key)

    // Отправить нажатие клавиш
    //   параметр keys: Строка
    //   возвращает: Объект класса Actions
    Actions sendKeys(String keys)
    
    // Отправить нажатие клавиш заданному веб элементу
    //   параметр webElement: Объект класса WebElement
    //   параметр keys: Строка
    //   возвращает: Объект класса Actions
    Actions sendKeys(WebElement webElement, String keys)

    // Сместить курсор мыши на заданные отступы
    //   параметр xOffset: Целое число
    //   параметр yOffset: Целое число
    //   возвращает: Объект класса Actions
    Actions mouseMove(int xOffset, int yOffset)

    // Переместить курсор мыши на заданный веб элемент
    //   параметр webElement: Объект класса WebElement
    //   возвращает: Объект класса Actions
    Actions mouseMove(WebElement webElement)
    
    // Переместить один веб элемент на другой
    //   параметр source: Объект класса WebElement
    //   параметр target: Объект класса WebElement
    //   возвращает: Объект класса Actions
    Actions dragAndDrop(WebElement source, WebElement target)

    // Переместить один веб элемент на заданный отступ
    //   параметр webElement: Объект класса WebElement
    //   параметр xOffset: Целое число
    //   параметр yOffset: Целое число
    //   возвращает: Объект класса Actions
    Actions dragAndDrop(WebElement webElement, int xOffset, int yOffset)

    // Выполнить цепочку действий
    void perform()
```

#### Пример работы с классом Actions

```java
```
