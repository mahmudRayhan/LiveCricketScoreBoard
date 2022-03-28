package sample;

import java.io.Serializable;

public class Bowler implements Serializable {
    private String name;
    private String ballsBowled;
    private String oversBowled;
    private String runsConsumed;
    private String wicketsTaken;

    private String matchCode;

    public Bowler(String name, String oversBowled, String runsConsumed, String wicketsTake) {
        this.name = name;
        this.oversBowled = oversBowled;
        this.runsConsumed = runsConsumed;
        this.wicketsTaken = wicketsTake;
    }

    public Bowler(String str){
        String[] st = str.split(",");
        this.name = st[0];
        this.oversBowled = st[1];
        this.runsConsumed = st[2];
        this.wicketsTaken = st[3];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBallsBowled() {
        return ballsBowled;
    }

    public void setBallsBowled(String ballsBowled) {
        this.ballsBowled = ballsBowled;
    }

    public String getOversBowled() {
        return oversBowled;
    }

    public void setOversBowled(String oversBowled) {
        this.oversBowled = oversBowled;
    }

    public String getRunsConsumed() {
        return runsConsumed;
    }

    public void setRunsConsumed(String runsConsumed) {
        this.runsConsumed = runsConsumed;
    }

    public String getWicketsTaken() {
        return wicketsTaken;
    }

    public void setWicketsTaken(String wicketsTake) {
        this.wicketsTaken = wicketsTake;
    }

    @Override
    public String toString() {
        return name + "," +ballsBowled + ',' +oversBowled + ','+ runsConsumed + ','+ wicketsTaken;
    }

    public String getMatchCode() {
        return matchCode;
    }

    public void setMatchCode(String matchCode) {
        this.matchCode = matchCode;
    }
}
