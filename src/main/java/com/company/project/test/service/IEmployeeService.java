package com.company.project.test.service;

import com.company.project.test.entity.Employee;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户基础信息表 服务类
 * </p>
 *
 * @author duanzhiwei
 * @since 2020-12-14
 */
public interface IEmployeeService extends IService<Employee> {
    Boolean manAdd(Employee user);
}
