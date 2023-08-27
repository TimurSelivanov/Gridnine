package com.gridnine.testing.controller;

import com.gridnine.testing.service.DepartureIsBeforeNowFilter;
import com.gridnine.testing.service.Filter;
import com.gridnine.testing.service.LayoverTimeFilter;
import com.gridnine.testing.service.WrongSegmentsOrderFilter;

public class FilterController {
    public Filter getFilterStrategy(int userChoice) {
        Filter filter;
        switch(userChoice) {
            case 1 -> filter = new DepartureIsBeforeNowFilter();
            case 2 -> filter = new WrongSegmentsOrderFilter();
            case 3 -> filter = new LayoverTimeFilter();
            default -> throw new IllegalArgumentException("Введите верный номер запроса");
        }
        return filter;
    }
}
