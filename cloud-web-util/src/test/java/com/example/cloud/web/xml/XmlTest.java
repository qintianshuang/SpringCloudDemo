package com.example.cloud.web.xml;

import com.example.cloud.common.VO.ResultVo;
import com.example.cloud.common.VO.XmlVO;
import com.example.cloud.common.config.Logger;
import com.example.cloud.common.io.NsrxxVO;
import com.example.cloud.common.util.DateUtils;
import com.example.cloud.common.util.XmlUtil;
import com.example.cloud.web.bean.config.HeadType;
import com.example.cloud.web.bean.config.ObjectFactory;
import com.example.cloud.web.bean.config.TechnicalMessageVo;
import com.example.cloud.web.bean.content.request.CxNsrHYCBXXreqVO;
import com.example.cloud.web.bean.content.request.HY00001Request;
import com.example.cloud.web.bean.content.response.HY00001Response;
import com.example.cloud.web.bean.vo.ResultVO;
import org.junit.Test;

public class XmlTest {

    private final static Logger log = Logger.getLogger(XmlTest.class);

    @Test
    public void javaToXmlTest(){
        NsrxxVO nsrxxVo = new NsrxxVO();
        nsrxxVo.setDjxh("10114403000026610194");
        nsrxxVo.setNsrsbh("92440300L4937628X5");
        String sssqq = "20190101";
        String sssqz = "20190331";
        log.debug("====登记序号====【" + nsrxxVo.getDjxh() +"】====已进入货运发票抄税查询");
//        String hyfpcsUrl = SystemParamClient.getSystemParam("HYFPCS_URL");
        HY00001Request hy00001Request = new HY00001Request();
        CxNsrHYCBXXreqVO cxNsrHYCBXXreqVO = new CxNsrHYCBXXreqVO();
        cxNsrHYCBXXreqVO.setNsrsbh(nsrxxVo.getNsrsbh());
        cxNsrHYCBXXreqVO.setSkssqq(sssqq);
        cxNsrHYCBXXreqVO.setSkssqz(sssqz);
        log.debug("====登记序号====【" + nsrxxVo.getDjxh()+"】====nsrxxVo.getNsrsbh()====【" + nsrxxVo.getNsrsbh() +"】====sssqq====【" + sssqq + "】====sssqz====【" + sssqz + "】");
        hy00001Request.setCxNsrHYCBXXreqVO(cxNsrHYCBXXreqVO);
        log.debug("====登记序号====【" + nsrxxVo.getDjxh()+"】====CxNsrHYCBXXreqVO====【" + cxNsrHYCBXXreqVO.toString());
        String content = XmlUtil.doXmlBuild(hy00001Request, "UTF-8");
        log.debug("====登记序号====【" + nsrxxVo.getDjxh() +"】====content====【" + content + "】");
        ResultVo resultVo = null;
        buildRequestXml(nsrxxVo.getDjxh(),content,nsrxxVo);
        /*
         * ResultVo resultVo = WebServiceAxisClient.call(hyfpcsUrl, "hqsbsj",
         * buildRequestXml(nsrxxVo.getDjxh(),content,nsrxxVo));
         * LOG.info("=================resultVo.isSuccess()===："+resultVo.isSuccess()+"==============");
         * if(!resultVo.isSuccess()){
         * returnVo.setSuccess(false);
         * returnVo.setMessage("查询货运发票抄税查询失败");
         * return returnVo;
         * }
         */
        // 进行数据解析
        ResultVo returnReturnvo = parseHycxXml(resultVo, HY00001Response.class);
        ResultVO resultVO = new ResultVO();
        if(!returnReturnvo.isSuccess()){
            resultVO.setSuccess(false);
            resultVO.setMessage(returnReturnvo.getMessage());
//            return resultVO;
        }
        HY00001Response Response =(HY00001Response)returnReturnvo.getValue();
        String bz = Response.getCxNsrHYCBXXresVO().getBz1();
        resultVO.setData(bz);
        resultVO.setSuccess(true);// 用于测试
        log.debug("====登记序号===【" + nsrxxVo.getDjxh() +"】====获取到的标志为===【" + bz + "】");
        log.info("=========已退出货运发票抄税查询===========================");
//        return resultVO;





    }

    private String buildRequestXml(String djxh,String content,NsrxxVO nsrxxVo){
//        String swjgDm = StringUtils.isNullString(nsrxxVo.getZgswskfjDm())? nsrxxVo.getZgswjDm() : nsrxxVo.getZgswskfjDm();
//        String sjry = SystemParamClient.getSystemParam("sjry");
//        String identity = SystemParamClient.getSystemParam("identity_type");
//        String channelId = SystemParamClient.getSystemParam("qdxtdm");
//        String wbjylsh = CommonUtil.createUUID();
        String swjgDm = "324523";
        String sjry = "234523";
        String identity = "67456";
        String channelId = "SZGS.NFWB.DZSWJII";
        String wbjylsh = "10cbcd00d3e14bb0b2735ec9c1be3c93";
        log.debug("====登记序号===【" + nsrxxVo.getDjxh() +"】====swjgDm===【" + swjgDm
                + "】====identity===【" + identity
                + "】====channelId===【" + channelId
                + "】====wbjylsh===【" + wbjylsh + "】");
        return getSbbw(swjgDm, sjry, "SWZJ.HYFP.SB.CXFPCBRZHZXX", wbjylsh, content, identity, channelId);
    }
    private static String getSbbw(String swjgDm, String sjryStr, String tranid, String transeq, String sbsj,
                                  String identity,
                                  String channelId) {
        ObjectFactory o = new ObjectFactory();
        TechnicalMessageVo vo = o.createService();
        HeadType head = o.createHeadType();
        head.setTranId(tranid);
        head.setTranDate(DateUtils.getNow("yyyyMMdd"));
        head.setTranTime(DateUtils.getNow("HHmmssSSS"));
        head.setChannelId(channelId);
        head.setTranSeq(transeq);
        String bodyxml = "<body><![CDATA[" + sbsj + "]]></body>";
        vo.setBody("");
        vo.setHead(head);
        String requestxml = XmlUtil.doXmlBuild(vo, "UTF-8");
        requestxml = requestxml
                .replace("<body></body>", bodyxml)
                .replace(
//                        "<taxML xmlns=\"http://www.chinatax.gov.cn/dataspec/\">",
                        "<taxML>",
                        "<taxML xsi:type=\"HY00001Request\" xmlbh=\"String\" bbh=\"SWZJ.HYFP.SB.CXFPCBRZHZXX\" xmlmc=\"获取货运系统申报数据接口\" xsi:schemaLocation=\"http://www.chinatax.gov.cn/dataspec/TaxMLBw_HY_00001_Request_V1.0.xsd\" xmlns=\"http://www.chinatax.gov.cn/dataspec/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">");
        log.debug("转换出的xml为[requestxml:" + requestxml + "]");
        return requestxml;
    }
    private ResultVo parseHycxXml(ResultVo resultVo, Class<?> response){
        XmlVO<TechnicalMessageVo> techMsgVo = null;
        XmlVO responseVo = null;
        String technicalBody;
        //String receiverMsg = resultVo.getValue().toString();service
        String receiverMsg = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><service xmlns=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><head><tran_id>SWZJ.HYFP.SB.CXFPCBRZHZXX </tran_id><channel_id>C000AYLHY</channel_id><tran_seq>10cbcd00d3e14bb0b2735ec9c1be3c93</tran_seq><tran_date>20160920</tran_date><tran_time>091046375</tran_time><rtn_code>0</rtn_code><rtn_msg><Code>000</Code><Message/><Reason/></rtn_msg></head><body><![CDATA[<?xml version=\"1.0\" encoding=\"UTF-8\"?><taxML xsi:type=\"HY00001Response\" xmlbh=\"String\" bbh=\"SWZJ.HYFP.SB.CXFPCBRZHZXX\" xmlmc=\"获取货运系统申报数据接口\"  xsi:schemaLocation=\"http://www.chinatax.gov.cn/dataspec/TaxMLBw_HY_00001_Response_V1.0.xsd\" xmlns=\"http://www.chinatax.gov.cn/dataspec/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><cxNsrHYCBXXresVO><bz1>100</bz1><an_ptfpdz_fs>47</an_ptfpdz_fs><an_ptfpdz_cbje>3141.59</an_ptfpdz_cbje><an_ptfpdz_cbse>51.35</an_ptfpdz_cbse><an_ptfpjs_fs>647</an_ptfpjs_fs><an_ptfpjs_cbje>6535.00</an_ptfpjs_cbje><an_ptfpjs_cbse>31.41</an_ptfpjs_cbse><an_hyfp_cbfs>2147</an_hyfp_cbfs><an_hyfp_cbje>31.41</an_hyfp_cbje><an_hyfp_cbse>59.26</an_hyfp_cbse><an_hyfp_rzfs>2147</an_hyfp_rzfs><an_hyfp_rzje>31.41</an_hyfp_rzje><an_hyfp_rzse>31.41</an_hyfp_rzse><an_jdc_cbfs>83</an_jdc_cbfs><an_jdc_cbje>159.26</an_jdc_cbje><an_jdc_cbse>14.15</an_jdc_cbse><an_jdc_rzfs>83</an_jdc_rzfs><an_jdc_rzje>4592.65</an_jdc_rzje><an_jdc_rzse>3141.59</an_jdc_rzse><an_hyfp_hzfs>214.74</an_hyfp_hzfs><an_hyfp_hzje>31.41</an_hyfp_hzje><an_hyfp_hzse>141.59</an_hyfp_hzse></cxNsrHYCBXXresVO></taxML>]]></body></service>";
        try {
            techMsgVo = XmlUtil.doXmlParse(receiverMsg.getBytes("UTF-8"), TechnicalMessageVo.class, new String[] { "UTF-8" });
            HeadType headType = techMsgVo.getXmlParse().getHead();
            technicalBody = techMsgVo.getXmlParse().getBody();
            String returnCode = headType.getRtnCode();
            String code = headType.getRtnMsg().getCode();
            log.debug("-------调用货运系统返回报文已经成功-------body为:" + techMsgVo.getXmlParse().getBody());
            log.debug("-------调用货运系统返回报文已经成功-------RETURNCODE为:" + headType.getRtnCode());
            String returnMsgCode = headType.getRtnMsg().getCode();
            log.debug("-------GT3返回报文已经成功-------报文内容为：" + techMsgVo.getXmlParse().getBody());
            technicalBody = techMsgVo.getXmlParse().getBody();
            log.debug("返回报文节点为：" + technicalBody);
            if(technicalBody!=null && (!"".equals(technicalBody))){
                responseVo = XmlUtil.doXmlParse(technicalBody.getBytes("UTF-8"),
                        response);
                if (responseVo.isSuccess()) {

                    return ResultVo.valueOfSuccess(responseVo.getXmlParse());
                }
            }
            return ResultVo.valueOfError("货运发票抄税查询接口无返回数据");
        }catch (Exception e1) {
            log.error("解析货运发票抄税查询报文失败", e1);
            return ResultVo.valueOfError("解析货运发票抄税查询报文失败");
        }
    }
}
