package com.example.cloud.service.base.po;

import java.io.Serializable;
import java.util.Date;

/***
 *基类PO
 */
public class BasePO implements Serializable {

    //创建时间
    private Date createTime;

    //修改时间
    private Date updateTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
