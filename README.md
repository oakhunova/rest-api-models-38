# Проект автоматизации тестирования API для сайта [ReqRes](https://reqres.in/)
<p align="center"> <img width="60%" title="ReqRes logo" src="media/logo/Reqres.png">

## Содержание:

- [Использованный стек технологий](#использованный-стек-технологий)
- [Запуск тестов из терминала](#запуск-тестов-из-терминала)
- [Сборка в Jenkins](#jenkins-build)
- [Allure Report](#allure-report)
- [Уведомления о результатах тестов в Telegram с использованием бота](#telegram)

## Использованный стек технологий

<p align="center">
<a href="https://www.java.com/"><img width="6%" title="Java" src="media/logo/Java-original-wordmark.svg"></a>
<a href="https://rest-assured.io/"><img width="6%" title="RestAssured" src="media/logo/RestAssured.png"></a>
<a href="https://gradle.org/"><img width="6%" title="Gradle" src="media/logo/Gradle-original.svg"></a>
<a href="https://junit.org/junit5/"><img width="6%" title="JUnit5" src="media/logo/Junit-original-wordmark.svg"></a>
<a href="https://selenide.org/"><img width="6%" title="Selenide" src="media/logo/Selenide.svg"></a>
<a href="https://www.jenkins.io/"><img width="6%" title="Jenkins" src="media/logo/Jenkins-original.svg"></a>
<a href="https://github.com/allure-framework/allure2"><img width="6%" title="Allure Report" src="media/logo/Allure-Report.svg"></a>
<a href="https://telegram.org/"><img width="6%" title="Telegram" src="media/logo/Telegram.svg"></a>
<a href="https://www.jetbrains.com/idea/"><img width="6%" title="IntelliJ IDEA" src="media/logo/Intellij-original.svg"></a>
<a href="https://github.com/"><img width="6%" title="GitHub" src="media/logo/Github-original.svg"></a>
</p>

- В данном проекте автотесты написаны на языке <code>Java</code> с использованием библиотеки <code>REST assured</code>.
- В качестве сборщика был использован <code>Gradle</code>.
- Использованы фреймворки <code>JUnit 5</code> и <code>Selenide</code>.
- Для удаленного запуска реализована джоба в <code>Jenkins</code> с формированием  <code>Allure-отчета</code> и отправкой результатов в <code>Telegram</code> при помощи бота.

## Запуск тестов из терминала

### Команда для запуска из терминала
```
gradle clean test -DxApiKey=<x-api-key>
```
### Удаленный запуск в Jenkins
```
clean test
-DxApiKey=${x-api-key}
```

<a id="jenkins-build"></a>
## <a href="https://jenkins.autotests.cloud/job/qa_guru_38_alfa_main_page_ui/"><img width="4%" style="vertical-align:middle" title="Jenkins" src="media/logo/Jenkins-original.svg">Сборка в Jenkins</a>

[//]: # (## [<img width="4%" style="vertical-align:middle" title="Jenkins" src="media/logo/Jenkins-original.svg"> Сборка в Jenkins]&#40;https://jenkins.autotests.cloud/job/qa_guru_38_alfa_main_page_ui/&#41;)

Для запуска тестов в Jenkins нужно необходимо на кнопку Build Now в соответствующей сборке
<p align="center">
<img title="Jenkins Build" src="media/screens/Сборка%20Jenkins.jpg">
</p>

<a id="allure-report"></a>
## <a href="https://jenkins.autotests.cloud/job/qa_guru_38_alfa_main_page_ui/15/allure/"><img width="4%" style="vertical-align:middle" title="Allure Report" src="media/logo/Allure-Report.svg"> Пример Allure отчета</a>

### *Основная страница*
<p align="center">
<img title="Allure Report" src="media/screens/Allure%20отчет.jpg">
</p>

### *Тест-кейсы*
<p align="center">  
<img title="Allure Tests" src="media/screens/Allure%20тесты.jpg" width="850">  
</p>

<a id="telegram"></a>
### <img width="4%" style="vertical-align:middle" title="Telegram" src="media/logo/Telegram.svg"> Уведомления о результатах тестов в Telegram с использованием бота

<p align="center">
<img width="70%" title="Telegram Notifications" src="media/screens/Telegram%20bot.jpg">
</p>