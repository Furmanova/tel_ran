package com.telran;

import org.apache.commons.net.whois.WhoisClient;
import java.io.IOException;

public class WhoisHelper {

        public static String getWhois(String domainName) {
            WhoisClient whois = new WhoisClient();

            whois.setConnectTimeout(10000);
            whois.setDefaultTimeout(10000);
            String domainWhois = "is taken";
            try {
                whois.connect("whois.verisign-grs.com", 43);
                domainWhois = whois.query(domainName);
                whois.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return domainWhois;
        }
        public static boolean isFree(String domainName){
        return getWhois(domainName).contains("No match");
    }
}
