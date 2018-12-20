package com.company.project.service.impl;

import com.company.project.dao.TOrderItemMapper;
import com.company.project.domain.model.TOrderItem;
import com.company.project.service.TOrderItemService;
import com.company.project.core.common.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 *
* @ClassName: TOrderItemServiceImpl
* @Description: TODO
* @author duanzhiwei
* @date 2018年12月20日 PM 05点34分24秒
*
 */
@Service
@Transactional(rollbackFor=RuntimeException.class)
public class TOrderItemServiceImpl extends AbstractService<TOrderItem> implements TOrderItemService {
    @Resource
    private TOrderItemMapper tOrderItemMapper;

}
