package ua.com.alevel.facade;

import ua.com.alevel.dto.request.DepartmentDtoRequest;
import ua.com.alevel.entity.Department;

import java.util.List;

public interface DepartmentFacade {

    void create(DepartmentDtoRequest dto);
    void update(DepartmentDtoRequest dto,  Long id);
    void delete(Long id);
    Department findById(Long id);
    List<Department> findAll();
}
