package com.example.SpringCRUD;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.SpringCRUD.Models.employeeModel;
import com.example.SpringCRUD.Repositories.employeeRepository;

/* Test con JUnit 5 */
@DataJpaTest /* Indica que los test son únicamente para componentes JPA */
@AutoConfigureTestDatabase(replace = Replace.NONE) /*  */
public class PersonaRepoTest {

    @Autowired
    private employeeRepository employeRepository;

    @Test /* Test al método 'findByName' del Repositorio */
    public void listByName() throws Exception {
        employeeModel test1 = new employeeModel(25L, "Testing 1", "Test", "1234");
        employeeModel test2 = new employeeModel(26L, "Testing 2", "Test", "56789");

        employeRepository.findByNombre(test1.toString());
        employeRepository.findByNombre(test2.toString());

        employeRepository.flush();
        assertEquals(2, employeRepository.findAll().size());
    }  
}
