package com.oppenheimer.utils;

import com.oppenheimer.configs.GenderBonus;
import com.oppenheimer.entities.WorkingClassHero;

import java.math.BigDecimal;

import static com.oppenheimer.configs.AgeVariable.*;
import static com.oppenheimer.utils.DateTimeUtils.calculateAgeWithFormat;

public class TaxReliefUtils {

    public static BigDecimal taxReliefCalculator(WorkingClassHero workingClassHero) {
        // Tax relief = ((salary - tax paid) * variable) + genderBonus;
        BigDecimal genderBonus = BigDecimal.valueOf(GenderBonus.valueOf(workingClassHero.getGender()).getBonus());
        BigDecimal variable = BigDecimal.valueOf(getTaxVariable(calculateAgeWithFormat(workingClassHero.getBirthday(), "ddMMyyyy")));
        BigDecimal salary = workingClassHero.getSalary();
        BigDecimal taxPaid = workingClassHero.getTax();
        return salary.subtract(taxPaid).multiply(variable).add(genderBonus);
    }

    public static double getTaxVariable(int age) {
        if (age <= 18)
            return AGE_AT_MOST_18.getVariable();
        else if (age <= 35)
            return AGE_AT_MOST_35.getVariable();
        else if (age <= 50)
            return AGE_AT_MOST_50.getVariable();
        else if (age <= 75)
            return AGE_AT_MOST_75.getVariable();
        else
            return AGE_AT_LEAST_76.getVariable();
    }

    public static String natIdTransfer(String nadId) {
        return null;
    }

    public static BigDecimal roundUpRule(BigDecimal inputAmount) {
        return null;
    }
}
