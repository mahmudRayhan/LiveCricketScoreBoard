package sample;

import util.NetworkUtil;

import java.util.Scanner;

public class Client {
    NetworkUtil nc;
    String clientName;

    public Client(String serverAddress, int serverPort) {
        try {

            clientName ="Client";
            nc = new NetworkUtil(serverAddress, serverPort);
            nc.write(clientName);
            clientName=(String)nc.read();
            System.out.println(clientName);
            new ReadThreadClient(nc);
            new WriteThreadClient(nc, clientName);
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public String getClientName() {
        return clientName;
    }
    public NetworkUtil getNc() {
        return nc;
    }
}

