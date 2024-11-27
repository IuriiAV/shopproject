package org.telran.shop.de.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.telran.shop.de.entity.Address;
import org.telran.shop.de.service.UserService;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    @Autowired
    private UserService userService;

    @GetMapping("/current")
    public Address getByUserId() {
        Long currentUserName = userService.getCurrentUserId();

        return null;
    }
}
