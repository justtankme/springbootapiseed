package com.company.project.web;

import com.company.project.core.common.Result;
import com.company.project.domain.model.TOrderItem;
import com.company.project.service.TOrderItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 *
* @ClassName: TOrderItemController
* @Description: TODO
* @author duanzhiwei
* @date 2018年12月20日 PM 05点34分24秒
*
 */
@RestController
@RequestMapping("/t/order/item")
public class TOrderItemController {
    @Resource
    private TOrderItemService tOrderItemService;

    /**  
    * 自动生成的新增方法
    * @Title: add  
    * @param @param tOrderItem
    * @param @return    参数
    * @return Result<TOrderItem>    返回类型  
    * @throws  
    */
    @PostMapping
    public Result<TOrderItem> add(@RequestBody TOrderItem tOrderItem) {
        tOrderItemService.save(tOrderItem);
        return Result.ok(tOrderItem);
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
        tOrderItemService.deleteById(id);
        return Result.ok(id);
    }

    /**  
    * 自动生成的更新方法
    * @Title: update  
    * @param @param tOrderItem
    * @param @return    参数
    * @return Result<TOrderItem>    返回类型  
    * @throws  
    */
    @PutMapping
    public Result<TOrderItem> update(@RequestBody TOrderItem tOrderItem) {
        tOrderItemService.update(tOrderItem);
        return Result.ok(tOrderItem);
    }

    /**  
    * 自动生成的查询明细方法
    * @Title: detail  
    * @param @param id
    * @param @return    参数
    * @return Result<TOrderItem>    返回类型  
    * @throws  
    */
    @GetMapping("/{id}")
    public Result<TOrderItem> detail(@PathVariable String id) {
        TOrderItem tOrderItem = tOrderItemService.findById(id);
        return Result.ok(tOrderItem);
    }

    /**  
    * 自动生成的分页查询列表方法
    * @Title: list  
    * @param @param page
    * @param @param size
    * @param @return    参数
    * @return Result<PageInfo<TOrderItem>>    返回类型  
    * @throws  
    */
    @GetMapping
    public Result<PageInfo<TOrderItem>> list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<TOrderItem> list = tOrderItemService.findAll();
        PageInfo<TOrderItem> pageInfo = new PageInfo<>(list);
        return Result.ok(pageInfo);
    }
}
