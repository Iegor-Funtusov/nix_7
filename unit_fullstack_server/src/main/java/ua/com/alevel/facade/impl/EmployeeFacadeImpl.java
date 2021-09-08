package ua.com.alevel.facade.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.dto.request.EmployeeDtoRequest;
import ua.com.alevel.dto.response.EmployeeDtoResponse;
import ua.com.alevel.entity.Department;
import ua.com.alevel.entity.Employee;
import ua.com.alevel.facade.EmployeeFacade;
import ua.com.alevel.service.DepartmentService;
import ua.com.alevel.service.EmployeeService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeFacadeImpl implements EmployeeFacade {

    private final EmployeeService employeeService;
    private final DepartmentService departmentService;

    public EmployeeFacadeImpl(EmployeeService employeeService, DepartmentService departmentService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
    }

    @Override
    public void create(EmployeeDtoRequest dto, Long departmentId) {
        Employee employee = new Employee();
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setAge(dto.getAge());
        Department department = departmentService.findById(departmentId);
        employee.setDepartment(department);
        employeeService.create(employee);
    }

    @Override
    public void update(EmployeeDtoRequest dto, Long id) {
        Employee employee = employeeService.findById(id);
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setAge(dto.getAge());
        employeeService.create(employee);
    }

    @Override
    public void delete(Long id) {
        if (employeeService.existById(id)) {
            employeeService.delete(id);
        }
    }

    @Override
    public EmployeeDtoResponse findById(Long id) {
        return new EmployeeDtoResponse(employeeService.findById(id));
    }

    @Override
    public List<EmployeeDtoResponse> findAll() {
        return employeeService.findAll().stream().map(EmployeeDtoResponse::new).collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDtoResponse> findAllByDepartment(Long departmentId) {
        Department department = departmentService.findById(departmentId);
        return employeeService.findAllByDepartment(department).stream().map(EmployeeDtoResponse::new).collect(Collectors.toList());
    }
}
