package sample;

import util.NetworkUtil;

public class ReadThreadClient implements Runnable {
    private Thread thr;
    private NetworkUtil nc;

    public ReadThreadClient(NetworkUtil nc) {
        this.nc = nc;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            while (true) {
                Object o = nc.read();
                if (o != null) {
                    if (o instanceof MatchInfo) {
                        MatchInfo obj = (MatchInfo) o;
                        System.out.println(obj);
                        AdminSelectMatchController.setMatch(obj);
                        SelectMatchCodeController.setMatch(obj);
                        PlayerStatsEditController.setMatch(obj);
                        BowlerWindowController.setMatch(obj);
                        BatsmenWindowController.setMatch(obj);
                        ScoreboardController.setMatch(obj);
                    }
                }

            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            nc.closeConnection();
        }
    }
}
