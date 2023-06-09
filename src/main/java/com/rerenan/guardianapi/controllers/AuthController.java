package com.rerenan.guardianapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rerenan.guardianapi.dto.PersonDTO;
import com.rerenan.guardianapi.model.Person;
import com.rerenan.guardianapi.services.AuthService;

@RestController
@RequestMapping("/api/auth")

public class AuthController {

    @Autowired
    private AuthService service;

    @PostMapping("/sign-up")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Person create(@RequestBody PersonDTO req) {
        return service.create(new Person(req));
    }

    @PostMapping("/sign-in")
    @ResponseStatus(code = HttpStatus.OK)
    public Person login(@RequestBody PersonDTO req) {
        return new Person(req);
    }
}
