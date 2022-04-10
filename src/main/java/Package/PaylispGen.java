package Package;


import model.EmployeeEntity;

import java.time.LocalDateTime;
import java.util.List;

public class PaylispGen {

    private final PrinterService printerService;
    private final DatabaseService databaseService;
    private boolean calculated;

    public PaylispGen(PrinterService printerService, DatabaseService databaseService) {
        this.printerService = printerService;
        this.databaseService = databaseService;
        calculated = false;
    }

    //calculates tax of salary
    public double calculateTax(double salary){
        double incomeTax = salary * 0.12;
        return incomeTax;
    }

    public Double generatePaylisp() {
        double salary = 0;
        List<EmployeeEntity> e = databaseService.getEmployees();
        if(e.isEmpty()) return null;

        calculated = false;
        for (EmployeeEntity employee : e) {
            //gets current time to know when payslip is generated;
            LocalDateTime now = LocalDateTime.now();
            double tax = calculateTax(employee.getSalary().doubleValue());
            printerService.printPayLisp(now, employee, tax);
            salary += employee.getSalary().doubleValue();
        }
        calculated = true;
        return salary;
    }

}
