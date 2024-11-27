package org.telran.shop.de.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.telran.shop.de.entity.DiscountCard;
import org.telran.shop.de.service.DiscountCardService;

import java.util.List;

//HTTP

//GET -  получение данных от сервиса
//POST - передача данных на сервис
//PUT  - обновление данных на сервисе
//DELETE - удаление данных на сервиса
//PATCH - обновление данных на сервисе


//http://localhost:8080/api/discountcards   GET,POST,PUT,PATCH,DELETE
//getAll - GET
//create - POST
//delete - DELETE

//CRUD - Create, Read, Update, Delete

// RULES

// getAll - GET    http://localhost:8080/api/discountcards
// create - POST   http://localhost:8080/api/discountcards
// getById- GET    http://localhost:8080/api/discountcards/5674
// delete - DELETE http://localhost:8080/api/discountcards/5674
// update - PUT    http://localhost:8080/api/discountcards/5657

// http://localhost:8080/api/discountcards/deleteCard/6567 !!!! Incorrect
// http://localhost:8080/api/discountcards/create !!!! Incorrect

// expire  http://localhost:8080/api/discountcards/expire/4356

@RestController   // @Controller + @ResponseBody
@RequestMapping("/api/discountcards")
public class DiscountCardController {

    //getAll - list all cards
    //create - create new card
    //delete - delete exists card

    //3 way to send info to backend
    //1 PathVariable - данные как часть адресной строки
    //2 RequestBody  - данные в теле запроса
    //3 RequestParam - данные как параметры адресной строки

    @Autowired
    private DiscountCardService cardService;
//
//    @Autowired
//    private DataBaseManager dataBaseManager;


    //GET http://localhost:8080/api/discountcards
    @GetMapping  // DispatcherServlet - в этот метод передаст GET запрос
    // по адресу этого контроллера
    @PreAuthorize("hasRole('ADMIN')")  // when role start with ROLE_
    //@PreAuthorize("hasAuthority('ADMIN')") // when role without ROLE_
    public List<DiscountCard> getAll() {
        //Connection connection = dataBaseManager.getConnection();
        return cardService.getAll();
    }

    // @RequestBody -- параметр из тела запроса
    @PostMapping
    public DiscountCard create(@RequestBody DiscountCard card) {
        return cardService.create(card);
    }

    //http://localhost:8080/api/discountcards/5674
    //Параметры адресной строки доступны всем!!! Не нужно передавать логины и пароли тут
    //@PathVariable - взятие параметра из адресной строки
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    //@PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public DiscountCard getById(@PathVariable(name = "id") String id) {
        return cardService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") String cardId) {
        cardService.deleteById(cardId);
    }

    @PostMapping("/expired/{id}")
    public void setExpired(@PathVariable String id) {
        cardService.setExpired(id);
    }

    //http://localhost:8080/api/discountcards/filter?expired=true
    @GetMapping("/filter")
    public List<DiscountCard> getAllByState(@RequestParam(name = "expired") boolean expired) {
        return cardService.filter(expired);
    }
}
