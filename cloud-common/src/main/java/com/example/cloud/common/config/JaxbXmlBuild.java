package com.example.cloud.common.config;

import com.example.cloud.common.service.IXmlBuild;
import org.springframework.util.StringUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

/**
 *
 * <p>Project:  个人税收管理系统</p>
 * <p>Function:由Java Bean 生成XML文件</p>
 * <p>Description:由Java Bean 生成XML文件</p>
 * <p>Company: 税友软件集团股份有限公司</p>
 * @author Servyou
 * @version 1.0
 */
public class JaxbXmlBuild implements IXmlBuild {

    /** log */
    private final static Logger log = Logger.getLogger(JaxbXmlBuild.class);

    private static HashMap<String, JAXBContext> contextMap = new HashMap<String, JAXBContext>();

    /**
     *
     * @Title: bean2Xml
     * @Description: 从java bean 生成 XML文件
     * @param nodeObj JAXB自动生成的Java bean的根节点对应的类
     * @param encoding 编码
     * @return String
     * @throws
     */
    @Override
    @SuppressWarnings("unchecked")
    public String build(Object nodeObj, String encoding) {
        Class clazz = nodeObj.getClass();
        log.debug("clazz【" + clazz + "】");
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        log.debug("os【" + os + "】");

        try {
            JAXBContext context = getContext(clazz.getPackage().getName());
            Marshaller marshaller = context.createMarshaller();
            if(!StringUtils.isEmpty(encoding)){
                marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);
            }
            //marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(nodeObj, os);
        } catch (JAXBException e) {
            log.error("由JAVA BEAN 生成XML错误：", e);
            e.printStackTrace();
        }
        try {
            return os.toString(encoding);
        } catch (UnsupportedEncodingException e) {
            return os.toString();
        }
    }

    /**
     * @Title: getContext
     * @Description: 根据包名获取JAXB上下文
     * @param beanPack 包名
     * @return JAXBContext JAXB上下文
     * @throws JAXBException JAXB异常
     */
    protected JAXBContext getContext(String beanPack) throws JAXBException {
        JAXBContext context = contextMap.get(beanPack);
        log.debug("context【" + context + "】");
        if (context == null) {
            synchronized (JaxbXmlBuild.class) {
                if (contextMap.get(beanPack) == null) {
                    context = JAXBContext.newInstance(beanPack);
                    contextMap.put(beanPack, context);
                }
            }
            context = contextMap.get(beanPack);
        }
        return context;
    }
}
