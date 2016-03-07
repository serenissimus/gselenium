## Класс Date
[тег]: Date
```groovy
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
```groovy
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
```groovy
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
```groovy
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
```groovy
// получаем список Cookie
def cookies = webDriver.getCookies()

// запускаем цикл прохода по списку Cookie
for (def i = 0; i < cookies.size(); ++i) {

    // печатаем имя Cookie
    println "Имя = " + cookies[i].getName()

    // печатаем значение Cookie
    println "Значение = " + cookies[i].getValue()
}
```

Установка Cookie сессии для "КиноПоиск"
```groovy
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
```groovy
// получаем список Cookie
def allCookies = webDriver.getCookies()

// запускаем цикл прохода по списку Cookie
for (def j = 0; j < allCookies.size(); ++j) {

    // проверяем что домен у Cookie содержит "google"
    if (allCookies[j].getDomain().contains("google")) {

        // удаляем эти Cookie
        webDriver.deleteCookie(allCookies[j])
    }
}
```


## Класс WebElement
[тег]: WebElement
```groovy
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
```groovy
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
```groovy
// получаем список картинок по CSS-селектору
// если не найдётся ни одна картинка, то размер массива будет 0
def elementsImg = webDriver.findElements("img")

// запускаем цикл прохода по списку картинок
for (def i = 0; i < elementsImg.size(); ++i) {

    // печатаем координаты и размер каждой картинки
    println "X = " + elementsImg[i].getX()
    println "Y = " + elementsImg[i].getY()
    println "Width = " + elementsImg[i].getWidth()
    println "Height = " + elementsImg[i].getHeight()
}
```


## Класс WebDriver
[тег]: WebDriver
```groovy
// Класс для взаимодействия с веб браузером
class WebDriver

    // Конструктор с параметром типа браузера
    //   параметр type: Строка тип браузера ("Chrome", "Firefox", "HtmlUnit", "Ie")
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
```

#### Пример работы с классом WebDriver

Создание браузера Chrome
```groovy
// создаём окно браузера Chrome
def webDriver = new WebDriver(WebDriver.Type.Chrome)

// открываем Google
webDriver.open("http://google.com")

// печатаем текущий адрес страницы
println "Url = " + webDriver.getUrl()

// печатаем текущий заголовок страницы
println "Title = " + webDriver.getTitle()

// делаем скриншот содержимого окна браузера
webDriver.getScreenshot("screenshot.png")

// закрываем окно браузера
webDriver.quit()
```

Перемещение и изменение размера окна браузера
```groovy

// устанавливаем координату X окна браузера
webDriver.setX(0)

// устанавливаем координату Y окна браузера
webDriver.setY(0)

// устанавливаем ширину окна браузера
webDriver.setWidth(1024)

// устанавливаем высоту окна браузера
webDriver.setHeight(768)

// печатаем координату X окна браузера
println "X = " + webDriver.getX()
// печатаем координату Y окна браузера
println "Y = " + webDriver.getY()
// печатаем ширину окна браузера
println "Width = " + webDriver.getWidth()
// печатаем высоту окна браузера
println "Height = " + webDriver.getHeight()

// максимизируем("распахиваем") окно браузера
webDriver.maximize()

// печатаем координату X окна браузера
println "X = " + webDriver.getX()
// печатаем координату Y окна браузера
println "Y = " + webDriver.getY()
// печатаем ширину окна браузера
println "Width = " + webDriver.getWidth()
// печатаем высоту окна браузера
println "Height = " + webDriver.getHeight()
```

Работа с Cookie
```groovy
// берём список Cookie
def cookies = webDriver.getCookies()

// печатаем количество Cookie
println "Cookies count = " + cookies.size()


// удаляем все Cookie
webDriver.deleteAllCookies()


// создаём новый Cookie
def cookie = new Cookie()

//заполняем значения Cookie
cookie.setDomain("google.com")
cookie.setPath("/")
cookie.setName("Session")
cookie.setValue("112233445566778899aa")

// создаём дату
def date = new Date()

// устанавливаем значения даты
date.setYear(2000)
date.setMonth(2)
date.setDay(2)
date.setHours(15)
date.setMinutes(56)
date.setSeconds(34)

// устанавливаем дату "протухания" Cookie
cookie.setExpiry(date)

// добавляем новый Cookie в браузер
webDriver.addCoockie(cookie)
```

Поиск веб элементов
```groovy
// ищем веб элемент с id="id-el"
def element = webDriver.findElement("#id-el")

// проверяем найден ли веб элемент
if (element != null) {
    // если найден то печатаем информацию что нашли веб элемент
    println "Web element found"
}

// получаем список картинок
def elements = webDriver.findElements("img")

// печатаем количество найденых картинок
println "Images count = " + elements.size()
```


## Класс Actions
[тег]: Actions
```groovy
// Класс для создания цепочек действия и выполнения их в браузере
class Actions

    // Конструктор с параметром на текущий WebDriver
    //   параметр webDriver: Объект класса WebDriver
    Actions(WebDriver webDriver)

    // Кликнуть левой кнопкой мыши
    void click()

    // Кликнуть левой кнопкой мыши по заданному веб элементу
    //   параметр webElement: Объект класса WebElement
    void click(WebElement webElement)

    // Кликнуть левой кнопкой мыши два раза
    void doubleClick()

    // Кликнуть левой кнопкой мыши два раза по заданному веб элементу
    //   параметр webElement: Объект класса WebElement
    void doubleClick(WebElement webElement)

    // Отправить нажатие клавиш
    //   параметр keys: Строка
    void sendKeys(String keys)

    // Отправить нажатие клавиш заданному веб элементу
    //   параметр webElement: Объект класса WebElement
    //   параметр keys: Строка
    void sendKeys(WebElement webElement, String keys)

    // Сместить курсор мыши на заданные отступы
    //   параметр xOffset: Целое число
    //   параметр yOffset: Целое число
    void mouseMove(int xOffset, int yOffset)

    // Переместить курсор мыши на заданный веб элемент
    //   параметр webElement: Объект класса WebElement
    void mouseMove(WebElement webElement)

    // Выполнить цепочку действий
    void perform()
```

#### Пример работы с классом Actions

Ввод текста в поля
```groovy
// создаём объект действий
def actions = new Actions(webDriver)

// находим наше поля ввода
def elementInput = webDriver.findElement("#inp")

// если поле ввода найдено
if (elementInput != null) {
    // добавляем действие ввода текста в поле
    actions.sendKeys(elementInput, "hello world")
    // добавляем действие нажатие Enter
    actions.sendKeys(elementInput, Keys.ENTER)
    // просим выполнить наши действия
    actions.perform()
}
```

Клик и двойной клик по веб элементам
```groovy
// создаём объект действий
def actions = new Actions(webDriver)
// находим кнопку с id=btn1
def elementButton1 = webDriver.findElement("#btn1")
// находим кнопку с id=btn2
def elementButton2 = webDriver.findElement("#btn2")

// если обе кнопки найдены
if ((elementButton1 != null) && (elementButton2)) {
    // добавляем действие перемещение курсора на кнопку 1
    actions.mouseMove(elementButton1)
    // добавляем действие клика по кнопке
    actions.click()
    // добавляем действие перемещение курсора на кнопку 2
    actions.mouseMove(elementButton2)
    // добавляем действие двойного клика
    actions.doubleClick()
    // просим выполнить наши действия
    actions.perform()
}
```

Упрощёная форма клика по элементам(без перемещения курсора)
```groovy
// создаём объект действий
def actions = new Actions(webDriver)
// находим картинку с id=img
def elementImg = webDriver.findElement("#img")

// если картинка найдена
if (elementImg != null) {
    // добавляем действие клика по картинке
    actions.click(elementImg)
    // просим выполнить наши действия
    actions.perform()
}
```

Клик по всем картинкам на странице
```groovy
// создаём объект действий
def actions = new Actions(webDriver)
// находим все картинки на странице
def elementsImgs = webDriver.findElements("img")

// запускаем цикл прохода по всем картинкам в нашем списке
// если конечно на сайте есть картинки
for (def i = 0; i < elementsImgs.size(); ++i) {
    // добавляем действие клика по картинке
    actions.click(elementsImgs[i])
}

// если картинок нет, то нет смысла выполнять действия
// проверяем что хоть одна картинка есть
if (elementsImgs.size() > 0) {
    // просим выполнить наши действия
    actions.perform()
}
```
