package com.company.project.service.impl;

import com.company.project.dao.TUserMapper;
import com.company.project.domain.model.TUser;
import com.company.project.service.TUserService;
import com.company.project.core.common.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 *
* @ClassName: TUserServiceImpl
* @Description: TODO
* @author duanzhiwei
* @date 2018年12月28日 下午 03点07分32秒
*
 */
@Service
@Transactional(rollbackFor=RuntimeException.class)
public class TUserServiceImpl extends AbstractService<TUser> implements TUserService {
    @Resource
    private TUserMapper tUserMapper;

}
