package com.example.department.service;

import com.example.department.entity.Department;
import com.example.department.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {
        
    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        log.info("inside saveDepartment emthod : DepartmentService");

        return departmentRepository.save(department);
    }

    public Department getDepartmentById(Long departmentId) {
        log.info("inside getDepartmentById emthod : DepartmentService");

        return departmentRepository.findByDepartmentId(departmentId);
    }
}
