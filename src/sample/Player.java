package sample;

import java.io.Serializable;

public class Player implements Serializable{
    private String name;
    private String runs;
    private String ballsFaced;
    private String wicketInfo;

    private String matchCode;


    public Player(String name, String runs, String ballsFaced, String wicketInfo) {
        this.name = name;
        this.runs = runs;
        this.ballsFaced = ballsFaced;
        this.wicketInfo = wicketInfo;
    }


    public Player(String str){
        String[] st = str.split(",");
        this.name = st[0];
        this.runs = st[1];
        this.ballsFaced = st[2];
        this.wicketInfo = st[3];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRuns() {
        return runs;
    }

    public void setRuns(String runs) {
        this.runs = runs;
    }

    public String getBallsFaced() {
        return ballsFaced;
    }

    public void setBallsFaced(String ballsFaced) {
        this.ballsFaced = ballsFaced;
    }

    public String getWicketInfo() {
        return wicketInfo;
    }

    public void setWicketInfo(String wicketInfo) {
        this.wicketInfo = wicketInfo;
    }

    @Override
    public String toString() {
        return name + ',' +runs + ',' + ballsFaced + ','+ wicketInfo;
    }

    public String getMatchCode() {
        return matchCode;
    }

    public void setMatchCode(String matchCode) {
        this.matchCode = matchCode;
    }
}
