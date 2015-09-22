package com.softteco.codesample.util.filters;

public class NumberFilter extends AbstractFilter {

    private static final String PATTERN_NUMBER = "^[0-9]*$";

    @Override
    protected String getPattern() {
        return PATTERN_NUMBER;
    }
}
