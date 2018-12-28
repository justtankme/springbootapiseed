package com.company.project.web;

import com.company.project.core.common.Result;
import com.company.project.domain.model.TUser;
import com.company.project.service.TUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 *
* @ClassName: TUserController
* @Description: TODO
* @author duanzhiwei
* @date 2018年12月28日 下午 03点07分32秒
*
 */
@RestController
@RequestMapping("/t/user")
public class TUserController {
    @Resource
    private TUserService tUserService;

    /**  
    * 自动生成的新增方法
    * @Title: add  
    * @param @param tUser
    * @param @return    参数
    * @return Result<TUser>    返回类型  
    * @throws  
    */
    @PostMapping
    public Result<TUser> add(@RequestBody TUser tUser) {
        tUserService.save(tUser);
        return Result.ok(tUser);
    }

    /**  
    * 自动生成的删除方法
    * @Title: delete  
    * @param @param id
    * @param @return    参数
    * @return Result<Integer>    返回类型  
    * @throws  
    */
    @DeleteMapping("/{id}")
    public Result<String> delete(@PathVariable String id) {
        tUserService.deleteById(id);
        return Result.ok(id);
    }

    /**  
    * 自动生成的更新方法
    * @Title: update  
    * @param @param tUser
    * @param @return    参数
    * @return Result<TUser>    返回类型  
    * @throws  
    */
    @PutMapping
    public Result<TUser> update(@RequestBody TUser tUser) {
        tUserService.update(tUser);
        return Result.ok(tUser);
    }

    /**  
    * 自动生成的查询明细方法
    * @Title: detail  
    * @param @param id
    * @param @return    参数
    * @return Result<TUser>    返回类型  
    * @throws  
    */
    @GetMapping("/{id}")
    public Result<TUser> detail(@PathVariable String id) {
        TUser tUser = tUserService.findById(id);
        return Result.ok(tUser);
    }

    /**  
    * 自动生成的分页查询列表方法
    * @Title: list  
    * @param @param page
    * @param @param size
    * @param @return    参数
    * @return Result<PageInfo<TUser>>    返回类型  
    * @throws  
    */
    @GetMapping
    public Result<PageInfo<TUser>> list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<TUser> list = tUserService.findAll();
        PageInfo<TUser> pageInfo = new PageInfo<>(list);
        return Result.ok(pageInfo);
    }
}
