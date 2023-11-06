package ru.nechman.MySecondTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import ru.nechman.MySecondTestAppSpringBoot.model.Request;
import ru.nechman.MySecondTestAppSpringBoot.model.Response;

@Service
public interface ModifyRequestService {
    void modify(Request request);
}