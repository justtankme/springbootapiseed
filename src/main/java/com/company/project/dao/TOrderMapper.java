package com.company.project.dao;

import java.util.List;

import com.company.project.core.common.Mapper;
import com.company.project.domain.dto.OrderDetailDto;
import com.company.project.domain.model.TOrder;

public interface TOrderMapper extends Mapper<TOrder> {
	public List<OrderDetailDto> findOrderDetail(Integer userId);
}