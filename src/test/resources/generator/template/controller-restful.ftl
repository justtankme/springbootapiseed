package ${basePackage}.web;

import ${basePackage}.core.common.Result;
import ${basePackage}.domain.model.${modelNameUpperCamel};
import ${basePackage}.service.${modelNameUpperCamel}Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 *
* @ClassName: ${modelNameUpperCamel}Controller
* @Description: TODO
* @author ${author}
* @date ${date}
*
 */
@RestController
@RequestMapping("${baseRequestMapping}")
public class ${modelNameUpperCamel}Controller {
    @Resource
    private ${modelNameUpperCamel}Service ${modelNameLowerCamel}Service;

    /**  
    * 自动生成的新增方法
    * @Title: add  
    * @param @param ${modelNameLowerCamel}
    * @param @return    参数
    * @return Result<${modelNameUpperCamel}>    返回类型  
    * @throws  
    */
    @PostMapping
    public Result<${modelNameUpperCamel}> add(@RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel}) {
        ${modelNameLowerCamel}Service.save(${modelNameLowerCamel});
        return Result.ok(${modelNameLowerCamel});
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
        ${modelNameLowerCamel}Service.deleteById(id);
        return Result.ok(id);
    }

    /**  
    * 自动生成的更新方法
    * @Title: update  
    * @param @param ${modelNameLowerCamel}
    * @param @return    参数
    * @return Result<${modelNameUpperCamel}>    返回类型  
    * @throws  
    */
    @PutMapping
    public Result<${modelNameUpperCamel}> update(@RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel}) {
        ${modelNameLowerCamel}Service.update(${modelNameLowerCamel});
        return Result.ok(${modelNameLowerCamel});
    }

    /**  
    * 自动生成的查询明细方法
    * @Title: detail  
    * @param @param id
    * @param @return    参数
    * @return Result<${modelNameUpperCamel}>    返回类型  
    * @throws  
    */
    @GetMapping("/{id}")
    public Result<${modelNameUpperCamel}> detail(@PathVariable String id) {
        ${modelNameUpperCamel} ${modelNameLowerCamel} = ${modelNameLowerCamel}Service.findById(id);
        return Result.ok(${modelNameLowerCamel});
    }

    /**  
    * 自动生成的分页查询列表方法
    * @Title: list  
    * @param @param page
    * @param @param size
    * @param @return    参数
    * @return Result<PageInfo<${modelNameUpperCamel}>>    返回类型  
    * @throws  
    */
    @GetMapping
    public Result<PageInfo<${modelNameUpperCamel}>> list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<${modelNameUpperCamel}> list = ${modelNameLowerCamel}Service.findAll();
        PageInfo<${modelNameUpperCamel}> pageInfo = new PageInfo<>(list);
        return Result.ok(pageInfo);
    }
}
