package ua.com.alevel.facade;

import ua.com.alevel.dto.request.EmployeeDtoRequest;
import ua.com.alevel.dto.response.EmployeeDtoResponse;

import java.util.List;

public interface EmployeeFacade {

    void create(EmployeeDtoRequest dto, Long departmentId);
    void update(EmployeeDtoRequest dto, Long id);
    void delete(Long id);
    EmployeeDtoResponse findById(Long id);
    List<EmployeeDtoResponse> findAll();
    List<EmployeeDtoResponse> findAllByDepartment(Long departmentId);
}
