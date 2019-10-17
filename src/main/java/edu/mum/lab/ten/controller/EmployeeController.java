package edu.mum.lab.ten.controller;

import edu.mum.lab.ten.domain.Employee;
import edu.mum.lab.ten.service.IAddressService;
import edu.mum.lab.ten.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private IAddressService addressService;

    private IEmployeeService employeeService;

    @Autowired
    public EmployeeController(IAddressService addressService, IEmployeeService employeeService){
        this.addressService = addressService;
        this.employeeService = employeeService;
    }

    @GetMapping("/view")
    public  String employeeForm(@ModelAttribute("employee") Employee employee, Model model){
        model.addAttribute("addressList", this.addressService.findAll());
        model.addAttribute("employeeList", this.employeeService.findAll());
        return "employee";
    }


    @PostMapping("/save")
    public String saveEmployee(@Valid Employee employee, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("addressList", this.addressService.findAll());
            model.addAttribute("employeeList", this.employeeService.findAll());
            return "employee";
        }
        this.employeeService.save(employee);
        return "redirect:/employee/view";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Long id){
        this.employeeService.delete(id);
        return "redirect:/employee/view";
    }

    @GetMapping("/update/{id}")
    public String updateEmployee(@PathVariable("id") Long id, Model model){
        model.addAttribute("employee", this.employeeService.findById(id));
        return "redirect:/employee/view";
    }


}
