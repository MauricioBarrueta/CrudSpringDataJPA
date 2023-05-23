package com.example.SpringCRUD.Services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.SpringCRUD.Models.employeeModel;
import com.example.SpringCRUD.Repositories.employeeRepository;

/* Test con Mockito */
public class employeeServiceTest {
    /* 'Mockeado': Al llamar un método desde el Service, el Repositorio devuelve el objeto del Test */
    @Mock /* Se 'Mockea' el Repositorio */
    private employeeRepository employeeRepository;
    @InjectMocks /* Y se injecta en el Service */
    private employeeService employeeService;
    private employeeModel employee;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); /* Se inicializa Mockito */
        /* Se inicializa el objeto tipo Empleado */
        employee = new employeeModel();
        employee.setId(Long.valueOf(1));
        employee.setNombre("Testing");       
    }

    @Test
    void testDeleteData() { }

    @Test
    void testFindByNombre() { }

    @Test
    void testListAll() {
        /* Al llamar al método 'findAll' del Repositorio este deberá retornar una List */
        when(employeeRepository.findAll()).thenReturn(Arrays.asList(employee)); /* (Arrays.asList) convierte a lista el objeto que recibe */
        assertNotNull(employeeService.listAll());
    }

    @Test
    void testListById() { }

    @Test
    void testSaveData() { 
        /* Al llamar 'save' debe retornar una entidad (Model) */
        when(employeeRepository.save(any(employeeModel.class))).thenReturn(employee);
        assertNotNull(employeeService.saveData(new employeeModel()));
    }
}
