# FileConverter
## Описание проекта
`FileConverter` - программа, позволяющая конвертировать данные из xml в json, и наоборот.
## Использование
Запуск происходит при помощи командной строки. Входными данными служат 2 аргумента:
1. Исходный путь файла, который необходимо конвертировать
1. Путь сохранения файла, содержащего результаты преобразования.
## ПО для сборки и запуска
Рекомендуемая версия Intellij Idea - 2023.2.3
## Структура проекта
- `src/main`: основная папка проекта
  - `java/service`: папка в которой находится основной код проекта
  - `resources`: примеры xml и json файлов
## Пример использования
- Для запуска конвертации xml в json, необходимо выполнить запрос следующей команды:
```
java -jar {Путь к файлу jar} -s{Путь к исходному файлу xml} -d{Путь к создаваемому файлу json}
```
- Для запуска конвертации json в xml, необходимо выполнить запрос следующей команды:
```
java -jar {Путь к файлу jar} -s{Путь к исходному файлу json} -d{Путь к создаваемому файлу xml}
```
