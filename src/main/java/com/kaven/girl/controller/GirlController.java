package com.kaven.girl.controller;

import com.kaven.girl.domain.Girl;
import com.kaven.girl.domain.Result;
import com.kaven.girl.repository.GirlRepository;
import com.kaven.girl.service.GirlService;
import com.kaven.girl.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    /**
     * 添加一个女生
     * @return com.kaven.girl.domain.Girl
     * @author Kaven
     * @date 2018/10/13 11:43
     */
    @PostMapping(value = "/girl")
    public Result<Girl> girlAdd(@Valid Girl girl , BindingResult bindingResult){
        if(bindingResult.hasErrors()){

            return ResultUtil.error(1 , bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(girlRepository.save(girl));
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

    //通过 id 获取女生
    @GetMapping(value = "girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws  Exception{
        girlService.getAge(id);
    }
}
