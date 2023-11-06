package ru.nechman.MySecondTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.nechman.MySecondTestAppSpringBoot.exception.UnsupportedCodeException;
import ru.nechman.MySecondTestAppSpringBoot.exception.ValidationFailedException;

@Service
public interface ValidationService {
    void isValid(BindingResult bindingResult) throws
            ValidationFailedException,
            UnsupportedCodeException;
}
