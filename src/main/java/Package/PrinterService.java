package Package;

import model.EmployeeEntity;

import java.time.LocalDateTime;

public interface PrinterService {
    void printPayLisp(LocalDateTime now, EmployeeEntity employee, double tax);
}
