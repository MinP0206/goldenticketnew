package com.example.goldenmovieticketnew.controllers;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/api/bills", produces = "application/json")
@Api(value = "Bill APIs")
public class BillController {
}
