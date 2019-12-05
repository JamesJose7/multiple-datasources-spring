package com.example.multidatasourcedemo.dao2;

import com.example.multidatasourcedemo.model_2.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Company findByName(String name);
}
