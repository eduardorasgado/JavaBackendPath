package com.eduardocode.objectorienteddesign.designpatterns.structural.flyweight.errormessage;

import java.time.Duration;

public class UserBannedError {

    private String caseId;
    private String remarks;
    private Duration banDuration;

    private ErrorMessage msg;

    public UserBannedError(ErrorMessage message, String caseId) {
        this.caseId = "USER_BANNED_ERROR_REASON_" + caseId;
        msg = message;
    }

    public String getMessage() {
        return msg.getText(getCaseNo());
    }

    public String getCaseNo() {
        return caseId;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public void setBanDuration(Duration banDuration) {
        this.banDuration = banDuration;
    }

    public ErrorMessage getFlyweght() {
        return msg;
    }
}
