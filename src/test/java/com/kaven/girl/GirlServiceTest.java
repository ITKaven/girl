package com.kaven.girl;

import com.kaven.girl.domain.Girl;
import com.kaven.girl.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program: girl
 * @description: 测试 GirlService
 * @author: Kaven
 * @create: 2018-10-13 20:41
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {

    @Autowired
    private GirlService girlService;

    @Test
    public void findOneTest(){
        Girl girl = girlService.findOne(2);
        Assert.assertEquals(new Integer(10 ) , girl.getAge());
    }
}
