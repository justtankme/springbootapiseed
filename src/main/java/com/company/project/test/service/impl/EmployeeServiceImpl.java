package com.company.project.test.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.company.project.test.entity.Employee;
import com.company.project.test.mapper.EmployeeMapper;
import com.company.project.test.service.IEmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户基础信息表 服务实现类
 * </p>
 *
 * @author duanzhiwei
 * @since 2020-12-14
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {
    @DS("read")
    @Override
    public Boolean manAdd(Employee user){
        //do something
        return baseMapper.insert(user) > 0;
    }
}
