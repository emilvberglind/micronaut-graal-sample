package com.example.api.service;

import org.apache.commons.lang3.RandomStringUtils;

import javax.inject.Singleton;

@Singleton
public class TokenGenerator {

    public String generate(int length) {
        return RandomStringUtils.randomAlphanumeric(length);
    }
}
