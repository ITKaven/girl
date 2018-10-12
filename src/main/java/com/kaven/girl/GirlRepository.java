package com.kaven.girl;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GirlRepository extends JpaRepository<Girl ,Integer> {

    //通过年龄来查询
    public List<Girl> findByAge(Integer age);
}
