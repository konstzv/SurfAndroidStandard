[Главная](../../main.md)

[TOC]



# MVP-Rx
## Общее
### BindModel
Это сущность созданая для замены ScreenModel. Ключевая разница в них, то
что ScreenModel отражает в идеале текущее состояние объекта. В то время
как BindModel служит для того чтобы организовать обмен данными между
View и Presenter. Можно рассматривать BindModel как интерфейс в
широком смысле этого слова.

### Потоки данных
В рамках архитектуры подразумвается организация двух направлений
потоков данных
* от view к presentor`у (view > view binding > presenter)
* от presentor`a ко view (presenter > view binding > view)
* Важно отметить, что здесь не регламентируется связь презентора и модели

### Направленность потока
Под направленностью потоков подразумевается то, что данные могут быть
отправлены определенным типом отправителей для определнного типа получателей.
Например, view могут посылать данные только для презентора и подписаться
на поток могут только презенторы и никто больше, в том числе эта
возможность недоступна и для самих view.

### Relation
Механизм организации направлености потоков. Подразумевает, что у потока
есть отправитель и получатель. Соответственно, отправитель может быть
либо источником данных для одного потока, либо получателем этих данных.

#### Сущности

##### [`RelationEntity`][related]
Тип источника или получателя. В данный момент сейчас это View и Presenter

##### [`Related`][related]
Конечный объект который будет источником или получателем. Имеет тип
`RelationEntity`

##### [`Relation`][related]
Направленный поток данных, связывает два `Related` объекта для передачи
данных.

Реализованы следующие типы:

* `Action` Деиствие исходящее от пользователя. При подписке эмитит
последний объект. Симметрично State.

* `State` Изменение состояния исходящее из ui/бизнес-логики. При
подписке эмитит последний объект. Симетрично Action.

* `Bond` Action и State в одной сущности.

* `Command` Во многом повторяет State за тем исключением, что не хранит
последний объект, и потому не эмитит его при подписке.

## Известные проблемы/тонкости

### Null-нетерпимость
Реализация основанна на [RxRely][rxrelylib] потому не принимает null.
Как и вся RxJava2

### Зацикливание
Описание проблемы [здесь][pmexist]
По возможности, старайтесь избегать. Если все же нужно циклическое
связвание данных, то предусмотрите выход на строне презентора или вью.

## Рекомендуется к использованию

* [RxBinding][rxbindinglib]
* [RxRelay][rxrelylib]
* [RxKotlin][rxkotlin]


[rxbindinglib]: https://github.com/JakeWharton/RxBinding
[rxrelylib]: https://github.com/JakeWharton/RxRelay
[pmexist]: https://habr.com/company/mobileup/blog/342850/
[pmenter]: https://habr.com/company/mobileup/blog/326962/
[pmscheme]: https://habrastorage.org/webt/rz/nb/rh/rznbrht-4vw_74h6wzrjrui8upk.png
[related]: src/main/java/ru/surfstudio/android/core/mvp/rx/domain/Relation.kt
[rxkotlin]: https://github.com/ReactiveX/RxKotlin


# Core mvp binding (deprecated)
**(Данный модуль является экспериментальным и не является обязательным
стандартом использования в проекте)**
Поддежка data-binding

Основные классы:
* [`BindData`][bd]
* [`BindsHolder`][bh]
* [`BaseBindableView`][bbv]
* [`BaseBindingPresenter`][bbp]

# Использование
[Пример использования](../core-mvp-binding-sample)

# Подключение
Для подключения данного модуля из [Artifactory Surf](http://artifactory.surfstudio.ru)
необходимо, чтобы корневой `build.gradle` файл проекта был сконфигурирован так,
как описано [здесь](https://bitbucket.org/surfstudio/android-standard/overview).
  
Для подключения модуля через Gradle:
```
    implementation "ru.surfstudio.android:core-mvp-binding:X.X.X"
```

[bd]: src/main/java/ru/surfstudio/android/core/mvp/binding/BindData.kt
[bh]: src/main/java/ru/surfstudio/android/core/mvp/binding/BindsHolder.kt
[bbv]: src/main/java/ru/surfstudio/android/core/mvp/binding/BaseBindableView.kt
[bbp]: src/main/java/ru/surfstudio/android/core/mvp/binding/BaseBindingPresenter.kt