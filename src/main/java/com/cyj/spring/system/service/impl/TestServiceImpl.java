package com.cyj.spring.system.service.impl;

import com.cyj.spring.system.model.po.Test;
import com.cyj.spring.system.dao.TestDao;
import com.cyj.spring.system.service.TestService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cyj
 * @since 2019-03-26
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestDao, Test> implements TestService {

}
