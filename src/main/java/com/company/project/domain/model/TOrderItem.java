package com.company.project.domain.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_order_item")
public class TOrderItem {
    @Id
    @Column(name = "order_item_id")
    private Integer orderItemId;

    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "order_content")
    private String orderContent;

    @Column(name = "user_id")
    private Integer userId;

    /**
     * @return order_item_id
     */
    public Integer getOrderItemId() {
        return orderItemId;
    }

    /**
     * @param orderItemId
     */
    public void setOrderItemId(Integer orderItemId) {
        this.orderItemId = orderItemId;
    }

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