package sample;

import util.NetworkUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Server {
    static int clientCounter = 0;
    private ServerSocket serverSocket;
    public HashMap<String, NetworkUtil> clientMap;

    static HashMap<String,MatchInfo>matchInfoMap = new HashMap<>();
    //private static final String INPUT_FILE_NAME = "Matches.txt";

    Server() {
        clientMap = new HashMap<>();
        try {
            serverSocket = new ServerSocket(33333);
            setMatchInfoMap();
            Read_WriteThreadServer.setMatchInfo(matchInfoMap);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                serve(clientSocket);

            }
        } catch (Exception e) {
            System.out.println("Server starts:" + e);
        }
    }

    public void serve(Socket clientSocket) {
        clientCounter++;
        NetworkUtil nc = new NetworkUtil(clientSocket);
        String client = (String) nc.read();
        String clientName = client + clientCounter;
        clientMap.put(clientName, nc);
        System.out.println(clientName + " is connected");
        nc.write(clientName);

//        Read_WriteThreadServer(HashMap<String, NetworkUtil> map,HashMap<String, MatchInfo> matchInfoMap, String name,NetworkUtil nc)
        new Read_WriteThreadServer(clientMap,matchInfoMap, "Server",nc);

    }

    public void setMatchInfoMap() {
            //Getting input from the file
            try {
                String line;

                String dat1;
                String dat2;
                BufferedReader br = new BufferedReader(new FileReader("Matches.txt"));

                while (true) {
                    line = br.readLine();
                    //System.out.println(line);
                    if (line==null) break;

                    MatchInfo obj=new MatchInfo(line);

                    String batsmenFilename = obj.getMatchCode()+"p.txt";
                    String bowlersFilename = obj.getMatchCode()+"b.txt";
                    BufferedReader bat = new BufferedReader(new FileReader(batsmenFilename));
                    BufferedReader bal = new BufferedReader(new FileReader(bowlersFilename));

                    while (true){
                        dat1 = bat.readLine();
                        dat2 = bal.readLine();
//                        if (dat1==null && dat2 == null ) break;
                        if (dat1==null||dat1.isEmpty() && dat2.isEmpty()|| dat2==null) break;
                        obj.setNewBatsmen(dat1);
                        obj.setNewBowlers(dat2);
                    }
                    //System.out.println(obj);
                    matchInfoMap.put(obj.getMatchCode(),obj);
                    bal.close();
                    bat.close();
                }
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public static HashMap<String, MatchInfo> getMatchInfoMap() {
        return matchInfoMap;
    }

    public static void setMatchInfoMap(HashMap<String, MatchInfo> matchInfoMap) {
        Server.matchInfoMap = matchInfoMap;
    }

    public static void main(String args[]) {
        Server server = new Server();
    }
}
