package com.epam.lab.election.impl;

import com.epam.lab.election.ИзбирательнаяУрна;
import com.epam.lab.election.ИзбирательныйПунктValidator;
import com.epam.lab.election.КандидатProvider;

public class ИзбирательныйПунктValidatorImpl implements ИзбирательныйПунктValidator<String, String> {

    @Override
    public boolean isГолосующийУжеГолосовал(String голосующий, ИзбирательнаяУрна<String, String> урна) {
        return урна.getПроголосовавшиеПользователи().contains(голосующий);
    }

    @Override
    public boolean isВалидныйКандидат(String кандидат, КандидатProvider<String> кандидатProvider) {
        return кандидатProvider.getКандидаты().contains(кандидат);
    }
}
