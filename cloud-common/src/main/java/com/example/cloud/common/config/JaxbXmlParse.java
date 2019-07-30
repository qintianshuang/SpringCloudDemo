package com.example.cloud.common.config;

import com.example.cloud.common.VO.XmlVO;
import com.github.pagehelper.util.StringUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.Unmarshaller.Listener;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.ByteArrayInputStream;
import java.util.HashMap;


/**
 * <p>Project:  个人税收管理系统</p>
 * <p>Function:JAXB解析XML</p>
 * <p>Description:JAXB解析XML</p>
 * <p>Company: 税友软件集团股份有限公司</p>
 * @author Servyou
 * @version 1.0
 * ====================================================================<br>
 * 维护单：CP150322<br>
 * 修改日期：2015-03-12<br>
 * 修改人：戴宁<br>
 * 修改内容：<br>
修改getContext方法，不适用packagename作为key，改为使用class的全限定名。<br>
 **/
public class JaxbXmlParse extends Listener implements IXmlParse {

    private static HashMap<String, JAXBContext> contextMap = new HashMap<String, JAXBContext>();

    /** 日志对象 */
    private final Log log = LogFactory.getFactory().getInstance(JaxbXmlParse.class);

    @SuppressWarnings("unchecked")
    @Override
    public XmlVO doParse(byte[] xml, Class clazz, String encoding) {
        JAXBContext context;
        Object object = null;
        XmlVO xmlVO = new XmlVO<Object>();
        XMLStreamReader read = null;
        try {
            //获取JAXB上下文
            context = getContext(clazz);
            Unmarshaller um= context.createUnmarshaller();

            if (StringUtil.isEmpty(encoding)) {
                read = XMLInputFactory.newInstance().createXMLStreamReader(new ByteArrayInputStream(xml));
            } else {
                read = XMLInputFactory.newInstance().createXMLStreamReader(new ByteArrayInputStream(xml), encoding);
            }
            object =  um.unmarshal(read);
            if (object instanceof JAXBElement) {
                JAXBElement element = (JAXBElement) object;
                xmlVO.setXmlParse(element.getValue());
            } else {
                xmlVO.setXmlParse(object);
            }
            xmlVO.setSuccess(true);
        } catch (JAXBException e) {
            xmlVO.setSuccess(false);
            log.error("获取JAXB上下文异常，XML内容：" + new String(xml), e);
        } catch (XMLStreamException e) {
            xmlVO.setSuccess(false);
            log.error("解析XML异常", e);
        } catch (FactoryConfigurationError e) {
            xmlVO.setSuccess(false);
            log.error("解析工厂配置异常", e);
        }catch(Exception e){
            xmlVO.setSuccess(false);
            log.error("解析XML发生未知异常", e);
        }finally{
            if(read!=null){
                try {
                    read.close();
                } catch (XMLStreamException e) {
                    log.error("关闭XML Reader发生错误。", e);
                }
            }
        }
        return xmlVO;
    }

    /**
     * @Title: getContext
     * @Description: 根据包名获取JAXB上下文
     * @param  @param beanPack 包名
     * @return JAXBContext JAXB上下文
     * @throws JAXBException JAXB异常
     */
    protected JAXBContext getContext(Class clazz) throws JAXBException {
        // modified by dain 使用class的全限定名缓存上下文
        JAXBContext context = contextMap.get(clazz.getName());
        if (context == null) {
            synchronized (JaxbXmlParse.class) {
                if (contextMap.get(clazz.getName()) == null) {
                    context = JAXBContext.newInstance(clazz);
                    contextMap.put(clazz.getName(), context);
                }
            }
            context = contextMap.get(clazz.getName());
        }
        return context;
    }

    @Override
    public void afterUnmarshal(Object target, Object parent){

    }
}
