package com.eduardocode.objectorienteddesign.designprinciples.solidprinciples.openclosed.after;

import java.util.List;

public class PhoneSubscriber extends Subscriber {

    // This method is now open for extension
    @Override
    public double calculateBill() {
        List<CallHistory.Call> sessions = CallHistory.getCurrentCalls(subscriberId);
        long totalDuration = sessions.stream().mapToLong(CallHistory.Call::getDuration).sum();

        return totalDuration*baseRate/100;
    }
}
