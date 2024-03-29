package ru.nechman.MySecondTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.nechman.MySecondTestAppSpringBoot.exception.UnsupportedCodeException;
import ru.nechman.MySecondTestAppSpringBoot.exception.ValidationFailedException;
import java.util.Objects;
@Service
public class RequestValidationService implements ValidationService {

    @Override
    public void isValid(BindingResult bindingResult) throws ValidationFailedException, UnsupportedCodeException {
        if (bindingResult.hasErrors()) {
            throw new
                    ValidationFailedException(Objects.requireNonNull(bindingResult.getFieldError()).toString());
        }
        if (Objects.equals(bindingResult.getFieldValue("uid"), "123")) {
            throw new UnsupportedCodeException("UnsupportedCodeException");
        }
    }
}
