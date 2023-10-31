package ru.nechman.MySecondTestAppSpringBoot.service;


import org.springframework.stereotype.Service;
import ru.nechman.MySecondTestAppSpringBoot.model.Response;

@Service
public interface ModifyResponseService {
    Response modify(Response response);
}
