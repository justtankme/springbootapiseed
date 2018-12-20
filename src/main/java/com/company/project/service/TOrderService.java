package com.company.project.service;
import com.company.project.domain.dto.OrderDetailDto;
import com.company.project.domain.model.TOrder;

import java.util.List;

import com.company.project.core.common.Service;


/**
 *
* @ClassName: TOrderService
* @Description: TODO
* @author duanzhiwei
* @date 2018年12月20日 PM 05点34分24秒
*
 */
public interface TOrderService extends Service<TOrder> {

	public List<OrderDetailDto> findOrderDetail(Integer userId);
}
