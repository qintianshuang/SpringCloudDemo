package com.example.cloud.common.util;

import com.example.cloud.common.VO.XmlVO;
import com.example.cloud.common.config.IXmlParse;
import com.example.cloud.common.config.JaxbXmlBuild;
import com.example.cloud.common.config.JaxbXmlParse;
import com.example.cloud.common.config.Logger;

/**
 * <p>Project:  个人税收管理系统</p>
 * <p>Function:功能简述</p>
 * <p>Description:尽量详细描述功能实现内容</p>
 * <p>Company: 税友软件集团股份有限公司</p>
 * @author Servyou
 * @version 1.0
 */
public class XmlUtil {

    private final static Logger log = Logger.getLogger(XmlUtil.class);

    /**
     * @Title: doXmlParse
     * @Description: 根据传入凭证种类进行XML解析
     * @param xml       xml字节
     * @param xmlClass  xml对象
     * @return XmlVO
     * @throws
     */
    @SuppressWarnings("unchecked")
    public static <T> XmlVO<T> doXmlParse(byte[] xml, Class xmlClass, String... encoding) {
        IXmlParse xmlParse = new JaxbXmlParse();
        String coding = "";
        if (encoding != null && encoding.length > 0) {
            coding = encoding[0];
        }
        XmlVO<T> xmlVO = xmlParse.doParse(xml, xmlClass, coding);
        return xmlVO;
    }

    /**
     *
     * @Title: bean2Xml
     * @Description: bean转成xml文本
     * @param nodeObj bean对象
     * @param encoding 文本编码
     * @return String  xml文本
     * @throws
     */
    public static String doXmlBuild(Object nodeObj, String encoding) {
        JaxbXmlBuild xmlBuild = new JaxbXmlBuild();
        log.debug("nodeObj==【" + nodeObj + "】==encoding==【" + encoding + "】");
        return xmlBuild.build(nodeObj, encoding);
    }
}
