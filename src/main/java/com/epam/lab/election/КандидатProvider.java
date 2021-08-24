package com.epam.lab.election;

import java.util.List;

public interface КандидатProvider<T> {

    List<T> getКандидаты();

}
