package ru.nechman.MySecondTestAppSpringBoot.service;
import org.junit.jupiter.api.Test;
import ru.nechman.MySecondTestAppSpringBoot.exception.UnsupportedCodeException;
import ru.nechman.MySecondTestAppSpringBoot.model.Positions;
import ru.nechman.MySecondTestAppSpringBoot.service.AnnualBonusServiceImpl;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class AnnualBonusServiceImplTest {
    @Test
    void calculate() {
        // given
        Positions position = Positions.HR;
        double bonus = 2.0;
        int workDays = 243;
        double salary = 100000.00;
        // when
        double result = new AnnualBonusServiceImpl().calculate(position, salary, bonus, workDays);
        //then
        double expected = 360493.8271604938;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void calculateBonusByQuarters() throws UnsupportedCodeException {
        // given
        Positions position = Positions.CEO;
        double bonus = 2.0;
        int workDays = 243;
        double salary = 100000.00;
        // when
        double result = new AnnualBonusServiceImpl().calculateBonusByQuarters(position, salary, bonus);
        // then
        double expected = 13000.0; // Assuming 4 quarters in a year
        assertThat(result).isEqualTo(expected);
    }
}
