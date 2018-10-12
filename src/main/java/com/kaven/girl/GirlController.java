package com.kaven.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Kaven
 * @date 2018/10/12 17:37
 */
@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        return girlRepository.findAll();
    }

    @PostMapping(value = "/girl")
    public Girl girlAdd(@RequestParam("cupSize") String cupSize ,
                        @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }

   // 查询一个女生
    @GetMapping(value = "/girl/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id){
        System.out.println(girlRepository.findById(id).get());
        return girlRepository.findById(id).get();
    }

    //更新
    @PutMapping(value = "/girl/{id}")
    public void girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);

        girlRepository.save(girl);
    }

    //删除
    @DeleteMapping(value = "/girl/{id}")
    public void girlDelede(@PathVariable("id") Integer id){
        girlRepository.deleteById(id);
    }

    //通过年龄查询女生列表
    @GetMapping(value = "/girls/age")
    public List<Girl> girlListByAge(@RequestParam("age") Integer age){
        return  girlRepository.findByAge(age);
    }

    //事务管理
    @PostMapping(value = "/insertTwo")
    public  void girlInsertTwo(){
        girlService.insertTwo();
    }
}
