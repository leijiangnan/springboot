package com.gzdx.test.spring.springboot.service.impl;

import com.gzdx.test.spring.springboot.service.UnitTestService;
import org.springframework.stereotype.Service;

@Service
public class UnitTestServiceImpl implements UnitTestService {

    /**
     * 为了测试，这里直接返回传入的值
     */
    @Override
    public String process(String msg) {
        // TODO Auto-generated method stub
        return msg;
    }
}
