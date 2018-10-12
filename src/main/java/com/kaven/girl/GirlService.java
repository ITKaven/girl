package com.kaven.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Kaven
 * @date 2018/10/12 23:20
 */
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo(){
        Girl girlA = new Girl();
        girlA.setCupSize("B");
        girlA.setAge(19);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("DD");
        girlB.setAge(22);
        girlRepository.save(girlB);
    }
}
