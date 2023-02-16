package com.eduardocode.objectorienteddesign.designpatterns.structural.proxy.internet;

import java.util.ArrayList;
import java.util.List;

public class ProxyInternet implements Internet {
    private DefaultInternet internet;
    private static List<String> bannedSites;

    static {
        bannedSites = new ArrayList<>();

        bannedSites.add("facebook.com");
        bannedSites.add("youtube.com");
    }
    public ProxyInternet() {
        internet = new DefaultInternet();
    }

    @Override
    public void connectToHost(String host) {
        if(bannedSites.contains(host.toLowerCase())) {
            throw new RuntimeException("Access Denied: connecting to " + host);
        }

        internet.connectToHost(host);
    }
}
