package com.company.project.web;

import com.company.project.core.common.Result;
import com.company.project.domain.dto.OrderDetailDto;
import com.company.project.domain.model.TOrder;
import com.company.project.service.TOrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 *
* @ClassName: TOrderController
* @Description: TODO
* @author duanzhiwei
* @date 2018年12月20日 PM 05点34分24秒
*
 */
@RestController
@RequestMapping("/t/order")
public class TOrderController {
    @Resource
    private TOrderService tOrderService;

    /**  
    * 自动生成的新增方法
    * @Title: add  
    * @param @param tOrder
    * @param @return    参数
    * @return Result<TOrder>    返回类型  
    * @throws  
    */
    @PostMapping
    public Result<TOrder> add(@RequestBody TOrder tOrder) {
        tOrderService.save(tOrder);
        return Result.ok(tOrder);
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
        tOrderService.deleteById(id);
        return Result.ok(id);
    }

    /**  
    * 自动生成的更新方法
    * @Title: update  
    * @param @param tOrder
    * @param @return    参数
    * @return Result<TOrder>    返回类型  
    * @throws  
    */
    @PutMapping
    public Result<TOrder> update(@RequestBody TOrder tOrder) {
        tOrderService.update(tOrder);
        return Result.ok(tOrder);
    }

    /**  
    * 自动生成的查询明细方法
    * @Title: detail  
    * @param @param id
    * @param @return    参数
    * @return Result<TOrder>    返回类型  
    * @throws  
    */
    @GetMapping("/{id}")
    public Result<TOrder> detail(@PathVariable String id) {
        TOrder tOrder = tOrderService.findById(id);
        return Result.ok(tOrder);
    }

    /**  
    * 自动生成的分页查询列表方法
    * @Title: list  
    * @param @param page
    * @param @param size
    * @param @return    参数
    * @return Result<PageInfo<TOrder>>    返回类型  
    * @throws  
    */
    @GetMapping
    public Result<PageInfo<TOrder>> list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<TOrder> list = tOrderService.findAll();
        PageInfo<TOrder> pageInfo = new PageInfo<>(list);
        return Result.ok(pageInfo);
    }

    @GetMapping(value="/orderDetail")
	public Result<List<OrderDetailDto>> findOrderDetail(@RequestParam Integer userId){
		return Result.ok(tOrderService.findOrderDetail(userId));
	}
}
