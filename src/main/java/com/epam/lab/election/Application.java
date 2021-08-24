package com.epam.lab.election;

import com.epam.lab.election.impl.ИзбирательнаяУрнаImpl;
import com.epam.lab.election.impl.ИзбирательныйПунктImpl;
import com.epam.lab.election.impl.КандидатProviderImpl;

import javax.naming.OperationNotSupportedException;
import java.io.IOException;

public class Application {

    public static void main(String[] args) throws OperationNotSupportedException, IOException {
        КандидатProvider кандидатProvider = new КандидатProviderImpl();
        ИзбирательнаяУрна избирательнаяУрна = new ИзбирательнаяУрнаImpl(кандидатProvider);
        ИзбирательныйПункт избирательныйПункт = new ИзбирательныйПунктImpl(кандидатProvider, избирательнаяУрна);

        избирательныйПункт.голосоватьЗаКандидата("Маша", "Николай");

        System.out.println(избирательнаяУрна.getКандидатToКоличествоГолосов());
        System.out.println(избирательнаяУрна.getПроголосовавшиеПользователи());

    }

}

