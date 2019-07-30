package com.example.cloud.web.bean.vo;

import com.example.cloud.common.util.JsonUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * <p>标题: 办税应用技术平台V2.0</p>
 * <p>功能描述: </p>
 * <p>版权: 税友软件集团股份有限公司</p>
 * <p>创建时间: 2014-5-27</p>
 * <p>作者：王剑锋</p>
 * <p>修改历史记录：</p>
 * ====================================================================<br>
 * 维护单：CP151131<br>
 * 修改日期：2015-08-17<br>
 * 修改人：戴宁<br>
 * 修改内容：<br>
 *    1、新增otherParams变量。<br>
 */
public class ResultVO implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 5284712147559905272L;

    /** 结果标志 */
    private boolean success;

    /** 交易流水号*/
    private String jylsh;

    /** 提示信息 */
    private String message;

    /** 提示信息代码 */
    private String messageCode;

    /** 提示信息参数列表 */
    private ArrayList<String> paramList = new ArrayList<String>();

    /** 处理结果数据 */
    private Object data;

    /** 处理结果数量 */
    private String total;

    /** 其他参数 */
    private Map<String, Object> otherParams;

    /**
     * @Title: setSuccess
     * @Description: 设置成功结果
     * @param data 处理结果数据
     * @param total 处理结果数量total
     * @throws
     */
    public static ResultVO setSuccess(Object data, String total) {
        ResultVO vo = new ResultVO();
        vo.setSuccess(true);
        vo.setData(data);
        vo.setTotal(total);
        return vo;
    }

    /**
     * @Title: setSuccess
     * @Description: 设置成功结果
     * @param data 处理结果数据
     * @throws
     */
    public static ResultVO setSuccess(Object data) {
        ResultVO vo = new ResultVO();
        vo.setSuccess(true);
        vo.setData(data);
        return vo;
    }

    /**
     * @Title: setSuccess
     * @Description: 设置成功结果
     * @param messageCode 提示信息代码
     * @param paramList 提示信息参数
     * @throws
     */
    public static ResultVO setSuccess(String messageCode, ArrayList<String> paramList) {
        ResultVO vo = new ResultVO();
        vo.setSuccess(true);
        vo.setMessageCode(messageCode);
        vo.setParamList(paramList);
        return vo;
    }

    /**
     * @Title: setFail
     * @Description: 设置失败结果
     * @param messageCode 错误信息代码
     * @param paramList 错误信息参数
     * @throws
     */
    public static ResultVO setFail(String messageCode, ArrayList<String> paramList) {
        ResultVO vo = new ResultVO();
        vo.setSuccess(false);
        vo.setMessageCode(messageCode);
        vo.setParamList(paramList);
        return vo;
    }

    /**
     * @Title: setFail
     * @Description: 设置失败结果
     * @param messageCode 错误信息代码
     * @param param 错误信息参数
     * @throws
     */
    public static ResultVO setFail(String messageCode, String param) {
        ResultVO vo = new ResultVO();
        vo.setSuccess(false);
        vo.setMessageCode(messageCode);
        ArrayList<String> paramList = new ArrayList<String>();
        paramList.add(param);
        vo.setParamList(paramList);
        return vo;
    }

    /**
     * @Title: setFail
     * @Description: 设置失败结果
     * @param messageCode 错误信息代码
     * @param param1 错误信息参数1
     * @param param2 错误信息参数2
     * @throws
     */
    public static ResultVO setFail(String messageCode, String param1, String param2) {
        ResultVO vo = new ResultVO();
        vo.setSuccess(false);
        vo.setMessageCode(messageCode);
        ArrayList<String> paramList = new ArrayList<String>();
        paramList.add(param1);
        paramList.add(param2);
        vo.setParamList(paramList);
        return vo;
    }

    /**
     * @Title: setSuccess
     * @Description: 设置成功结果
     * @param messageCode 提示信息代码
     * @throws
     */
    public static ResultVO setSuccess(String messageCode, Object data, String total) {
        ResultVO vo = new ResultVO();
        vo.setSuccess(true);
        vo.setMessageCode(messageCode);
        vo.setData(data);
        vo.setTotal(total);
        return vo;
    }


    /**
     * @Title: setSuccess
     * @Description: 设置成功结果
     * @param messageCode 提示信息代码
     * @param @param param
     * @return ResultVO
     * @throws
     */
    public static ResultVO setSuccess(String messageCode, String param1, String param2, String param3) {
        ResultVO vo = new ResultVO();
        vo.setSuccess(true);
        ArrayList<String> paramList = new ArrayList<String>();
        paramList.add(param1);
        paramList.add(param2);
        paramList.add(param3);
        vo.setParamList(paramList);
        vo.setMessageCode(messageCode);
        return vo;
    }

    /**
     * @Title: setSuccess
     * @Description: 设置成功结果
     * @param messageCode 提示信息代码
     * @param param
     * @return ResultVO
     * @throws
     */
    public static ResultVO setSuccess(String messageCode, String param) {
        ResultVO vo = new ResultVO();
        vo.setSuccess(true);
        ArrayList<String> paramList = new ArrayList<String>();
        paramList.add(param);
        vo.setParamList(paramList);
        vo.setMessageCode(messageCode);
        return vo;
    }

    /**
     * @Title: setFail
     * @Description: 设置失败结果
     * @param messageCode 错误信息代码
     * @throws
     */
    public static ResultVO setFail(String messageCode) {
        ResultVO vo = new ResultVO();
        vo.setSuccess(false);
        vo.setMessageCode(messageCode);
        return vo;
    }

    /**
     * @Title: toJsonString
     * @Description: 将结果VO转换为json字符串
     * @throws
     */
    public String toJsonString() {
        // modified by dain 2015-08-08 使用json工具类生成json字符串
        return JsonUtil.getObjectToJsonStr(this);
    }

    /**
     * @return the total
     */
    public String getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(String total) {
        this.total = total;
    }

    /**
     * @return the success
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * @param success the success to set
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the data
     */
    public Object getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Object data) {
        this.data = data;
    }

    /**
     * @return the messageCode
     */
    public String getMessageCode() {
        return messageCode;
    }

    /**
     * @param messageCode the messageCode to set
     */
    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    /**
     * @return the paramList
     */
    public ArrayList<String> getParamList() {
        return paramList;
    }

    /**
     * @param paramList the paramList to set
     */
    public void setParamList(ArrayList<String> paramList) {
        this.paramList = paramList;
    }

    /**
     * @return the jylsh
     */
    public String getJylsh() {
        return jylsh;
    }

    /**
     * @param jylsh the jylsh to set
     */
    public void setJylsh(String jylsh) {
        this.jylsh = jylsh;
    }

    /**
     * @return the otherParams
     */
    public Map<String, Object> getOtherParams() {
        return otherParams;
    }

    /**
     * @param otherParams the otherParams to set
     */
    public void setOtherParams(Map<String, Object> otherParams) {
        this.otherParams = otherParams;
    }

    public void addOtherParam(String key, Object param) {
        if (this.otherParams == null) {
            otherParams = new HashMap<String, Object>();
        }
        otherParams.put(key, param);
    }
}

