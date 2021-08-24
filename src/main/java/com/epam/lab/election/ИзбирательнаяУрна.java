package com.epam.lab.election;

import java.util.List;
import java.util.Map;

public interface ИзбирательнаяУрна<T, U> {

    List<U> getПроголосовавшиеПользователи();

    Map<T, Integer> getКандидатToКоличествоГолосов();

    void добавитьГолосующего(U голосующий);

    void добавитьГолосКандидату(T кандидат);

}
