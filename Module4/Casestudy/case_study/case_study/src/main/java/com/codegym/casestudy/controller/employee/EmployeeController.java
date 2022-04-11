package com.codegym.casestudy.controller.employee;

import com.codegym.casestudy.model.employee.Division;
import com.codegym.casestudy.model.employee.EducationDegree;
import com.codegym.casestudy.model.employee.Employee;
import com.codegym.casestudy.model.employee.Position;
import com.codegym.casestudy.service.employee.DivisionService;
import com.codegym.casestudy.service.employee.EducationDegreeService;
import com.codegym.casestudy.service.employee.EmployeeService;
import com.codegym.casestudy.service.employee.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private PositionService positionService;

    @Autowired
    private DivisionService divisionService;

    @Autowired
    private EducationDegreeService educationDegreeService;

    @GetMapping("")
    public String showEmployeeList(@PageableDefault(size = 5) Pageable pageable, Model model){
        model.addAttribute("employee", employeeService.findAll(pageable));
        return "employee/employeeList";
    }

    @GetMapping("/create")
    public String showCreateEmployeeForm(Model model){
        List<Division> divisions = divisionService.findAll();
        List<EducationDegree> educationDegrees=educationDegreeService.findAll();
        List<Position> positions = positionService.findAll();
        model.addAttribute("division", divisions);
        model.addAttribute("educationDegree", educationDegrees);
        model.addAttribute("position", positions);
        model.addAttribute("employee", new Employee());
        return "employee/create";
    }

    @PostMapping("/save")
    public String saveEmployee(@Valid Employee employee, BindingResult bindingResult, Model model){
        if (bindingResult.hasFieldErrors()){
            List<Division> divisions = divisionService.findAll();
            List<EducationDegree> educationDegrees=educationDegreeService.findAll();
            List<Position> positions = positionService.findAll();
            model.addAttribute("division", divisions);
            model.addAttribute("educationDegree", educationDegrees);
            model.addAttribute("position", positions);
            return "employee/create";
        }else {
            employeeService.save(employee);
            return "redirect:/admin/employee/";
        }
    }

    @GetMapping("{id}/edit")
    public String showEditEmployeeForm(@PathVariable Long id,Model model){
        model.addAttribute("employee", employeeService.findById(id));
        List<Division> divisions = divisionService.findAll();
        List<EducationDegree> educationDegrees=educationDegreeService.findAll();
        List<Position> positions = positionService.findAll();
        model.addAttribute("division", divisions);
        model.addAttribute("educationDegree", educationDegrees);
        model.addAttribute("position", positions);
        model.addAttribute("employee", employeeService.findById(id));
        return "employee/create";
    }

    @PostMapping("edit")
    public String editEmployee(Employee employee){
        employeeService.save(employee);
        return "redirect:/admin/employee/";
    }

    @GetMapping("{id}/delete")
    public String showDeleteEmployeeForm(@PathVariable Long id, Model model){
        model.addAttribute("employee", employeeService.findById(id));
        return "employee/delete";
    }

    @PostMapping("delete")
    public String deleteEmployee(Long id){
        employeeService.delete(id);
        return "redirect:/admin/employee/";
    }
}
