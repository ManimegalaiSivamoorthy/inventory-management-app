package com.megala.inventorymanagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryManagementController {

    @GetMapping("say_hello/{name}/age/{age}")
    public String sayHello(@PathVariable("name") String name, @PathVariable("age") Integer age,
                           @RequestParam(value = "is_prefix_preferred", required = false) Boolean isPrefixPreferred,
                           @RequestParam(value = "prefix", required = false) String prefix) {
        if(isPrefixPreferred != null && isPrefixPreferred)
            return "Hello " + prefix + ". " + name + ". you are " + age + " years old.";
        return "Hello " + name + ". you are " + age + " years old.";
    }
}
