package com.example.SpringCRUD.InterfaceService;

import java.util.List;
import java.util.Optional;

import com.example.SpringCRUD.Models.employeeModel;

/* Métodos globales que pueden ser reutilizados por otros módulos */
public interface InterfaceService {
   public List<employeeModel> listAll(); 
   public List<employeeModel> findByNombre(String name); 
   public Optional<employeeModel> listById(Long id);
   public int saveData(employeeModel p);
   public void deleteData(Long id);
}