package com.fbi.xfiles.controller.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fbi.xfiles.domain.Department;
import com.fbi.xfiles.services.DepartmentService;

@RestController
@RequestMapping("/api/departments")
public class DepartmentRestController {
    
    @Autowired
    DepartmentService service;

    /**
     * List all departments
     * @return
     */
    @GetMapping("/")
    public ResponseEntity<List<Department>> index(@RequestParam(required = false) String name) {
      try {
        List<Department> departments = new ArrayList<Department>();
        if (name == null)
            departments = service.findAll();
        else
            departments = service.findByName(name);
  
        if (departments.isEmpty()) {
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
  
        return new ResponseEntity<>(departments, HttpStatus.OK);
      } catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }

    /**
     * 
     */
    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable("id") Integer id) {
      Optional<Department> data = service.findById(id);
  
      if (data.isPresent()) {
        return new ResponseEntity<>(data.get(), HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    }
    
    /**
     * 
     */
    @PostMapping("/")
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        try {
            Department _department = service.save(new Department(department.getName(), department.getCreationDate(), department.getEmail(), department.getActive()));
        return new ResponseEntity<>(_department, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 
     * @param id
     * @param tutorial
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<Department> update(@RequestBody Department department) {   
      Optional<Department> data = service.findById(department.getId());
      if (data.isPresent()) {
        return new ResponseEntity<>(service.save(department), HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    }

    /**
     * 
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteDepartment(@PathVariable("id") Integer id) {
        try {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/")
    public ResponseEntity<HttpStatus> deleteAllDepartments() {
      try {
        service.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
  
    }

    @GetMapping("/active")
    public ResponseEntity<List<Department>> findByActive() {
      try {
        List<Department> departments = service.findByActive(true);
  
        if (departments.isEmpty()) {
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(departments, HttpStatus.OK);
      } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }
}
