package service;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;


@Slf4j
public class FileConverter {
    @SneakyThrows
    public static void fileConvert(String[] args){
        String sourceFilePath = null;
        String destinationFilePath = null;

        switch (args.length) {
            case 2 -> {
                sourceFilePath = args[0];
                destinationFilePath = args[1];
            }
            case 0 -> {
                sourceFilePath = UserMenu.getInputFile();
                destinationFilePath = UserMenu.getOutputFile();
            }
            default -> {
                System.err.println("Неверное количество аргументов! Введите 2 аргумента для автоматического режима. Если вы хотите ручной режим не вводите аргументов");
                log.error("Неверное количество аргументов!");
            }
        }
        log.info("Данные о файлах считаны!");

        val converter = ConvertingSelector.choiseConverter(sourceFilePath, destinationFilePath);
        converter.convert(sourceFilePath, destinationFilePath);

        System.out.println("онвертация файла" + sourceFilePath + " в файл" + destinationFilePath + " выполнена успешно");
        log.info("Конвертация файла {} в файл {} выполнена успешно", sourceFilePath, destinationFilePath);
    }
}
