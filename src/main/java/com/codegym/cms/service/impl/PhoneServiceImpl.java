package com.codegym.cms.service.impl;

import com.codegym.cms.model.Category;
import com.codegym.cms.model.Phone;
import com.codegym.cms.repository.PhoneRepository;
import com.codegym.cms.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

public class PhoneServiceImpl implements PhoneService {

    @Autowired
    private PhoneRepository phoneRepository;
    @Override
    public Page<Phone> findAll(Pageable pageable) {
        return phoneRepository.findAll(pageable);
    }

    @Override
    public Page<Phone> findAllByNameContaining(String name, Pageable pageable) {
        return phoneRepository.findAllByNameContaining(name,pageable);
    }

    @Override
    public Phone findById(Long id) {
        return phoneRepository.findOne(id);
    }

    @Override
    public void save(Phone phone) {
        phoneRepository.save(phone);
    }

    @Override
    public void remove(Long id) {
        phoneRepository.delete(id);
    }

    @Override
    public Iterable<Phone> findAllByCategory(Category category) {
        return  phoneRepository.findAllByCategory(category);
    }
}
