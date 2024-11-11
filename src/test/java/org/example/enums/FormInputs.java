package org.example.enums;

public enum FormInputs {
    FIRST_NAME("John"),
    LAST_NAME("Deer"),
    USER_EMAIL("youremail@gmail.com"),
    GENDER("Male"),
    PHONE_NUMBER("0068123123"),
    DATE_OF_BIRTH("01 Jun 2000"),
    SUBJECT_MATH("Maths"),
    SUBJECT_BIOLOGY("Biology"),
    SPORTS_HOBBY_ID("hobbies-checkbox-1"),
    MUSIC_HOBBY_ID("hobbies-checkbox-3"),
    HOBBIES("Sports, Music"),
    FILE_PATH("/home/dimqacs/Java Projects/automatedTesting_I/src/test/resources/pictures/user.png"),
    ADDRESS("Stefan Cel Mare Street"),
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
