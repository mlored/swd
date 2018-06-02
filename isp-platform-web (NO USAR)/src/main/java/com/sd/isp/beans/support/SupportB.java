package com.sd.isp.beans.support;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.sd.isp.beans.base.BaseBean;

public class SupportB extends BaseBean {
    private static final long serialVersionUID = 1L;
    private String _message;
    private String _subject;
    private String _email;
    private String _phone;
    private String _userName;

    public SupportB(Map<String, String> params) {
        super(params);
    }

    @Override
    protected void create(Map<String, String> params) {
        if (!StringUtils.isBlank(params.get("id"))) {
            setId(Integer.valueOf(params.get("id")));
        }
        setUserName(params.get("userName"));
        setMessage(params.get("message"));
        setSubject(params.get("subject"));
        setEmail(params.get("email"));
        setPhone(params.get("phone"));
    }

    public String getMessage() {
        return _message;
    }

    public void setMessage(String message) {
        _message = message;
    }

    public String getSubject() {
        return _subject;
    }

    public void setSubject(String subject) {
        _subject = subject;
    }

    public String getEmail() {
        return _email;
    }

    public void setEmail(String email) {
        _email = email;
    }

    public String getPhone() {
        return _phone;
    }

    public void setPhone(String phone) {
        _phone = phone;
    }

    public String getUserName() {
        return _userName;
    }

    public void setUserName(String userName) {
        _userName = userName;
    }


}
