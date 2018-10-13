package com.kaven.girl.service;

import com.kaven.girl.domain.Girl;
import com.kaven.girl.enums.ResultEnum;
import com.kaven.girl.exception.GirlException;
import com.kaven.girl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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

    public void getAge(Integer id)throws Exception{
        Girl girl = girlRepository.findById(id).get();
        Integer age = girl.getAge();
        System.out.println(age);
        if(age <= 10){
            //返回 “你还在上小学吧”
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if(age > 10 && age < 16){
            //返回 “你还在上初中吧”
            //System.out.println("你还在上初中吧");
            throw  new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
    }

    /**
     * 通过 Id 查询一个女生的信息
     * @param id
      * @return com.kaven.girl.domain.Girl
     * @author Kaven
     * @date 2018/10/13 20:39
     */
    public Girl findOne(Integer id){
        return girlRepository.findById(id).get();
    }
}
