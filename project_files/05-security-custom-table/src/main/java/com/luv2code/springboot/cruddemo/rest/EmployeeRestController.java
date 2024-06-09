package com.luv2code.springboot.cruddemo.rest;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    @GetMapping("/employees")
    public List<String> findAll() {
        List<String> stringList = new ArrayList<>(Arrays.asList("First element", "Second element"));
        return stringList;
    }

    @GetMapping("/employees/{employeeId}")
    public String getEmployee(@PathVariable int employeeId) {
        return employeeId + " element";
    }
}