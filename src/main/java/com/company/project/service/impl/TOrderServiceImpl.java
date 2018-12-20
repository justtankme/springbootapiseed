package com.company.project.service.impl;

import com.company.project.dao.TOrderMapper;
import com.company.project.domain.dto.OrderDetailDto;
import com.company.project.domain.model.TOrder;
import com.company.project.service.TOrderService;
import com.company.project.core.common.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.annotation.Resource;

/**
 *
* @ClassName: TOrderServiceImpl
* @Description: TODO
* @author duanzhiwei
* @date 2018年12月20日 PM 05点34分24秒
*
 */
@Service
@Transactional(rollbackFor=RuntimeException.class)
public class TOrderServiceImpl extends AbstractService<TOrder> implements TOrderService {
    @Resource
    private TOrderMapper tOrderMapper;

	public List<OrderDetailDto> findOrderDetail(Integer userId){
		return tOrderMapper.findOrderDetail(userId);
	}
}
