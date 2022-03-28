package sample;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MatchInfo implements Serializable {

    private String strArg;

    private String matchCode;
    private String matchName;
    private String toss;

    private String team1;
    private String team1_run;
    private String team1_over;
    private String team1_wicket;

    private String team2;
    private String team2_run;
    private String team2_over;
    private String team2_wicket;
    private String target;

    private String batsman1;
    private String batsman1_run;
    private String batsman1_ball;

    private String batsman2;
    private String batsman2_run;
    private String batsman2_ball;

    private String bowler;
    private String ball_1;
    private String ball_2;
    private String ball_3;
    private String ball_4;
    private String ball_5;
    private String ball_6;

    ArrayList<Player> batsmen = new ArrayList<>();
    ArrayList<Bowler> bowlers = new ArrayList<>();

    MatchInfo(String s){
        strArg=s;
        String[] info = s.split(",");

        matchCode=info[0];
        matchName=info[1];
        toss=info[2];

        team1=info[3];
        team1_run=info[4];
        team1_over=info[5];
        team1_wicket=info[6];

        team2=info[7];
        team2_run=info[8];
        team2_over=info[9];
        team2_wicket=info[10];
        target=info[11];

        batsman1=info[12];
        batsman1_run=info[13];
        batsman1_ball=info[14];

        batsman2=info[15];
        batsman2_run=info[16];
        batsman2_ball=info[17];

        bowler=info[18];
        ball_1=info[19];
        ball_2=info[20];
        ball_3=info[21];
        ball_4=info[22];
        ball_5=info[23];
        ball_6=info[24];

    }

    public String getBowler() {
        return bowler;
    }

    public void setBowler(String bowler) {
        this.bowler = bowler;
    }

    public String getStrArg() {
        return strArg;
    }

    public void setStrArg(String strArg) {
        this.strArg = strArg;
    }

    public String getMatchCode() {
        return matchCode;
    }

    public void setMatchCode(String matchCode) {
        this.matchCode = matchCode;
    }

    public String getMatchName() {
        return matchName;
    }

    public void setMatchName(String matchName) {
        this.matchName = matchName;
    }

    public String getToss() {
        return toss;
    }

    public void setToss(String toss) {
        this.toss = toss;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam1_run() {
        return team1_run;
    }

    public void setTeam1_run(String team1_run) {
        this.team1_run = team1_run;
    }

    public String getTeam1_over() {
        return team1_over;
    }

    public void setTeam1_over(String team1_over) {
        this.team1_over = team1_over;
    }

    public String getTeam1_wicket() {
        return team1_wicket;
    }

    public void setTeam1_wicket(String team1_wicket) {
        this.team1_wicket = team1_wicket;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public String getTeam2_run() {
        return team2_run;
    }

    public void setTeam2_run(String team2_run) {
        this.team2_run = team2_run;
    }

    public String getTeam2_over() {
        return team2_over;
    }

    public void setTeam2_over(String team2_over) {
        this.team2_over = team2_over;
    }

    public String getTeam2_wicket() {
        return team2_wicket;
    }

    public void setTeam2_wicket(String team2_wicket) {
        this.team2_wicket = team2_wicket;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getBatsman1() {
        return batsman1;
    }

    public void setBatsman1(String batsman1) {
        this.batsman1 = batsman1;
    }

    public String getBatsman1_run() {
        return batsman1_run;
    }

    public void setBatsman1_run(String batsman1_run) {
        this.batsman1_run = batsman1_run;
    }

    public String getBatsman1_ball() {
        return batsman1_ball;
    }

    public void setBatsman1_ball(String batsman1_ball) {
        this.batsman1_ball = batsman1_ball;
    }

    public String getBatsman2() {
        return batsman2;
    }

    public void setBatsman2(String batsman2) {
        this.batsman2 = batsman2;
    }

    public String getBatsman2_run() {
        return batsman2_run;
    }

    public void setBatsman2_run(String batsman2_run) {
        this.batsman2_run = batsman2_run;
    }

    public String getBatsman2_ball() {
        return batsman2_ball;
    }

    public void setBatsman2_ball(String batsman2_ball) {
        this.batsman2_ball = batsman2_ball;
    }

    public String getBall_1() {
        return ball_1;
    }

    public void setBall_1(String ball_1) {
        this.ball_1 = ball_1;
    }

    public String getBall_2() {
        return ball_2;
    }

    public void setBall_2(String ball_2) {
        this.ball_2 = ball_2;
    }

    public String getBall_3() {
        return ball_3;
    }

    public void setBall_3(String ball_3) {
        this.ball_3 = ball_3;
    }

    public String getBall_4() {
        return ball_4;
    }

    public void setBall_4(String ball_4) {
        this.ball_4 = ball_4;
    }

    public String getBall_5() {
        return ball_5;
    }

    public void setBall_5(String ball_5) {
        this.ball_5 = ball_5;
    }

    public String getBall_6() {
        return ball_6;
    }

    public void setBall_6(String ball_6) {
        this.ball_6 = ball_6;
    }



    public ArrayList<Player> getPlayers() {

        return batsmen;
    }

    public ArrayList<Bowler> getBowlers(){

        return bowlers;
    }

    public void setNewBatsmen(Player player){

        batsmen.add(player);
        System.out.println("New batsman added to server.");
    }

    public void setNewBatsmen(String str){
        batsmen.add(new Player(str));
        System.out.println("New batsman added to server.");
    }

    public void setNewBowlers(Bowler bowler){

        bowlers.add(bowler);
        System.out.println("New Bowler added to server.");
    }

    public void setNewBowlers(String str){
        bowlers.add(new Bowler(str));
        System.out.println("New Bowler added to server.");
    }


    //    public static void main(String[] args) {
//        MatchInfo obj=new MatchInfo("102,Australia,England,Australia,England,340,7,45");
//        System.out.println(obj.getOver());
//        System.out.println(obj.getteam2());
//    }
}
