package com.user.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import validation.UserRegistration;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class UserRegistrationTest {

    private String email;
    private boolean emailResult;
    private UserRegistration user;

    public UserRegistrationTest(String email, boolean emailResult) {
        this.email = email;
        this.emailResult = emailResult;
    }

    @Before
    public void initialize() {
        user=new UserRegistration();
    }

    @Parameterized.Parameters
    public static Collection email(){
        return Arrays.asList( new Object[][] { {"abc@yahoo.com",true},
                {"abc-100@yahoo.com",true},
                {"abc.100@yahoo.com",true},
                {"abc111@abc.com",true},
                {"abc-100@abc.net",true},
                {"abc.100@abc.com.au",true},
                {"abc@1.com",true},
                {"abc@gmail.com.com",true},
                {"abc-gmail.com",false},
                {"abc@.com.my",false},
                {"abc123@gmail.a",false},
                {"abc123@.com",false},
                {"abc123@.com.com",false},
                {".abc@abc.com",false},
                {"abc()*@gmail.com",false},
                {"abc@%*.com",false},
                {"abc..2002@gmail.com",false},
                {"abc.@gmail.com",false},
                {"abc@abc@gmail.com",false},
                {"abc@gmail.com.1a",false},
                {"abc@gmail.com.aa.au",false}
        });
    }

    @Test
    public void givenFirstName_WhenProper_ShouldReturnTrue() {
        boolean result = user.validateFirstName("Ashish");
        Assert.assertEquals(true,result);
    }

    @Test
    public void givenFirstName_WhenNotProper_ShouldReturnFalse() {
        boolean result = user.validateFirstName("ashish");
        Assert.assertEquals(false,result);
    }
    @Test
    public void givenLastName_WhenProper_ShouldReturnTrue() {
        boolean result = user.validateLastName("Ashish");
        Assert.assertEquals(true,result);
    }

    @Test
    public void givenLastName_WhenNotProper_ShouldReturnFalse() {
        boolean result = user.validateLastName("ashish");
        Assert.assertEquals(false,result);
    }

    @Test
    public void givenEmail_WhenProper_ShouldReturnTrue() {
        Boolean result=user.validateEmail("asdasd@gmail.co.in");
        Assert.assertEquals(true,result);
    }

    @Test
    public void givenEmail_WhenNotProper_ShouldReturnFalse() {
        Boolean result=user.validateEmail("asda%sd@1.co.in");
        Assert.assertEquals(false,result);
    }

    @Test
    public void givenPhoneNumber_WhenProper_ShouldReturnTrue() {
        boolean result = user.validatePhoneNumber("91 5482704822");
        Assert.assertEquals(true,result);
    }

    @Test
    public void givenPhoneNumber_WhenNotProper_ShouldReturnFalse() {
        boolean result = user.validatePhoneNumber("91384804228");
        Assert.assertEquals(false,result);
    }

    @Test
    public void givenLengthOfPassword_WhenProper_ShouldReturnTrue() {
        boolean result = user.validatePassword("Khaeetryuu", "^.*(?=.{8,}).*$");
        Assert.assertEquals(true,result);
    }

    @Test
    public void givenLengthOfPassword_WhenNotProper_ShouldReturnFalse() {
        boolean result = user.validatePassword("asfgs","^.*(?=.{8,}).*$");
        Assert.assertEquals(false,result);
    }

    @Test
    public void givenPasswordAtLeastOneUpperCase_WhenProper_ShouldReturnTrue() {
        boolean result = user.validatePassword("KadfgHHHdhe","^.*(?=.{8,})(?=.*[A-Z]).*$");
        Assert.assertEquals(true,result);
    }
    @Test
    public void givenPasswordAtLeastOneUpperCase_WhenNotProper_ShouldReturnFalse() {
        boolean result = user.validatePassword("qwertyuio","^.*(?=.{8,})(?=.*[A-Z]).*$");
        Assert.assertEquals(false,result);
    }

    @Test
    public void givenPasswordAtLeastOneNumericNumber_WhenProper_ShouldReturnTrue() {
        boolean result = user.validatePassword("KEgdREW123","^.*(?=.{8,})(?=.*[A-Z])(?=.*[0-9]).*$");
        Assert.assertEquals(true,result);
    }

    @Test
    public void givenPasswordAtLeastOneNumericNumber_WhenNotProper_ShouldReturnFalse() {
        boolean result = user.validatePassword("KEgdREWqwe","^.*(?=.{8,})(?=.*[A-Z])(?=.*[0-9]).*$");
        Assert.assertEquals(false,result);
    }

    @Test
    public void givenPasswordSpecialCharacter_WhenProper_ShouldReturnTrue() {
        boolean result = user.validatePassword("KEgdR@EW123","^((?=[^\\W\\_]*[\\W\\_][^\\W\\_]*$)(?=.*[A-Z])(?=.*[\\d])[A-Za-z\\d\\W\\_]{8,})$");
        Assert.assertEquals(true,result);
    }

    @Test
    public void givenPasswordSpecialCharacter_WhenNotProper_ShouldReturnFalse() {
        boolean result = user.validatePassword("KEgdREWqwe457","^((?=[^\\W\\_]*[\\W\\_][^\\W\\_]*$)(?=.*[A-Z])(?=.*[\\d])[A-Za-z\\d\\W\\_]{8,})$");
        Assert.assertEquals(false,result);
    }

    @Test
    public void givenEmail_WhenProper_ShouldReturnTrue_OtherwiseFalse() {
        System.out.println("Expected Result:"+ emailResult);
        Assert.assertEquals(emailResult,user.validateEmail(email));
    }
}
