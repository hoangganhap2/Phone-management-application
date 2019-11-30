package com.codegym.cms.repository;

import com.codegym.cms.model.Category;
import com.codegym.cms.model.Phone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PhoneRepository  extends PagingAndSortingRepository<Phone, Long> {
    Page<Phone> findAllByNameContaining(String name,  Pageable pageable);
    Iterable<Phone> findAllByCategory(Category category);

}
