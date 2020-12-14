package com.company.project.test.service.impl;

import com.company.project.test.entity.TUser;
import com.company.project.test.mapper.TUserMapper;
import com.company.project.test.service.ITUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author duanzhiwei
 * @since 2020-12-10
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserService {

}
