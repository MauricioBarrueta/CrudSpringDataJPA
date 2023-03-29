package com.example.SpringCRUD.Controllers;

import com.example.SpringCRUD.InterfaceService.InterfaceService;
import com.example.SpringCRUD.Models.employeeModel;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/* Recibe la petición y ejecuta la lógica principal */
@Controller
@RequestMapping /* Indica en qué dirección del servidor se va a ejecutar esta clase */
public class employeeController {

    @Autowired
    private InterfaceService IService;

    @GetMapping("/employees")
    public String listar(Model model) {
        List<employeeModel> employees = IService.listAll();        
        model.addAttribute("personas", employees);           
        return "index";
    }

    @GetMapping("/employees/searchBy")
    public String filterList(Model model, @Param("name") String name) {
        model.addAttribute("name", name); 
        /* Valida si el valor del atributo es válido */
        if(name != null  && !name.equals("")) {
            List<employeeModel> filtro = IService.findByNombre(name);
            model.addAttribute("personas", filtro);
        } else { return "redirect:/employees"; }

        return "index";
    }
    
    @GetMapping("/employees/actions/newEmployee/**")
    public String agregar(Model model) {
        model.addAttribute("persona", new employeeModel());
        return "employeesForm";
    }

    @PostMapping("/save")
    public String save(@Validated employeeModel employeeModel, Model model) { 
        IService.saveData(employeeModel);
        return "redirect:/employees";
    }

    @GetMapping("/employees/actions/updateEmployee={id}")
    /* El método debe recibir como parámetro el id, es por eso que se usa la etiqueta @PathVariable */
    public String edit(@PathVariable Long id, Model model) {
        Optional<employeeModel> employee = IService.listById(id);
        model.addAttribute("persona", employee);
        return "employeesForm";
    }

    @GetMapping("/employees/actions/deleteEmployee={id}")
    public String delete(Model model, @PathVariable Long id) {
        IService.deleteData(id);
        return "redirect:/employees";
    }
}