package com.company.project.test.controller;


import com.company.project.core.common.BaseController;
import com.company.project.core.common.Result;
import com.company.project.test.entity.Employee;
import com.company.project.test.service.IEmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户基础信息表 前端控制器
 * </p>
 *
 * @author duanzhiwei
 * @since 2020-12-14
 */
@RestController
@RequestMapping("/test/employee")
@Api(tags = "用户基础信息表")
public class EmployeeController extends BaseController<Employee, IEmployeeService> {


    @ApiOperation(value = "新增或更新到从库")
    @PostMapping("manAdd")
    public Result<Boolean> manAdd(@RequestBody Employee model){
        return Result.ok(service.manAdd(model));
    }
}
