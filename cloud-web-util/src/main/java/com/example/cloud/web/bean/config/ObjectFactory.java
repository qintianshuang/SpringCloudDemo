package com.example.cloud.web.bean.config;
import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {
    public ObjectFactory() {
    }

    public TechnicalMessageVo createService() {
        return new TechnicalMessageVo();
    }

    public HeadType createHeadType() {
        return new HeadType();
    }

    public RtnMsg createRtnMsg() {
        return new RtnMsg();
    }

    public ParamListType createParamListType() {
        return new ParamListType();
    }
}