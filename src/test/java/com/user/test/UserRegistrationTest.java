package com.user.test;

import org.junit.Assert;
import org.junit.Test;
import validation.UserRegistration;

public class UserRegistrationTest {
    @Test
    public void givenFirstName_WhenProper_ShouldReturnTrue() {
        UserRegistration user=new UserRegistration();
        boolean result = user.validateFirstName("Ashish");
        Assert.assertEquals(true,result);
    }

    @Test
    public void givenFirstName_WhenNotProper_ShouldReturnFalse() {
        UserRegistration user=new UserRegistration();
        boolean result = user.validateFirstName("ashish");
        Assert.assertEquals(false,result);
    }
    @Test
    public void givenLastName_WhenProper_ShouldReturnTrue() {
        UserRegistration user=new UserRegistration();
        boolean result = user.validateLastName("Ashish");
        Assert.assertEquals(true,result);
    }

    @Test
    public void givenLastName_WhenNotProper_ShouldReturnFalse() {
        UserRegistration user=new UserRegistration();
        boolean result = user.validateLastName("ashish");
        Assert.assertEquals(false,result);
    }

    @Test
    public void givenEmail_WhenProper_ShouldReturnTrue() {
        UserRegistration user = new UserRegistration();
        Boolean result=user.validateEmail("asdasd@gmail.co.in");
        Assert.assertEquals(true,result);
    }

    @Test
    public void givenEmail_WhenNotProper_ShouldReturnFalse() {
        UserRegistration user = new UserRegistration();
        Boolean result=user.validateEmail("asda%sd@1.co.in");
        Assert.assertEquals(false,result);
    }

    @Test
    public void givenPhoneNumber_WhenProper_ShouldReturnTrue() {
        UserRegistration user=new UserRegistration();
        boolean result = user.validatePhoneNumber("91 5482704822");
        Assert.assertEquals(true,result);
    }

    @Test
    public void givenPhoneNumber_WhenNotProper_ShouldReturnFalse() {
        UserRegistration user=new UserRegistration();
        boolean result = user.validatePhoneNumber("91384804228");
        Assert.assertEquals(false,result);
    }

    @Test
    public void givenLengthOfPassword_WhenProper_ShouldReturnTrue() {
        UserRegistration user=new UserRegistration();
        boolean result = user.validatePassword("Khaeetryuu", "^.*(?=.{8,}).*$");
        Assert.assertEquals(true,result);
    }

    @Test
    public void givenLengthOfPassword_WhenNotProper_ShouldReturnFalse() {
        UserRegistration user=new UserRegistration();
        boolean result = user.validatePassword("asfgs","^.*(?=.{8,}).*$");
        Assert.assertEquals(false,result);
    }

    @Test
    public void givenPasswordAtLeastOneUpperCase_WhenProper_ShouldReturnTrue() {
        UserRegistration user=new UserRegistration();
        boolean result = user.validatePassword("KadfgHHHdhe","^.*(?=.{8,})(?=.*[A-Z]).*$");
        Assert.assertEquals(true,result);
    }
    @Test
    public void givenPasswordAtLeastOneUpperCase_WhenNotProper_ShouldReturnFalse() {
        UserRegistration user=new UserRegistration();
        boolean result = user.validatePassword("qwertyuio","^.*(?=.{8,})(?=.*[A-Z]).*$");
        Assert.assertEquals(false,result);
    }

    @Test
    public void givenPasswordAtLeastOneNumericNumber_WhenProper_ShouldReturnTrue() {
        UserRegistration user=new UserRegistration();
        boolean result = user.validatePassword("KEgdREW123","^.*(?=.{8,})(?=.*[A-Z])(?=.*[0-9]).*$");
        Assert.assertEquals(true,result);
    }

    @Test
    public void givenPasswordAtLeastOneNumericNumber_WhenNotProper_ShouldReturnFalse() {
        UserRegistration user=new UserRegistration();
        boolean result = user.validatePassword("KEgdREWqwe","^.*(?=.{8,})(?=.*[A-Z])(?=.*[0-9]).*$");
        Assert.assertEquals(false,result);
    }

    @Test
    public void givenPasswordSpecialCharacter_WhenProper_ShouldReturnTrue() {
        UserRegistration user=new UserRegistration();
        boolean result = user.validatePassword("KEgdR@EW123","^.*(?=.{8,})(?=.*[A-Z])(?=.*[0-9])(?=.*[@/|#$%!]).*$");
        Assert.assertEquals(true,result);
    }

    @Test
    public void givenPasswordSpecialCharacter_WhenNotProper_ShouldReturnFalse() {
        UserRegistration user=new UserRegistration();
        boolean result = user.validatePassword("KEgdREWqwe457","^.*(?=.{8,})(?=.*[A-Z])(?=.*[0-9])(?=.*[@/|#$%!]).*$");
        Assert.assertEquals(false,result);
    }
}
