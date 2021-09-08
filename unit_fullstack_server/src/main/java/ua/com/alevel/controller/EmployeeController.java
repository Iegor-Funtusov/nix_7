package ua.com.alevel.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.alevel.dto.request.EmployeeDtoRequest;
import ua.com.alevel.dto.response.EmployeeDtoResponse;
import ua.com.alevel.dto.response.ResponseContainer;
import ua.com.alevel.facade.EmployeeFacade;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeFacade employeeFacade;

    public EmployeeController(EmployeeFacade employeeFacade) {
        this.employeeFacade = employeeFacade;
    }

    @PostMapping()
    private ResponseEntity<ResponseContainer<Boolean>> create(@RequestBody EmployeeDtoRequest dto, @RequestParam Long departmentId) {
        employeeFacade.create(dto, departmentId);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseContainer<>(true));
    }

    @PutMapping("/{id}")
    private ResponseEntity<ResponseContainer<Boolean>> update(EmployeeDtoRequest dto, @PathVariable Long id) {
        employeeFacade.update(dto, id);
        return ResponseEntity.ok(new ResponseContainer<>(true));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<ResponseContainer<Boolean>> delete(@PathVariable Long id) {
        employeeFacade.delete(id);
        return ResponseEntity.ok(new ResponseContainer<>(true));
    }

    @GetMapping("/{id}")
    private ResponseEntity<ResponseContainer<EmployeeDtoResponse>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(new ResponseContainer<>(employeeFacade.findById(id)));
    }

    @GetMapping
    private ResponseEntity<ResponseContainer<List<EmployeeDtoResponse>>> findAll() {
        return ResponseEntity.ok(new ResponseContainer<>(employeeFacade.findAll()));
    }

    @GetMapping("/department")
    private ResponseEntity<ResponseContainer<List<EmployeeDtoResponse>>> findAllByDepartment(@RequestParam Long departmentId) {
        return ResponseEntity.ok(new ResponseContainer<>(employeeFacade.findAllByDepartment(departmentId)));
    }
}
