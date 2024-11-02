package org.example.enums;

public enum FormInputs {
    FIRST_NAME("Dima"),
    LAST_NAME("Dzic"),
    USER_EMAIL("dzicdmitrii@gmail.com"),
    PHONE_NUMBER("0068303798"),
    DATE_OF_BIRTH("05 Jun 2005"),
    SUBJECT_MATH("Maths"),
    SUBJECT_BIOLOGY("Biology"),
    SPORTS_HOBBY_ID("hobbies-checkbox-1"),
    MUSIC_HOBBY_ID("hobbies-checkbox-3"),
    FILE_PATH("/home/dimqacs/JavaProjects/testing/src/test/resources/pictures/user.png"),
    ADDRESS("13 Vasile Dokuceaev Street"),
    STATE("NCR"),
    CITY("Delhi");

    private final String value;

    FormInputs(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
