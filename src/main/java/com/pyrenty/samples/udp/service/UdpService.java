package com.pyrenty.samples.udp.service;

import org.springframework.messaging.Message;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UdpService {

    public void receive(Message message) {
        String data = new String((byte[]) message.getPayload());
        System.out.print(data);
    }
}
