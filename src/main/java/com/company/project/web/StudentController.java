package com.company.project.web;

import com.company.project.core.common.Result;
import com.company.project.domain.model.Student;
import com.company.project.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 *
* @ClassName: StudentController
* @Description: TODO
* @author duanzhiwei
* @date 2018年12月20日 AM 11点22分47秒
*
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    @Resource
    private StudentService studentService;

    /**  
    * 自动生成的新增方法
    * @Title: add  
    * @param @param student
    * @param @return    参数
    * @return Result<Student>    返回类型  
    * @throws  
    */
    @PostMapping
    public Result<Student> add(@RequestBody Student student) {
        studentService.save(student);
        return Result.ok(student);
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
        studentService.deleteById(id);
        return Result.ok(id);
    }

    /**  
    * 自动生成的更新方法
    * @Title: update  
    * @param @param student
    * @param @return    参数
    * @return Result<Student>    返回类型  
    * @throws  
    */
    @PutMapping
    public Result<Student> update(@RequestBody Student student) {
        studentService.update(student);
        return Result.ok(student);
    }

    /**  
    * 自动生成的查询明细方法
    * @Title: detail  
    * @param @param id
    * @param @return    参数
    * @return Result<Student>    返回类型  
    * @throws  
    */
    @GetMapping("/{id}")
    public Result<Student> detail(@PathVariable String id) {
        Student student = studentService.findById(id);
        return Result.ok(student);
    }

    /**  
    * 自动生成的分页查询列表方法
    * @Title: list  
    * @param @param page
    * @param @param size
    * @param @return    参数
    * @return Result<PageInfo<Student>>    返回类型  
    * @throws  
    */
    @GetMapping
    public Result<PageInfo<Student>> list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Student> list = studentService.findAll();
        PageInfo<Student> pageInfo = new PageInfo<>(list);
        return Result.ok(pageInfo);
    }
}
