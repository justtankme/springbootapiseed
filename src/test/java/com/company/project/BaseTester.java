package com.company.project;


import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.company.project.Application;

/**
 * 
* @ClassName: BaseTester  
* @Description: 单元测试继承该类即可
* @author duanzhiwei
* @date 2018年1月16日 下午12:03:27  
*
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Transactional(rollbackFor=RuntimeException.class)
@Rollback
public abstract class BaseTester {}



