package ru.nechman.MySecondTestAppSpringBoot.service;

import ru.nechman.MySecondTestAppSpringBoot.model.Request;
import ru.nechman.MySecondTestAppSpringBoot.model.Response;
import ru.nechman.MySecondTestAppSpringBoot.model.Systems;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Qualifier("ModifySystemNameRequestService")

public class ModifySystemNameRequestService
        implements ModifyRequestService {
    @Override
    public void modify(Request request){

        request.setSystemName("service 1");  // Устанавливает поле 'systemName' объекта Request в значение "service 1".

        HttpEntity<Request> httpEntity = new HttpEntity<>(request);  // Создает HTTP-сущность (обертку) с объектом Request.

        new RestTemplate().exchange("http://localhost:8084/feedback",
                HttpMethod.POST,
                httpEntity,
                new ParameterizedTypeReference<>() {
                });  // Используется для получения ответа с параметризованным типом (в данном случае, пустым).
    }

    @Override
    public void sendTime(Response response, Request request){

        // Метод sendTime выполняет установку времени системы в объект Request.

        request.setSystemTime(response.getSystemTime());  // Устанавливает поле 'systemTime' объекта Request на основе поля 'systemTime' объекта Response.
    }
}