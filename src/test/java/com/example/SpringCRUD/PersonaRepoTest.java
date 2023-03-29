package com.example.SpringCRUD;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.SpringCRUD.Models.employeeModel;
import com.example.SpringCRUD.Repositories.employeeRepository;

@DataJpaTest /* Indica que los test son únicamente para componentes JPA */
@AutoConfigureTestDatabase(replace = Replace.NONE) /*  */
public class PersonaRepoTest {

    @Autowired
    private employeeRepository employeRepository;

    @Test
    public void listByName() throws Exception {
        employeeModel ximena = new employeeModel(25L, "ximena", "alla", "1234");
        employeeModel paola = new employeeModel(26L, "paola", "aqui", "56789");

        employeRepository.findByNombre(ximena.toString());
        employeRepository.findByNombre(paola.toString());

        employeRepository.flush();
        assertEquals(2, employeRepository.findAll().size());


    }

    
    
}
