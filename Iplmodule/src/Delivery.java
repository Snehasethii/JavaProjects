public class Delivery {
    private Integer matchId;
    private String inning;
    private String battingTeam;
    private String bowlingTeam;
    private Integer over;
    private Integer ball;
    private String batsMan;
    private String nonStriker;
    private String bowler;
    private String isSupeOver;
    private String wideRuns;
    private String byeRuns;
    private String noballRuns;
    private String penaltyRuns;
    private String batsmanRuns;
    private Integer extraRuns;
    private Integer totalRuns;
    private String playerDismissed;
    private String dismissalKind;
    private String fielder;


    public Delivery(int matchId,String battingTeam,int ball,String bowler,int extraRuns,int totalRuns){

        this.matchId = matchId;
        this.battingTeam = battingTeam;
        this.ball = ball;
        this.bowler = bowler;
        this.extraRuns = extraRuns;
        this.totalRuns = totalRuns;
    }

    public Integer getMatchId() {
        return matchId;
    }

    public String getBattingTeam() {
        return battingTeam;
    }

    public Integer getBall() {
        return ball;
    }

    public String getBowler() {
        return bowler;
    }

    public Integer getExtraRuns() {
        return extraRuns;
    }

    public Integer getTotalRuns() {
        return totalRuns;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }

    public void setBattingTeam(String battingTeam) {
        this.battingTeam = battingTeam;
    }

    public void setBall(Integer ball) {
        this.ball = ball;
    }

    public void setBowler(String bowler) {
        this.bowler = bowler;
    }

    public void setExtraRuns(Integer extraRuns) {
        this.extraRuns = extraRuns;
    }

    public void setTotalRuns(Integer totalRuns) {
        this.totalRuns = totalRuns;
    }
}

