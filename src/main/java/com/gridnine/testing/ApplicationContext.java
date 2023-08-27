package com.gridnine.testing;

import com.gridnine.testing.controller.FilterController;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.repository.FlightRepository;
import com.gridnine.testing.service.DepartureIsBeforeNowFilter;
import com.gridnine.testing.service.Filter;
import com.gridnine.testing.service.LayoverTimeFilter;
import com.gridnine.testing.service.WrongSegmentsOrderFilter;
import com.gridnine.testing.util.FlightBuilder;

import java.util.List;
import java.util.Scanner;

public class ApplicationContext {
    private Filter filter;
    private final FilterController filterController = new FilterController();
    private final FlightRepository flightRepository = new FlightRepository();
    Scanner scanner = new Scanner(System.in);

    public void run() {
        System.out.println("Выберите правило фильтрации:");
        System.out.println("1. Показать перелёты с временем вылета до текущего момента.");
        System.out.println("2. Показать перелёты имеющие сегменты с датой прилёта раньше даты вылета.");
        System.out.println("3. Показать перелёты где общее время, проведённое на земле превышает два часа.");

        while (!scanner.hasNext("404")) {
            if (scanner.hasNextInt()) {
                int userChoice = scanner.nextInt();

                filter = filterController.getFilterStrategy(userChoice);
                System.out.println(filter.apply(flightRepository.getAllFlights()));
            } else {
                System.out.println("Введите номер запроса.");
                scanner.next();
            }
        }

        System.out.println("Обработка запросов завершена");
    }
}
