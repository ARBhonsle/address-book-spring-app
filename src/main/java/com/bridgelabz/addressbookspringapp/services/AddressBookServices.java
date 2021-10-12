package com.bridgelabz.addressbookspringapp.services;

import com.bridgelabz.addressbookspringapp.dto.AddressBookDto;
import com.bridgelabz.addressbookspringapp.exception.AddressBookException;
import com.bridgelabz.addressbookspringapp.model.AddressBook;
import com.bridgelabz.addressbookspringapp.repository.AddressBookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressBookServices {

    @Autowired
    AddressBookRepository addressBookRepository;

    @Autowired
    ModelMapper modelMapper;

    public List<AddressBook> getAllAddressBook() {
        return addressBookRepository.findAll();
    }

    public AddressBook findAddressBookById(int id) throws AddressBookException {
        return addressBookRepository.findById(id).orElseThrow(() -> new AddressBookException("Cannot find Address Book by this id: " + id));
    }

    public AddressBook add(AddressBookDto addressBookDto) {
        AddressBook addressBook = new AddressBook();
        modelMapper.map(addressBookDto,addressBook);
        addressBookRepository.save(addressBook);
        return addressBook;
    }

    public AddressBook update(int id, AddressBookDto addressBookDto) throws AddressBookException {
        AddressBook addressBook = this.findAddressBookById(id);
        modelMapper.map(addressBookDto,addressBook);
        addressBookRepository.save(addressBook);
        return addressBook;
    }

    public void delete(int id) throws AddressBookException {
        AddressBook addressBook = this.findAddressBookById(id);
        addressBookRepository.delete(addressBook);
    }
}
