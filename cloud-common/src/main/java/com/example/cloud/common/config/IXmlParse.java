package com.example.cloud.common.config;

import com.example.cloud.common.VO.XmlVO;

import javax.xml.bind.JAXBException;

/**
 * <p>Project:  个人税收管理系统</p>
 * <p>Function:功能简述</p>
 * <p>Description:尽量详细描述功能实现内容</p>
 * <p>Company: 税友软件集团股份有限公司</p>
 * @author Servyou
 * @version 1.0
 */
public interface IXmlParse {

    /**
     * @Title: doParse
     * @Description:        XML解析
     * @param xml           xml字节流
     * @param clazz      bean对象
     * @return XmlVo
     * @throws JAXBException
     */
    @SuppressWarnings("unchecked")
    public XmlVO doParse(byte[] xml, Class clazz, String encoding);
}

