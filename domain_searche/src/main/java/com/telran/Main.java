package com.telran;

import org.apache.commons.net.whois.WhoisClient;
import java.io.*;
import java.util.List;

public class Main {
    static final String ZONES_FILENAME = "C:\\Users\\Olga\\Documents\\Domain zone.txt";

    public static void main(String[] args) throws IOException {
        //load the txt file
        FileOperations fo = new FileOperations();
        List<String> zones = fo.readFileToList(ZONES_FILENAME);
        System.out.println(zones);

        //read line from the console
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.print("Enter domain name: ");
            String domainName = br.readLine();

            if ("q".equals(domainName)) {
                System.out.println("Exit!");
                System.exit(0);
            }
            System.out.println("checking domain : " + domainName);
            checkDomains(zones, domainName);

            System.out.println("-----------\n");
        }
    }

    private static void checkDomains(List<String> zones, String domainName) {
        //whois checking domain
        zones.stream().forEach((zone)->{
            String fullDomainName = domainName +zone;
            System.out.println(fullDomainName + " is " +
                    (WhoisHelper.isFree(fullDomainName)?"free":"taken"));
        });
    }
}
