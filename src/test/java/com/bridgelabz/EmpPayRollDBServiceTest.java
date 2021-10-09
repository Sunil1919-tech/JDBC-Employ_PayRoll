package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class EmpPayRollDBServiceTest {
    @Test
    public void givenEmployeePayrollInDB_WhenRetrieved_ShouldMatchEmployeeCount() {
        EmpPayRollDBService empPayRollDBService = new EmpPayRollDBService();
        List<EmpPayRollData> employeePayrollDataList = empPayRollDBService.readData();
        Assertions.assertEquals(5, employeePayrollDataList.size());
    }
}

