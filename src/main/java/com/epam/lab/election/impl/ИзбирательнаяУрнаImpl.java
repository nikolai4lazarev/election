package com.epam.lab.election.impl;

import com.epam.lab.election.ИзбирательнаяУрна;
import com.epam.lab.election.КандидатProvider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ИзбирательнаяУрнаImpl implements ИзбирательнаяУрна<String, String> {

    private Map<String, Integer> кандидатToКоличествоГолосов;
    private List<String> проголосовавшиеПользователи;

    public ИзбирательнаяУрнаImpl(КандидатProvider<String> кандидатProvider) {
        кандидатToКоличествоГолосов = new HashMap<>();
        кандидатProvider.getКандидаты().forEach(кандидат -> {
            кандидатToКоличествоГолосов.put(кандидат, 0);
        });
        проголосовавшиеПользователи = new ArrayList<>();
    }

    public Map<String, Integer> getКандидатToКоличествоГолосов() {
        return кандидатToКоличествоГолосов;
    }

    @Override
    public void добавитьГолосующего(String голосующий) {
        проголосовавшиеПользователи.add(голосующий);
    }

    @Override
    public void добавитьГолосКандидату(String кандидат) {
        if (кандидатToКоличествоГолосов.containsKey(кандидат)) {
            Integer количествоГолосов = кандидатToКоличествоГолосов.get(кандидат);
            кандидатToКоличествоГолосов.put(кандидат, количествоГолосов + 1);
        }
    }

    public void setКандидатToКоличествоГолосов(Map<String, Integer> кандидатToКоличествоГолосов) {
        this.кандидатToКоличествоГолосов = кандидатToКоличествоГолосов;
    }

    public List<String> getПроголосовавшиеПользователи() {
        return проголосовавшиеПользователи;
    }

    public void setПроголосовавшиеПользователи(List<String> проголосовавшиеПользователи) {
        this.проголосовавшиеПользователи = проголосовавшиеПользователи;
    }
}
