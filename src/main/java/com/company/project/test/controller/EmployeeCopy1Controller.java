package com.company.project.test.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import com.company.project.test.entity.EmployeeCopy1;
import com.company.project.test.service.IEmployeeCopy1Service;

import org.springframework.web.bind.annotation.RestController;
import com.company.project.core.common.BaseController;

/**
 * <p>
 * 用户基础信息表 前端控制器
 * </p>
 *
 * @author duanzhiwei
 * @since 2020-12-14
 */
@RestController
@RequestMapping("/test/employee-copy1")
public class EmployeeCopy1Controller extends BaseController<EmployeeCopy1, IEmployeeCopy1Service> {

}
