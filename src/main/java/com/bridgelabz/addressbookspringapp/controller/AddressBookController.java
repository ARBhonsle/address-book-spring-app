package com.bridgelabz.addressbookspringapp.controller;

import com.bridgelabz.addressbookspringapp.dto.AddressBookDto;
import com.bridgelabz.addressbookspringapp.exception.AddressBookException;
import com.bridgelabz.addressbookspringapp.model.AddressBook;
import com.bridgelabz.addressbookspringapp.services.AddressBookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address-book")
public class AddressBookController {

    @Autowired
    AddressBookServices addressBookServices;

    @GetMapping(value = "/get-all")
    public ResponseEntity<Object> getAddressBook() {
        List<AddressBook> addressBookList = addressBookServices.getAllAddressBook();
        return new ResponseEntity<Object>(addressBookList, HttpStatus.OK);
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<Object> getAddressBookById(@PathVariable int id) throws AddressBookException {
        AddressBook addressBook = addressBookServices.findAddressBookById(id);
        return new ResponseEntity<Object>(addressBook, HttpStatus.OK);
    }

    @PostMapping(value = "/post")
    public ResponseEntity<Object> addAddressBook(@RequestBody AddressBookDto addressBookDto) {
        AddressBook addressBook = addressBookServices.add(addressBookDto);
        return new ResponseEntity<Object>(addressBook, HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Object> updateAddressBook(@PathVariable int id, @RequestBody AddressBookDto addressBookDto) throws AddressBookException {
        AddressBook addressBook = addressBookServices.update(id,addressBookDto);
        return new ResponseEntity<Object>(addressBook, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Object> deleteAddressBook(@PathVariable int id) throws AddressBookException {
        addressBookServices.delete(id);
        return new ResponseEntity<Object>("DELETE: Address book with id: " + id + " deleted", HttpStatus.OK);
    }
}
