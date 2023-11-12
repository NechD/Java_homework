package ru.nechman.MySecondTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import ru.nechman.MySecondTestAppSpringBoot.exception.UnsupportedCodeException;
import ru.nechman.MySecondTestAppSpringBoot.model.Positions;

@Service
public interface AnnualBonusService {
    double calculate(Positions positions, double salary, double bonus, int workDays);
    double calculateBonusByQuarters(Positions positions, double salary, double bonus) throws UnsupportedCodeException;
}
