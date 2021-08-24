package com.epam.lab.election.impl;

import com.epam.lab.election.КандидатProvider;

import java.util.List;

public class КандидатProviderImpl implements КандидатProvider<String> {
    @Override
    public List<String> getКандидаты() {
        return List.of("Ваня", "Петя", "Алена", "Маша");
    }
}
