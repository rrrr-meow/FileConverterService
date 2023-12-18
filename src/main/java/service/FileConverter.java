package service;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.commons.cli.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;


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

            String sourceFilePath = Optional.ofNullable(cmd.getOptionValue("source"))
                    .orElseGet(() -> readFromStdin("Введите данные для конвертации: "));

            String destinationFilePath = Optional.ofNullable(cmd.getOptionValue("destination"))
                    .orElseGet(() -> readFromStdin("Введите путь для сохранения результата: "));

            log.info("Данные о файлах считаны!");

            val converter = ConvertingSelector.choiseConverter(sourceFilePath, destinationFilePath);
            converter.convert(new File(sourceFilePath), new File(destinationFilePath));

            System.out.println("Конвертация файла " + sourceFilePath + " в файл " + destinationFilePath + " выполнена успешно");
            log.info("Конвертация файла {} в файл {} выполнена успешно", sourceFilePath, destinationFilePath);
        } catch (ParseException e) {
            log.error("Ошибка при разборе аргументов командной строки: {}", e.getMessage());
        }
    }
    private static String readFromStdin(String prompt) {
        try {
            System.out.print(prompt);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            return reader.readLine();
        } catch (IOException e) {
            log.error("Ошибка при чтении данных из стандартного ввода: {}", e.getMessage());
            return "";
        }
    }

    private static void printHelp(Options options) {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("utility-name", options);
    }
}
