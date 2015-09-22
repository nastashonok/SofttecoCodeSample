package com.softteco.codesample.util.filters;

public class TextNumberFilter extends AbstractFilter {

    private static final String PATTERN_TEXT_NUMBER = "[a-zA-Zа-яА-Я0-9]+";

    @Override
    protected String getPattern() {
        return PATTERN_TEXT_NUMBER;
    }
}
