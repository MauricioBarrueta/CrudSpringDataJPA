package com.example.SpringCRUD.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringCRUD.Models.employeeModel;

public interface employeeRepository extends JpaRepository<employeeModel, Long> {

    public abstract List<employeeModel>findByNombre(String name);
}
