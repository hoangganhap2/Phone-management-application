package com.codegym.cms.service;

import com.codegym.cms.model.Category;
import com.codegym.cms.model.Phone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PhoneService {
    Page<Phone> findAll(Pageable pageable);
    Page<Phone> findAllByNameContaining(String name, Pageable pageable);
    Phone findById(Long id);
    void save(Phone phone);
    void remove(Long id);
    Iterable<Phone> findAllByCategory(Category category);
}
