package utils;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomDataGenerator {

public static String generateName(){

    int length = 10;
    boolean useLetters = true;
    boolean useNumbers = false;
    String generateCustomerName = RandomStringUtils.random(length, useLetters, useNumbers);

    return generateCustomerName;

}
//11th homework
    public static String generatePhone(){

        int length = 8;
        boolean useLetters = false;
        boolean useNumbers = true;
        String generateCustomerPhone = RandomStringUtils.random(length, useLetters, useNumbers);

        return generateCustomerPhone;

    }

    public static String generateComment(){

        int length = 15;
        boolean useLetters = true;
        boolean useNumbers = true;
        String generateCustomerComment = RandomStringUtils.random(length, useLetters, useNumbers);

        return generateCustomerComment;

    }
}
