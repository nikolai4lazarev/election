package com.epam.lab.election.impl;

import com.epam.lab.election.ИзбирательнаяУрна;
import com.epam.lab.election.КандидатProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.naming.OperationNotSupportedException;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ИзбирательныйПунктImplTest {

    @InjectMocks
    private ИзбирательныйПунктImpl testObj;
    @Mock
    private ИзбирательнаяУрна<String, String> избирательнаяУрна;
    @Mock
    private КандидатProvider<String> кандидатProvider;

    @Test(expected = OperationNotSupportedException.class)
    public void голосоватьЗаКандидата_долженБроситьOperationNotSupportedException_когда_нетТакогоКандидата() throws OperationNotSupportedException {
        String user = "user";
        when(кандидатProvider.getКандидаты()).thenReturn(List.of(user));

        testObj.голосоватьЗаКандидата("ivan", "nick");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void голосоватьЗаКандидата_долженБроситьOperationNotSupportedException_когда_пользовательУжеГолосовал() throws OperationNotSupportedException {
        String user = "user";
        when(избирательнаяУрна.getПроголосовавшиеПользователи()).thenReturn(List.of(user));
        String кандидат = "кандидат";
        when(кандидатProvider.getКандидаты()).thenReturn(List.of(кандидат));

        testObj.голосоватьЗаКандидата(кандидат, user);

    }

    @Test
    public void голосоватьЗаКандидата_долженПроголосоватьЗаКандидата() throws OperationNotSupportedException {
        // GIVE
        String кандидат = "ivan";
        String голосующий = "голосующий";
        Map<String, Integer> голоса = Map.of(кандидат, 0);
        when(кандидатProvider.getКандидаты()).thenReturn(List.of(кандидат));
        when(избирательнаяУрна.getКандидатToКоличествоГолосов()).thenReturn(голоса);

        // WHEN
        testObj.голосоватьЗаКандидата(кандидат, голосующий);

        // THEN
        verify(избирательнаяУрна).добавитьГолосующего(голосующий);
        verify(избирательнаяУрна).добавитьГолосКандидату(кандидат);
    }
}