# Wishes

Wishes - простое Android приложение, которое генерирует романтические эмоджи, дневные пожелания и ночные пожелания. Дневное или ночное пожелание состоит из пожелания, фразы "Доброе утро" или "Спокойной ночи", комплимента и эмоджи.

Романтические эмоджи:
♥️💘💝💖💗💓💞💕❣❤😻🥰😍😘

___

## Оглавление

- [Технологии](#Технологии)
- [Требования и установка](#Требования-и-установка)
- [Использование](#Использование)
- [TODO](#TODO)
- [Лицензия](#Лицензия)
- [Разработчик](#Разработчик)

___

## Технологии

	* Kotlin
	* Jetpack Compose
	* kotlinx.coroutines
	* Dagger Hilt
	* JUnit 4

___

## Требования и установка

### Требования

Минимальная версия: Android 8.0

### Установка

#### Способ 1
1. Склонировать к себе репозиторий проекта, выполнив команду  
`git clone https://github.com/ImmortalIdiot/WishesCompose`
2. Открыть проект в Android Studio;
3. Загрузить все зависимости;
4. Подключить устройство Android по кабелю;
5. Запустить проект;
6. Согласиться с установкой из других источников при необходимости.
  
Если всё прошло успешно, то приложение появится на смартфоне.

#### Способ 2
1. Скачать `Wishes.apk` по [ссылке](https://github.com/ImmortalIdiot/WishesCompose/releases/tag/v1.0.0);
2. При установке будет запрос на проверку приложения - нажать "Проверить";
3. После проверки нажать "Установить".

Если всё прошло успешно, то приложение появится на смартфоне.
  
Если возникли проблемы с установкой - напишите в [Telegram](https://t.me/Immortal_Idiot) с описанием проблемы, и на каком этапе она возникла.
___

## Использование

### Первый экран

При входе в приложение пользователь увидит окно, в котором он сможет выбрать один из режимов: генерацию эмоджи, генерацию дневного пожелания, генерацию ночного пожелания или узнать краткую информацию о разработчике.

![MainScreen](https://github.com/user-attachments/assets/458ace28-0c56-41d1-90a1-ae5da9e279fa)

### Режим "Генератор эмоджи"

![EmojiGenerator](https://github.com/user-attachments/assets/d1db3d18-411e-4af6-9d45-f19b690a8c92)

В этом режиме пользователь вводит в поле число от *1* до *2000* (включая границы) и нажимает на кнопку "Сгенерировать". Если поле ввода не пустое, то программа сгенерирует строку, состоящую из романтических эмоджи в произвольном порядке и скопирует их в буфер обмена. Причём, число сгенерированных эмоджи будет равно введённому пользователем числу.

![image](https://github.com/user-attachments/assets/a3963e96-cce4-47e9-ac07-1a89e4eb539a)

Если пользователь снова нажмёт на кнопку "Сгенерировать", то программа сгенерирует эмоджи в произвольном порядке. Сгенерированные эмоджи также скопируются в буфер обмена. Число эмоджи будет равно введённому пользователем числу.

### Режим "Дневное пожелание"

![image](https://github.com/user-attachments/assets/ef10dcaf-3e07-4014-b2aa-b6c79b527251)

В этом режиме, также как и в режиме "Генерация эмоджи", пользователь вводит в поле число от *1* до *2000* (включая границы) и нажимает на кнопку "Сгенерировать". Если поле ввода не пустое, то программа сгенерирует дневное пожелание и романтические эмоджи и скопирует их (пожелание вместе с эмоджи) в буфер обмена.

![DayWishAfterFirstGeneration](https://github.com/user-attachments/assets/e89424a0-e7a2-49c2-9e3d-21f2f9cca5b7)

Если нажать на кнопку "Сгенерировать" ещё раз, то текст пожелания изменится на другой, эмоджи сгенерируются в другом порядке, и пожелание вместе с эмоджи скопируются в буфер обмена. Количество эмоджи будет равно введённому пользователем числу.

![DayWishAfterSecondGeneration](https://github.com/user-attachments/assets/95728ff9-c50a-4672-9f26-e0229dcfcae2)

### Режим "Ночное пожелание"

![NightWishGenerator](https://github.com/user-attachments/assets/24eed85b-38da-4910-a1ed-c1d43a233760)

Этот режим схож с [предыдущим](#Режим Дневное пожелание). Пользователь вводит в поле число от *1* до *2000* (включая границы) и нажимает на кнопку "Сгенерировать". Если поле ввода не пустое, то программа сгенерирует ночное пожелание с романтическими эмоджи и скопирует их (пожелание и эмоджи) в буфер обмена.

![NightWishAfterFirstGeneration](https://github.com/user-attachments/assets/0998ec45-8482-47f8-99f5-79b8c412f2e4)

Если нажать на кнопку "Сгенерировать" ещё раз, то текст пожелания изменится на другой, эмоджи сгенерируются в другом порядке, и пожелание вместе с эмоджи скопируются в буфер обмена. Количество эмоджи будет равно введённому пользователем числу.

![NightWishAfterSecondGeneration](https://github.com/user-attachments/assets/6e12b717-3d90-4300-bd0c-89c2040c3e43)

### "Разработчики"

![Developer](https://github.com/user-attachments/assets/dc10218b-1d16-45bd-bec8-3ffbc6b79310)

Если нажать на имя разработчика, то приложение перебросит в Telegram чат с разработчиком.
___

## TODO

- Поддержка любых положений экранов (книжная, альбомная ориентации);
- Поддержка выбора пола (кому будет направлено пожелание);
- Возможность изменения списка пожеланий, комплиментов и эмоджи;
- Возможность самому написать фразу и к ней сгенерировать эмоджи;
- История генерации

___

## Лицензия

MIT License

Copyright (c) 2024 Krasulya Maxim

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

___

## Разработчик

Krasulya Maxim

Telegram: https://t.me/Immortal_Idiot  
Emal: max.krasulya@yandex.ru
