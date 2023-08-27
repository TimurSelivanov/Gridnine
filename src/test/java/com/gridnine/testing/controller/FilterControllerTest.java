package com.gridnine.testing.controller;

import com.gridnine.testing.service.LayoverTimeFilter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilterControllerTest {

    FilterController filterController;
    @BeforeEach
    void setUp() {
        filterController = new FilterController();
    }

    @AfterEach
    void tearDown() {
        filterController = null;
    }

    @Test
    void getsInstanceOfLayoverTimeFilter() {
        Assertions.assertTrue(filterController.getFilterStrategy(3) instanceof LayoverTimeFilter);
    }
}