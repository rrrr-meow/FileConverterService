package service;

import lombok.experimental.UtilityClass;

import java.util.Scanner;
@UtilityClass
public class UserMenu {
    private final Scanner SCANNER = new Scanner(System.in);
    public String getInputFile(){
        while (true) {
            System.out.println("Введите путь к файлу, который необходимо считать.");
            try {
                return SCANNER.nextLine();
            } catch (IllegalArgumentException ex) {
                System.out.println("Произошла ошибка! Пожалуйста, попробуйте снова.");
            }
        }
    }

    public String getOutputFile(){
        while (true) {
            System.out.println("Введите путь к файлу, в который будут записаны преобразованные данные.");
            try {
                return SCANNER.nextLine();
            } catch (IllegalArgumentException ex) {
                System.out.println("Произошла ошибка! Пожалуйста, попробуйте снова.");
            }
        }
    }
}
