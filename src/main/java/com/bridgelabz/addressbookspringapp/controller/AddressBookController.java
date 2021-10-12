package com.bridgelabz.addressbookspringapp.controller;

import com.bridgelabz.addressbookspringapp.dto.AddressBookDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address-book")
public class AddressBookController {

    @GetMapping(value = "/get-all")
    public ResponseEntity<String> getAddressBook() {
        return new ResponseEntity<String>("GET: List of AddressBook", HttpStatus.OK);
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<String> getAddressBookById(@PathVariable int id) {
        return new ResponseEntity<String>("GET: Address book by id:" + id, HttpStatus.OK);
    }

    @PostMapping(value = "/post")
    public ResponseEntity<String> addAddressBook(@RequestBody AddressBookDto addressBookDto) {
        return new ResponseEntity<String>("POST: Address book added", HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<String> updateAddressBook(@PathVariable int id, @RequestBody AddressBookDto addressBookDto) {
        return new ResponseEntity<String>("PUT: Address book updated for id: " + id, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteAddressBook(@PathVariable int id) {
        return new ResponseEntity<String>("DELETE: Address book with id: " + id + " deleted", HttpStatus.OK);
    }
}
