package com.auth.AuthDemo.service.validation.test;

import com.auth.AuthDemo.entity.TestKC;
import com.auth.AuthDemo.repository.TestRepository;
import com.auth.AuthDemo.service.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestNameValidation implements TestValidation {
    private static final int MIN__LENGTH = 4;
    private static final int MAX__LENGTH = 32;
    private TestRepository testRepository;

    @Autowired
    public TestNameValidation(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @Override
    public void validate(TestKC testKC) {
        checkNull(testKC);
        String name = testKC.getName();
        checkNameNotNull(name);
        isUnique(name);
        checkMaxLength(name);
        checkNameMinLength(name);
    }

    private void checkNameNotNull(String name){
        if(name == null)
            throw new ValidationException("Test should have name!");
    }

    private void isUnique(String name){
        if(testRepository.findByName(name).isPresent())
            throw new ValidationException("Test name should be unique");
    }

    private void checkNameMinLength(String name){
        if(name.length() < MIN__LENGTH)
            throw  new ValidationException("Test name should be at least " + MIN__LENGTH + " characters long.");
    }

    public void checkMaxLength(String name){
        if (name.length() > MAX__LENGTH)
            throw new ValidationException("Test name should not be longer than " + MAX__LENGTH + "characters long.");
    }
}
