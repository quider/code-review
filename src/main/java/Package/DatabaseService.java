package Package;

import model.EmployeeEntity;

import java.util.List;

public interface DatabaseService {
    List<EmployeeEntity> getEmployees();
}
