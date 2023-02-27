package com.eduardocode.objectorienteddesign.designpatterns.structural.flyweight.errormessage;

import java.time.Duration;

public class UserBannedErrorMessage implements ErrorMessage {

    private String caseId;
    private String remarks;
    private Duration banDuration;

    private String msg;

    public UserBannedErrorMessage(String caseId) {
        //Load case info from DB.
        this.caseId = caseId;
        remarks = "You violated terms of use.";
        banDuration = Duration.ofDays(2);
        msg = "You are BANNED. Sorry. \nMore information:\n";
        msg += caseId +"\n";
        msg += remarks+"\n";
        msg += "Banned For:" +banDuration.toHours() + " Hours";
    }

    @Override
    public String getText(String code) {
        return null;
    }

    public String getCaseNo() {
        return caseId;
    }
}
