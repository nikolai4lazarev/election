package com.epam.lab.election.impl;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class КандидатProviderImplTest {

    @Test
    public void getКандидаты_долженВернутьСписокКандидатов() {
        // GIVEN
        КандидатProviderImpl кандидатProvider = new КандидатProviderImpl();
        List<String> expectedList = List.of("Ваня", "Петя", "Алена", "Маша");

        // WHEN
        List<String> кандидаты = кандидатProvider.getКандидаты();

        // THEN
        assertEquals(expectedList, кандидаты);
    }
}