package com.epam.lab.election;

import javax.naming.OperationNotSupportedException;

public interface ИзбирательныйПункт<T, U> {
    void голосоватьЗаКандидата(T кандидат, U голосующий) throws OperationNotSupportedException;
}
