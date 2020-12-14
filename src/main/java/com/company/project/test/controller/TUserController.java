package com.company.project.test.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.company.project.core.common.Result;
import com.company.project.test.entity.TUser;
import com.company.project.test.service.ITUserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author duanzhiwei
 * @since 2020-12-10
 */
@Api
@RestController
@RequestMapping("/test/t-user")
public class TUserController {
    @Autowired
    private ITUserService userService;

    @ApiOperation(value = "分页查询用户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageIndex", value = "每页的记录数，从1开始的正整数", dataTypeClass = Integer.class, example = "10"),
            @ApiImplicitParam(name = "pageSize", value = "第几页，从0开始的正整数", dataTypeClass = Integer.class, example = "0"),
    })
    @PostMapping("list")
    public Result<Page<TUser>> list(@RequestParam(required = true) int pageIndex, @RequestParam(required = true) int pageSize){
        return Result.ok(userService.page(new Page<TUser>(pageIndex, pageSize)));
    }

    @ApiOperation(value = "新增或更新用户")
    @PostMapping
    public Result<Boolean> saveOrUpdate(@RequestBody TUser user){
        return Result.ok(userService.saveOrUpdate(user));
    }

}
