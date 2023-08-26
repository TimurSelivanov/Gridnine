package com.gridnine.testing;

import java.util.Scanner;

public class ApplicationContext {
    Scanner scanner = new Scanner(System.in);
    public void run() {
        System.out.println("Выберите правило фильтрации:");
        System.out.println("1. Показать перелёты с временем вылета до текущего момента.");
        System.out.println("2. Показать перелёты имеющие сегменты с датой прилёта раньше даты вылета.");
        System.out.println("3. Показать перелётыб где общее время, проведённое на земле превышает два часа.");

        while(!scanner.hasNext("404")) {
            if(scanner.hasNextInt()) {
                int userChoice = scanner.nextInt();
                switch(userChoice) {
                    case 1 -> System.out.println("1");
                    case 2 -> System.out.println("2");
                    case 3 -> System.out.println("3");
                    default -> System.out.println("Введите верный номер запроса");
                }
            } else {
                System.out.println("Введите номер запроса.");
                scanner.next();
            }
        }

        System.out.println("Обработка запросов завершена");
    }
}
