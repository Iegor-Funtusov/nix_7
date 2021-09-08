package ua.com.alevel.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.com.alevel.entity.Employee;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeDtoResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private Long departmentId;
    private String departmentName;

    public EmployeeDtoResponse(Employee employee) {
        this.id = employee.getId();
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.age = employee.getAge();
        if (employee.getDepartment() != null) {
            this.departmentId = employee.getDepartment().getId();
            this.departmentName = employee.getDepartment().getName();
        }
    }
}
