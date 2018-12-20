package com.company.project.service.impl;

import com.company.project.dao.TConfigMapper;
import com.company.project.domain.model.TConfig;
import com.company.project.service.TConfigService;
import com.company.project.core.common.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 *
* @ClassName: TConfigServiceImpl
* @Description: TODO
* @author duanzhiwei
* @date 2018年12月20日 PM 05点34分24秒
*
 */
@Service
@Transactional(rollbackFor=RuntimeException.class)
public class TConfigServiceImpl extends AbstractService<TConfig> implements TConfigService {
    @Resource
    private TConfigMapper tConfigMapper;

}
