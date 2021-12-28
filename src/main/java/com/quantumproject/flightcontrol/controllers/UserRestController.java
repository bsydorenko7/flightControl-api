package com.quantumproject.flightcontrol.controllers;

import com.quantumproject.flightcontrol.services.FlyingManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

    private final FlyingManagerService flyingManagerService;

    @Autowired
    public UserRestController(FlyingManagerService flyingManagerService) {
        this.flyingManagerService = flyingManagerService;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity isAvailableTicket(@PathVariable(name = "id") long id) {
        boolean result = flyingManagerService.isAvailableTicket(id);
        return result == Boolean.TRUE
                ? new ResponseEntity(result, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
