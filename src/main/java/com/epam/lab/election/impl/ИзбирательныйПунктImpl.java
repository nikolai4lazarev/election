package com.epam.lab.election.impl;

import com.epam.lab.election.ИзбирательнаяУрна;
import com.epam.lab.election.ИзбирательныйПункт;
import com.epam.lab.election.КандидатProvider;

import javax.naming.OperationNotSupportedException;

public class ИзбирательныйПунктImpl implements ИзбирательныйПункт<String, String> {

    private КандидатProvider<String> кандидатProvider;
    private ИзбирательнаяУрна<String, String> избирательнаяУрна;

    public ИзбирательныйПунктImpl(КандидатProvider<String> кандидатProvider, ИзбирательнаяУрна<String, String> избирательнаяУрна) {
        this.кандидатProvider = кандидатProvider;
        this.избирательнаяУрна = избирательнаяУрна;
    }

    @Override
    public void голосоватьЗаКандидата(String кандидат, String голосующий) throws OperationNotSupportedException {
        if (!кандидатProvider.getКандидаты().contains(кандидат)) {
            throw new OperationNotSupportedException("Message");
        }
        if (избирательнаяУрна.getПроголосовавшиеПользователи().contains(голосующий)) {
            throw new OperationNotSupportedException("Message2");
        }
        избирательнаяУрна.добавитьГолосКандидату(кандидат);
        избирательнаяУрна.добавитьГолосующего(голосующий);
    }
}
