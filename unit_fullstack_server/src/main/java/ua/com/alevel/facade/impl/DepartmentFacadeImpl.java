package ua.com.alevel.facade.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.dto.request.DepartmentDtoRequest;
import ua.com.alevel.dto.response.EmployeeDtoResponse;
import ua.com.alevel.entity.Department;
import ua.com.alevel.entity.Employee;
import ua.com.alevel.facade.DepartmentFacade;
import ua.com.alevel.service.DepartmentService;
import ua.com.alevel.service.EmployeeService;

import java.util.List;

@Service
public class DepartmentFacadeImpl implements DepartmentFacade {

    private final DepartmentService departmentService;
    private final EmployeeService employeeService;

    public DepartmentFacadeImpl(DepartmentService departmentService, EmployeeService employeeService) {
        this.departmentService = departmentService;
        this.employeeService = employeeService;
    }

    @Override
    public void create(DepartmentDtoRequest dto) {
        Department department = new Department();
        department.setName(dto.getName());
        departmentService.create(department);
    }

    @Override
    public void update(DepartmentDtoRequest dto, Long id) {
        Department department = departmentService.findById(id);
        department.setName(dto.getName());
        departmentService.update(department);
    }

    @Override
    public void delete(Long id) {
        if (departmentService.existById(id)) {
            List<Employee> employees = employeeService.findAllByDepartment(departmentService.findById(id));
            employeeService.delete(employees);
            departmentService.delete(id);
        }
    }

    @Override
    public Department findById(Long id) {
        return departmentService.findById(id);
    }

    @Override
    public List<Department> findAll() {
        return departmentService.findAll();
    }
}
