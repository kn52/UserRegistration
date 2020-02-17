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

}
