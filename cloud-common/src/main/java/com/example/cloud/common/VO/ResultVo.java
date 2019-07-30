package com.example.cloud.common.VO;

import com.example.cloud.common.config.Logger;

import java.io.Serializable;
import java.util.HashMap;

public class ResultVo implements Serializable {
    private static final long serialVersionUID = -4214236501903574966L;
    private final static Logger log = Logger.getLogger(ResultVo.class);

    private String message;
    private Object value;
    private boolean success;
    private int msgCode;
    private HashMap resultMap;

    private ResultVo() {
    }

    public static ResultVo valueOfSuccess(Object value) {
        ResultVo vo = new ResultVo();
        vo.value = value;
        vo.success = true;
        return vo;
    }

    public static ResultVo valueOfSuccess() {
        return valueOfSuccess((Object)null);
    }

    public static ResultVo valueOfError(String msg, Object value) {
        return valueOfError(msg, 0, (Class)null, value);
    }

    public static ResultVo valueOfError(String msg, int msgCode, Class source, Object value) {
        if (source != null) {
            log.warn(msg);
        }

        ResultVo vo = new ResultVo();
        vo.value = value;
        vo.message = msg;
        vo.success = false;
        vo.msgCode = msgCode;
        return vo;
    }

    public static ResultVo valueOfError(String msg) {
        return valueOfError(msg, 0, (Class)null, (Object)null);
    }

    public static ResultVo valueOfError(String msg, int msgCode) {
        return valueOfError(msg, msgCode, (Class)null, (Object)null);
    }

    public String getMessage() {
        return this.message;
    }

    public ResultVo setMessage(String message) {
        this.message = message;
        return this;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public ResultVo setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public Object getValue() {
        return this.value;
    }

    public ResultVo setValue(Object value) {
        this.value = value;
        return this;
    }

    public int getMsgCode() {
        return this.msgCode;
    }

    public ResultVo setMsgCode(int msgCode) {
        this.msgCode = msgCode;
        return this;
    }

    public HashMap getResultMap() {
        return this.resultMap;
    }

    public void setResultMap(HashMap resultMap) {
        this.resultMap = resultMap;
    }
}

