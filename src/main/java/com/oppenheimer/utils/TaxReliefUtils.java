package com.oppenheimer.utils;

import com.oppenheimer.configs.GenderBonus;
import com.oppenheimer.entities.WorkingClassHero;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.oppenheimer.configs.AgeVariable.*;
import static com.oppenheimer.utils.DateTimeUtils.calculateAgeWithFormat;

public class TaxReliefUtils {

    public static BigDecimal taxReliefCalculator(WorkingClassHero workingClassHero) {
        // Tax relief = ((salary - tax paid) * variable) + genderBonus;
        BigDecimal genderBonus = BigDecimal.valueOf(GenderBonus.valueOf(workingClassHero.getGender()).getBonus());
        BigDecimal variable = BigDecimal.valueOf(getTaxVariable(calculateAgeWithFormat(workingClassHero.getBirthday(), "ddMMyyyy")));
        BigDecimal salary = workingClassHero.getSalary();
        BigDecimal taxPaid = workingClassHero.getTax();
        BigDecimal taxRelief = salary.subtract(taxPaid).multiply(variable).add(genderBonus);

        // AC5: If the calculated tax relief amount after subjecting to normal
        //      rounding rule is more than 0.00 but less than 50.00, the final tax
        //      relief amount should be 50.00
        if (taxRelief.compareTo(BigDecimal.valueOf(50.00)) < 1 && taxRelief.compareTo(BigDecimal.valueOf(00.00)) > 0) {
            taxRelief = BigDecimal.valueOf(50.00);
        }
        return taxRelief.setScale(2,  RoundingMode.HALF_EVEN);
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

    public static String maskedNatIdFrom5thChar(String nadId) {
        if (nadId.length() >= 5) {
            return nadId.substring(0, 4) + "$".repeat(nadId.length() - 4);
        }
        return nadId;
    }
}
