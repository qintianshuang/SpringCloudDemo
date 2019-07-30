package com.example.cloud.web.bean.config;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "headType",
        propOrder = {"tranId", "channelId", "tranSeq", "tranDate", "tranTime", "rtnCode", "rtnMsg", "filePath", "servVersion", "expand"}
)
public class HeadType {
    @XmlElement(
            name = "tran_id",
            required = true
    )
    protected String tranId;
    @XmlElement(
            name = "channel_id",
            required = true
    )
    protected String channelId;
    @XmlElement(
            name = "tran_seq",
            required = true
    )
    protected String tranSeq;
    @XmlElement(
            name = "tran_date",
            required = true
    )
    protected String tranDate;
    @XmlElement(
            name = "tran_time",
            required = true
    )
    protected String tranTime;
    @XmlElement(
            name = "rtn_code"
    )
    protected String rtnCode;
    @XmlElement(
            name = "rtn_msg"
    )
    protected RtnMsg rtnMsg;
    @XmlElement(
            name = "file_path"
    )
    protected String filePath;
    @XmlElement(
            name = "serv_version"
    )
    protected String servVersion;
    protected List<ParamListType> expand;

    public HeadType() {
    }

    public String getTranId() {
        return this.tranId;
    }

    public void setTranId(String value) {
        this.tranId = value;
    }

    public String getChannelId() {
        return this.channelId;
    }

    public void setChannelId(String value) {
        this.channelId = value;
    }

    public String getTranSeq() {
        return this.tranSeq;
    }

    public void setTranSeq(String value) {
        this.tranSeq = value;
    }

    public String getTranDate() {
        return this.tranDate;
    }

    public void setTranDate(String value) {
        this.tranDate = value;
    }

    public String getTranTime() {
        return this.tranTime;
    }

    public void setTranTime(String value) {
        this.tranTime = value;
    }

    public String getRtnCode() {
        return this.rtnCode;
    }

    public void setRtnCode(String value) {
        this.rtnCode = value;
    }

    public RtnMsg getRtnMsg() {
        return this.rtnMsg;
    }

    public void setRtnMsg(RtnMsg value) {
        this.rtnMsg = value;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public void setFilePath(String value) {
        this.filePath = value;
    }

    public String getServVersion() {
        return this.servVersion;
    }

    public void setServVersion(String value) {
        this.servVersion = value;
    }

    public List<ParamListType> getExpand() {
        if (this.expand == null) {
            this.expand = new ArrayList();
        }

        return this.expand;
    }
}

