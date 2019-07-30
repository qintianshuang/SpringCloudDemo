package com.example.cloud.common.VO;

/**
 * <p>Project:  个人税收管理系统</p>
 * <p>Function:功能简述</p>
 * <p>Description:尽量详细描述功能实现内容</p>
 * <p>Company: 税友软件集团股份有限公司</p>
 * @author Servyou
 * @version 1.0
 */
public class XmlVO<T> {

    private T xmlParse;

    private boolean isSuccess;

    private String errorMessage;


    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public T getXmlParse() {
        return xmlParse;
    }

    public void setXmlParse(T xmlParse) {
        this.xmlParse = xmlParse;
    }

    /**
     * @return the errorMessage
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * @param errorMessage the errorMessage to set
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
