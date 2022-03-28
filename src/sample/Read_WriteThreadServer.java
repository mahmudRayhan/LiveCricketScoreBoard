package sample;

import util.NetworkUtil;

import java.io.*;
import java.util.HashMap;
import java.util.Set;

public class Read_WriteThreadServer implements Runnable {
    private Thread thr;
    private NetworkUtil nc;
    String name;
    public HashMap<String, NetworkUtil> clientMap;
    static HashMap<String,MatchInfo>matchInfo;

    HashMap<String, MatchInfo> matchInfoMap;

    public Read_WriteThreadServer(HashMap<String, NetworkUtil> map,HashMap<String, MatchInfo> matchInfoMap, String name,NetworkUtil nc) {
        this.clientMap = map;
        this.matchInfoMap=matchInfoMap;
        this.nc = nc;
        this.thr = new Thread(this);
        this.name = name;
        thr.start();
    }

    public void run() {
        try {
            while (true) {
                Object o = nc.read();
                if (o != null) {
                    if (o instanceof String) {
                        String s = (String) o;
                        if (s!= "" && s!=null) {
                            System.out.println(s);
                            MatchInfo obj = matchInfoMap.get(s);
                            //System.out.println(obj);
                            nc.write(obj);
                        }
                    }
                    else if (o instanceof MatchInfo) {
                        MatchInfo obj = (MatchInfo) o;
                        System.out.println(obj);
                        matchInfoMap.put(obj.getMatchCode(),obj);
                        writeInFile(matchInfoMap);
                    }

                    else if (o instanceof Player) {
                        Player obj = (Player) o;
                        System.out.println(obj);

                        MatchInfo matchInfo = matchInfoMap.get(obj.getMatchCode());
                        matchInfo.setNewBatsmen(obj);
                        matchInfoMap.put(matchInfo.getMatchCode(),matchInfo);
                        Server.setMatchInfoMap(matchInfoMap);
                        writeInFile(obj);
                    }

                    else if (o instanceof Bowler) {
                        Bowler obj = (Bowler) o;
                        System.out.println(obj);

                        MatchInfo matchInfo = matchInfoMap.get(obj.getMatchCode());
                        matchInfo.setNewBowlers(obj);
                        matchInfoMap.put(matchInfo.getMatchCode(),matchInfo);
                        Server.setMatchInfoMap(matchInfoMap);
                        writeInFile(obj);
                    }

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            nc.closeConnection();
        }
    }

    private void writeInFile(Bowler obj) throws IOException {

        FileWriter fw = new FileWriter(obj.getMatchCode()+"b.txt",true);
        BufferedWriter bw = new BufferedWriter(fw);


        String s = obj.toString();
        if (s != null || s != "") {
            bw.write("\n"+s);

            bw.close();
        }

    }

    private void writeInFile(Player obj) throws IOException {

        FileWriter fw = null;
        try {
            fw = new FileWriter(obj.getMatchCode()+"p.txt",true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter bw = new BufferedWriter(fw);


        String s = obj.toString();
        if (s != null || s != "") {
            bw.write("\n" + s);

            bw.close();
        }
    }

    void writeInFile(HashMap<String,MatchInfo>map){

        try{
            FileWriter fw=new FileWriter("Matches.txt");
            BufferedWriter bw=new BufferedWriter(fw);

            Set<String> Keys=map.keySet();
            for(String key:Keys){
//                System.out.println(map.get(key));
                MatchInfo obj=map.get(key);
                System.out.println(obj.getStrArg());
                String s=obj.getStrArg();
                if(s!=null || s!=""){
                    bw.write(s+"\n");
                }
            }
            bw.close();
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    public static HashMap<String, MatchInfo> getMatchInfo() {
        return matchInfo;
    }

    public static void setMatchInfo(HashMap<String, MatchInfo> matchInfo) {
        Read_WriteThreadServer.matchInfo = matchInfo;
    }
}
