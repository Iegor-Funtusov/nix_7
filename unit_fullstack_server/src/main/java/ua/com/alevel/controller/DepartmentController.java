package ua.com.alevel.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.com.alevel.dto.request.DepartmentDtoRequest;
import ua.com.alevel.dto.response.ResponseContainer;
import ua.com.alevel.entity.Department;
import ua.com.alevel.facade.DepartmentFacade;

import java.util.List;

@Controller
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentFacade departmentFacade;

    public DepartmentController(DepartmentFacade departmentFacade) {
        this.departmentFacade = departmentFacade;
    }

    @GetMapping("/new")
    public String redirectToNewDepartment(Model model) {
        model.addAttribute("department", new DepartmentDtoRequest());
        return "/departments/departments-new";
    }

    @PostMapping
    private String create(@ModelAttribute("department") DepartmentDtoRequest dto) {
        departmentFacade.create(dto);
        return "redirect:/departments";
    }

    @GetMapping
    public String findAll(Model model) {
        List<Department> all = departmentFacade.findAll();
        model.addAttribute("departments", all);
        return "departments/departments-all";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        departmentFacade.delete(id);
        return "redirect:/departments";
    }

//    @PutMapping("/{id}")
//    private ResponseEntity<ResponseContainer<Boolean>> update(@RequestBody DepartmentDtoRequest dto, @PathVariable Long id) {
//        departmentFacade.update(dto, id);
//        return ResponseEntity.ok(new ResponseContainer<>(true));
//    }
//
//    @DeleteMapping("/{id}")
//    private ResponseEntity<ResponseContainer<Boolean>> delete(@PathVariable Long id) {
//        departmentFacade.delete(id);
//        return ResponseEntity.ok(new ResponseContainer<>(true));
//    }
//
//    @GetMapping("/{id}")
//    private ResponseEntity<ResponseContainer<Department>> findById(@PathVariable Long id) {
//        return ResponseEntity.ok(new ResponseContainer<>(departmentFacade.findById(id)));
//    }


}
