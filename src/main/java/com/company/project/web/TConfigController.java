package com.company.project.web;

import com.company.project.core.common.Result;
import com.company.project.domain.model.TConfig;
import com.company.project.service.TConfigService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 *
* @ClassName: TConfigController
* @Description: TODO
* @author duanzhiwei
* @date 2018年12月20日 PM 05点34分24秒
*
 */
@RestController
@RequestMapping("/t/config")
public class TConfigController {
    @Resource
    private TConfigService tConfigService;

    /**  
    * 自动生成的新增方法
    * @Title: add  
    * @param @param tConfig
    * @param @return    参数
    * @return Result<TConfig>    返回类型  
    * @throws  
    */
    @PostMapping
    public Result<TConfig> add(@RequestBody TConfig tConfig) {
        tConfigService.save(tConfig);
        return Result.ok(tConfig);
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
        tConfigService.deleteById(id);
        return Result.ok(id);
    }

    /**  
    * 自动生成的更新方法
    * @Title: update  
    * @param @param tConfig
    * @param @return    参数
    * @return Result<TConfig>    返回类型  
    * @throws  
    */
    @PutMapping
    public Result<TConfig> update(@RequestBody TConfig tConfig) {
        tConfigService.update(tConfig);
        return Result.ok(tConfig);
    }

    /**  
    * 自动生成的查询明细方法
    * @Title: detail  
    * @param @param id
    * @param @return    参数
    * @return Result<TConfig>    返回类型  
    * @throws  
    */
    @GetMapping("/{id}")
    public Result<TConfig> detail(@PathVariable String id) {
        TConfig tConfig = tConfigService.findById(id);
        return Result.ok(tConfig);
    }

    /**  
    * 自动生成的分页查询列表方法
    * @Title: list  
    * @param @param page
    * @param @param size
    * @param @return    参数
    * @return Result<PageInfo<TConfig>>    返回类型  
    * @throws  
    */
    @GetMapping
    public Result<PageInfo<TConfig>> list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<TConfig> list = tConfigService.findAll();
        PageInfo<TConfig> pageInfo = new PageInfo<>(list);
        return Result.ok(pageInfo);
    }
}
