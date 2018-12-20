package com.company.project.service.impl;

import com.company.project.dao.StudentMapper;
import com.company.project.domain.model.Student;
import com.company.project.service.StudentService;
import com.company.project.core.common.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 *
* @ClassName: StudentServiceImpl
* @Description: TODO
* @author duanzhiwei
* @date 2018年12月20日 AM 11点22分47秒
*
 */
@Service
@Transactional(rollbackFor=RuntimeException.class)
public class StudentServiceImpl extends AbstractService<Student> implements StudentService {
    @Resource
    private StudentMapper studentMapper;

}
