package service;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.commons.cli.*;

import java.io.*;
import java.util.Optional;
import java.util.Scanner;


@Slf4j
public class FileConverter {
    @SneakyThrows
    public static void main(String[] args) {
        Options options = new Options();

        options.addOption(Option.builder("s").longOpt("source").hasArg().desc("Путь к исходному файлу").build());
        options.addOption(Option.builder("d").longOpt("destination").hasArg().desc("Путь к файлу назначения").build());
        options.addOption(Option.builder("h").longOpt("help").desc("Помощь").build());

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd;

        try {
            cmd = parser.parse(options, args);

            if (cmd.hasOption("help")) {
                printHelp(options);
                return;
            }

            val sourceFilePath = Optional.ofNullable(cmd.getOptionValue("source"))
                    .orElseGet(() -> readFromStdin("Введите данные для конвертации: "));

            val destinationFilePath = Optional.ofNullable(cmd.getOptionValue("destination"))
                    .orElseGet(() -> readFromStdin("Введите путь для сохранения результата: "));

            log.info("Данные о файлах считаны!");

            val converter = ConvertingSelector.choiseConverter(sourceFilePath, destinationFilePath);
            converter.convert(new FileInputStream(sourceFilePath), new FileOutputStream(destinationFilePath));

            log.info("Конвертация файла " + sourceFilePath + " в файл " + destinationFilePath + " выполнена успешно");
            log.info("Конвертация файла {} в файл {} выполнена успешно", sourceFilePath, destinationFilePath);
        } catch (ParseException exeption) {
            log.error("Ошибка при разборе аргументов командной строки: {}", exeption.getMessage());
        }
    }
    private static String readFromStdin(final String prompt) {
        log.info(prompt);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static void printHelp(final Options options) {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("utility-name", options);
    }
}
