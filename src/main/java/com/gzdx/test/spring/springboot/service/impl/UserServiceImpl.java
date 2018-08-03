package com.gzdx.test.spring.springboot.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.gzdx.test.spring.springboot.dao.UserDao;
import com.gzdx.test.spring.springboot.entity.User;
import com.gzdx.test.spring.springboot.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author oKong
 * @since 2018-07-20
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements IUserService {

}
