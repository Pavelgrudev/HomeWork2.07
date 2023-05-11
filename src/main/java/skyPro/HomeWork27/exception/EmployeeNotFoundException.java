package skyPro.HomeWork27.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import skyPro.HomeWork27.model.Employee;
@ResponseStatus (code = HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException {
  public EmployeeNotFoundException(Employee employee) {
     super("Сотрудник не найден "  + employee.toString());

  }




}
