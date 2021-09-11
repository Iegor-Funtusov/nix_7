package ua.com.alevel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.com.alevel.dto.request.EmployeeDtoRequest;
import ua.com.alevel.dto.response.EmployeeDtoResponse;
import ua.com.alevel.entity.Department;
import ua.com.alevel.facade.DepartmentFacade;
import ua.com.alevel.facade.EmployeeFacade;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeFacade employeeFacade;
    private final DepartmentFacade departmentFacade;

    public EmployeeController(EmployeeFacade employeeFacade, DepartmentFacade departmentFacade) {
        this.employeeFacade = employeeFacade;
        this.departmentFacade = departmentFacade;
    }

    @GetMapping
    public String findAll(Model model) {
        List<EmployeeDtoResponse> employeeDtoResponses = employeeFacade.findAll();
        model.addAttribute("employees", employeeDtoResponses);
        return "/employees/employees-all";
    }

    @GetMapping("/department/{departmentId}")
    public String findAllByDepartment(Model model, @PathVariable Long departmentId) {
        List<EmployeeDtoResponse> employeeDtoResponses = employeeFacade.findAllByDepartment(departmentId);
        model.addAttribute("employees", employeeDtoResponses);
        Department department = departmentFacade.findById(departmentId);
        model.addAttribute("department", department);
        return "/employees/employees-by-departments-all";
    }

    @GetMapping("/new")
    public String redirectToNewEmployee(Model model, @RequestParam Long departmentId) {
        model.addAttribute("employee", new EmployeeDtoRequest());
        model.addAttribute("departmentId", departmentId);
        return "/employees/employees-new";
    }

    @PostMapping("/new")
    public String createNewEmployee(@ModelAttribute("employee") EmployeeDtoRequest dto, @RequestParam Long departmentId) {
        employeeFacade.create(dto, departmentId);
        return "redirect:/employees/department/" + departmentId;
    }


//    @PostMapping()
//    private ResponseEntity<ResponseContainer<Boolean>> create(@RequestBody EmployeeDtoRequest dto, @RequestParam Long departmentId) {
//        employeeFacade.create(dto, departmentId);
//        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseContainer<>(true));
//    }
//
//    @PutMapping("/{id}")
//    private ResponseEntity<ResponseContainer<Boolean>> update(EmployeeDtoRequest dto, @PathVariable Long id) {
//        employeeFacade.update(dto, id);
//        return ResponseEntity.ok(new ResponseContainer<>(true));
//    }
//
//    @DeleteMapping("/{id}")
//    private ResponseEntity<ResponseContainer<Boolean>> delete(@PathVariable Long id) {
//        employeeFacade.delete(id);
//        return ResponseEntity.ok(new ResponseContainer<>(true));
//    }
//
//    @GetMapping("/{id}")
//    private ResponseEntity<ResponseContainer<EmployeeDtoResponse>> findById(@PathVariable Long id) {
//        return ResponseEntity.ok(new ResponseContainer<>(employeeFacade.findById(id)));
//    }
//
//    @GetMapping
//    private ResponseEntity<ResponseContainer<List<EmployeeDtoResponse>>> findAll() {
//        return ResponseEntity.ok(new ResponseContainer<>(employeeFacade.findAll()));
//    }
//
//    @GetMapping("/department")
//    private ResponseEntity<ResponseContainer<List<EmployeeDtoResponse>>> findAllByDepartment(@RequestParam Long departmentId) {
//        return ResponseEntity.ok(new ResponseContainer<>(employeeFacade.findAllByDepartment(departmentId)));
//    }
}
