package com.epam.lab.election;

public interface ИзбирательныйПунктValidator<T, U> {

    boolean isГолосующийУжеГолосовал(U голосующий, ИзбирательнаяУрна<T, U> урна);

    boolean isВалидныйКандидат(T кандидат, КандидатProvider<T> кандидатProvider);

}
