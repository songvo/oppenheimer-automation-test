package com.oppenheimer.bdd;

import com.oppenheimer.entities.WorkingClassHero;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.ParameterType;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ParameterTypes {
    @ParameterType("single|multiple")
    public String recordType(String type) {
        return type;
    }

    @DataTableType
    public List<WorkingClassHero> workingClassHeroList(DataTable dataTable) {
        List<Map<String, String>> entry = dataTable.entries();
        return entry.stream().map(x -> WorkingClassHero
                .builder()
                .natid(x.get("natid"))
                .gender(x.get("gender"))
                .name(x.get("name"))
                .birthday(x.get("birthday"))
                .salary(new BigDecimal(x.get("salary")))
                .tax(new BigDecimal(x.get("tax")))
                .build()).collect(Collectors.toList());
    }
}
