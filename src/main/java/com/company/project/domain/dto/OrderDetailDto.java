package com.company.project.domain.dto;

import java.util.Date;

public class OrderDetailDto {
    private Integer orderId;

    private Date createTime;

    private String orderContent;

    private Integer userId;

    /**
     * @return order_id
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * @param orderId
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return order_content
     */
    public String getOrderContent() {
        return orderContent;
    }

    /**
     * @param orderContent
     */
    public void setOrderContent(String orderContent) {
        this.orderContent = orderContent;
    }

    /**
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}