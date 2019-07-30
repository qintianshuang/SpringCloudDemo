package com.example.cloud.web.bean.config;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "RtnMsg",
        propOrder = {"code", "message", "reason"}
)
public class RtnMsg {
    @XmlElement(
            name = "Code",
            required = true
    )
    protected String code;
    @XmlElement(
            name = "Message",
            required = true
    )
    protected String message;
    @XmlElement(
            name = "Reason",
            required = true
    )
    protected String reason;

    public RtnMsg() {
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String value) {
        this.code = value;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String value) {
        this.message = value;
    }

    public String getReason() {
        return this.reason;
    }

    public void setReason(String value) {
        this.reason = value;
    }
}
