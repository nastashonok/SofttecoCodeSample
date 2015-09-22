package com.softteco.codesample.util.filters;

public class TextFilter extends AbstractFilter {

    private static final String PATTERN_TEXT = "[a-zA-Zа-яА-Я]+";

    @Override
    protected String getPattern() {
        return PATTERN_TEXT;
    }
}
