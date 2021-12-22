package com.obuhovskaya.java.task.dto;

public enum Gender {
    MALE, FEMALE;

    public static Gender fromString(String value) {
        if (value.equals("MALE")) {
            return Gender.MALE;
        } else if (value.equals("FEMALE")) {
            return Gender.FEMALE;
        }
        return null;
    }
}




