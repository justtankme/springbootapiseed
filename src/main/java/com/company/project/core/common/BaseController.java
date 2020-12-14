package com.company.project.core.common;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.company.project.core.common.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

/**
 * @program: springboot-quickstart
 * @description: 基础的controller
 * @author: duanzhiwei
 * @created: 2020/12/14 12:14
 */
public class BaseController<Model, Service extends IService<Model>> {
    @Autowired
    protected Service service;

    @ApiOperation(value = "分页查询列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageIndex", value = "第几页，从0开始的正整数", dataTypeClass = Integer.class, example = "0"),
            @ApiImplicitParam(name = "pageSize", value = "每页的记录数，从1开始的正整数", dataTypeClass = Integer.class, example = "10"),
    })
    @GetMapping("list")
    public Result<IPage<Model>> list(@RequestParam(required = true) int pageIndex, @RequestParam(required = true) int pageSize){
        return Result.ok(service.page(new Page<Model>(pageIndex, pageSize)));
    }

    @ApiOperation(value = "根据ID查询详情")
    @GetMapping
    public Result<Model> detail(@RequestParam Serializable id){
        return Result.ok(service.getById(id));
    }

    @ApiOperation(value = "新增或更新")
    @PostMapping
    public Result<Boolean> saveOrUpdate(@RequestBody Model model){
        return Result.ok(service.saveOrUpdate(model));
    }

    @ApiOperation(value = "根据主键删除")
    @DeleteMapping
    public Result<Boolean> deleteById(@RequestParam Serializable id){
        return Result.ok(service.removeById(id));
    }
}