package com.gridnine.testing;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.service.DepartureIsBeforeNowFilter;
import com.gridnine.testing.service.LayoverTimeFilter;
import com.gridnine.testing.service.WrongSegmentsOrderFilter;
import com.gridnine.testing.util.FlightBuilder;

import java.util.List;
import java.util.Scanner;

public class ApplicationContext {

    List<Flight> flightList = FlightBuilder.createFlights();
    Scanner scanner = new Scanner(System.in);
    public void run() {
        System.out.println("Выберите правило фильтрации:");
        System.out.println("1. Показать перелёты с временем вылета до текущего момента.");
        System.out.println("2. Показать перелёты имеющие сегменты с датой прилёта раньше даты вылета.");
        System.out.println("3. Показать перелёты где общее время, проведённое на земле превышает два часа.");

        while(!scanner.hasNext("404")) {
            if(scanner.hasNextInt()) {
                int userChoice = scanner.nextInt();
                switch(userChoice) {
                    case 1 -> System.out.println(new DepartureIsBeforeNowFilter().apply(flightList));
                    case 2 -> System.out.println(new WrongSegmentsOrderFilter().apply(flightList));
                    case 3 -> System.out.println(new LayoverTimeFilter().apply(flightList));
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
