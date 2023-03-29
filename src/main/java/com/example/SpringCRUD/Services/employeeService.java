package com.example.SpringCRUD.Services;

import com.example.SpringCRUD.InterfaceService.InterfaceService;
import com.example.SpringCRUD.Models.employeeModel;
import com.example.SpringCRUD.Repositories.employeeRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/* Son las acciones permitidas en el sistema */
@Service
public class employeeService implements InterfaceService {

    @Autowired
    private employeeRepository employeeRepository;

    @Override
    public List<employeeModel> listAll() {        
        return (List<employeeModel>)employeeRepository.findAll(); 
    }
    
    @Override
    public List<employeeModel> findByNombre(String name) {        
        return(List<employeeModel>)employeeRepository.findByNombre(name);       
    }

    @Override
    public Optional<employeeModel> listById(Long id) {        
        return employeeRepository.findById(id);
    }

    @Override
    public int saveData(employeeModel employeeModel) {        
        employeeModel employee = employeeRepository.save(employeeModel);
        int res = !employee.equals(null) ? 1 : 0;        
        return res;
    }

    @Override
    public void deleteData(Long id) {
        employeeRepository.deleteById(id);
    }
}