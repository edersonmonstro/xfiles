package com.fbi.xfiles.controller.rest;

import java.util.ArrayList;
import java.util.List;
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

import com.fbi.xfiles.domain.Agent;
import com.fbi.xfiles.services.AgentService;

@RestController
@RequestMapping("/api/agents")
public class AgentRestController {
    
    @Autowired
    AgentService service;

    /**
     * List all agents
     * @return
     */
    @GetMapping("/")
    public ResponseEntity<List<Agent>> getAll(@RequestParam(required = false) String name) {
      try {
        List<Agent> list = new ArrayList<Agent>();
        if (name == null)
            list = service.findAll();
        else
            list = service.findByName(name);
  
        if (list.isEmpty()) {
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
  
        return new ResponseEntity<>(list, HttpStatus.OK);
      } catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }

    /**
     * 
     */
    @GetMapping("/{id}")
    public ResponseEntity<Agent> getById(@PathVariable("id") Integer id) {
      Agent data = service.getOne(id);
  
      if (data.getId() != null) {
        return new ResponseEntity<>(data, HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    }
    
    /**
     * 
     */
    @PostMapping("/")
    public ResponseEntity<Agent> create(@RequestBody Agent agent) {
        try {
            Agent _object = service.save(new Agent(agent.getName(), agent.getBirthDate(), agent.getDepartment()));
        return new ResponseEntity<>(_object, HttpStatus.CREATED);
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
    public ResponseEntity<Agent> update(@RequestBody Agent agent) {   
      Agent data = service.getOne(agent.getId());
      if (data.getId() != null) {
        return new ResponseEntity<>(service.save(agent), HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    }

    /**
     * 
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Integer id) {
        try {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/")
    public ResponseEntity<HttpStatus> deleteAll() {
      try {
        service.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
  
    }

}
