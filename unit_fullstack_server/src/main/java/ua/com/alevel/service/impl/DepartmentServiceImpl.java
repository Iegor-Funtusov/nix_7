package ua.com.alevel.service.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.entity.Department;
import ua.com.alevel.repository.DepartmentRepository;
import ua.com.alevel.service.DepartmentService;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public void create(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public void update(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public boolean existById(Long id) {
        return departmentRepository.existsById(id);
    }

    @Override
    public void delete(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department findById(Long id) {
        return departmentRepository.findById(id).get();
    }

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }
}
