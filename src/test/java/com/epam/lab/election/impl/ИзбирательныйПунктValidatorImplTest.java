package com.epam.lab.election.impl;

import com.epam.lab.election.КандидатProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ИзбирательныйПунктValidatorImplTest {

    @InjectMocks
    private ИзбирательныйПунктValidatorImpl testObj;

    @Mock
    private КандидатProvider<String> кандидатProvider;

    @Test
    public void isГолосующийУжеГолосовал() {
        // GIVEN
        ИзбирательнаяУрнаImpl избирательнаяУрна = mock(ИзбирательнаяУрнаImpl.class);
        String user = "user";
        when(избирательнаяУрна.getПроголосовавшиеПользователи()).thenReturn(List.of(user));

        // WHEN
        boolean голосующийУжеГолосовал = testObj.isГолосующийУжеГолосовал(user, избирательнаяУрна);

        // THEN
        assertTrue(голосующийУжеГолосовал);
    }

    @Test
    public void isВалидныйКандидат() {
        // GIVEN
        String user = "user";
        when(кандидатProvider.getКандидаты()).thenReturn(List.of(user));

        // WHEN
        boolean валидныйКандидат = testObj.isВалидныйКандидат(user, кандидатProvider);

        // THEN
        assertTrue(валидныйКандидат);
    }
}