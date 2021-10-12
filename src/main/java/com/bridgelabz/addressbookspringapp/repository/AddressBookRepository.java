package com.bridgelabz.addressbookspringapp.repository;

import com.bridgelabz.addressbookspringapp.model.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressBookRepository extends JpaRepository<AddressBook, Integer> {
}
