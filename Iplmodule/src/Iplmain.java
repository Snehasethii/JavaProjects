import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Iplmain {
    public static final int MATCH_ID = 0;
    public static final int MATCH_SEASON = 1;
    public static final int MATCH_CITY = 2;
    public static final int MATCH_DATE = 3;
    public static final int MATCH_TEAM1 = 4;
    public static final int MATCH_TEAM2 = 5;
    public static final int MATCH_TOSS_WINNER = 6;
    public static final int MATCH_TOSS_DECISION = 7;
    public static final int MATCH_RESULT = 8;
    public static final int MATCH_DL_APPLIED = 9;
    public static final int MATCH_WINNER = 10;
    public static final int MATCH_WIN_BY_RUNS = 11;
    public static final int MATCH_WIN_BY_WICKETS = 12;
    public static final int MATCH_VENUE = 13;
    public static final int MATCH_PLAYER_OF_THE_MATCH = 14;
    public static final int MATCH_UMPIRE1 = 15;
    public static final int MATCH_UMPIRE2 = 16;
    public static final int MATCH_UMPIRE3 = 17;

    public static final int DELIVERY_MATCH_ID = 0;
    public static final int DELIVERY_INNINGS = 1;
    public static final int DELIVERY_BATTING_TEAM = 2;
    public static final int DELIVERY_BOWLING_TEAM = 3;
    public static final int DELIVERY_OVER = 4;
    public static final int DELIVERY_BALL = 5;
    public static final int DELIVERY_BATSMAN = 6;
    public static final int DELIVERY_NON_STRIKER = 7;
    public static final int DELIVERY_BOWLER = 8;
    public static final int DELIVERY_IS_SUPER_OVER = 9;
    public static final int DELIVERY_WIDE_RUNS = 10;
    public static final int DELIVERY_BYE_RUNS = 11;
    public static final int DELIVERY_LEGBYE_RUNS = 12;
    public static final int DELIVERY_NOBALL_RUNS = 13;
    public static final int DELIVERY_PENALTY_RUNS = 14;
    public static final int DELIVERY_BATSMAN_RUNS = 15;
    public static final int DELIVERY_EXTRA_RUNS = 16;
    public static final int DELIVERY_TOTAL_RUNS = 17;
    public static final int DELIVERY_PLAYER_DISMISSED = 18;
    public static final int DELIVERY_DISMISSAL_KIND = 19;
    public static final int DELIVERY_FIELDER = 20;


    public static void main(String[] args) {

        List<Match> matches = getMatchesData();
        List<Delivery> deliveries = getDeliveriesData();
        findMatchesPlayedPerYear(matches);
        findMatchesWonByPerTeam(matches);
        findExtraRunsConcededPerTeam(matches,deliveries);
        findTopEconomicBowlers(matches,deliveries);
        findManOfMatches(matches);
        getMatchesData();
        getDeliveriesData();
    }

    private static List<Match> getMatchesData() {
        List<Match> matches = new ArrayList<>();
        String msg = "";
        try (BufferedReader matchReader = new BufferedReader(new FileReader("matches.csv"))) {
            matchReader.readLine();
            while ((msg = matchReader.readLine()) != null) {

                String[] matchData = msg.split(",");
                Match match = new Match(Integer.parseInt(matchData[MATCH_ID]),
                                        matchData[MATCH_SEASON],
                                        matchData[MATCH_WINNER],matchData[MATCH_PLAYER_OF_THE_MATCH]);
                matches.add(match);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return matches;
    }

    private static List<Delivery> getDeliveriesData() {
        List<Delivery> deliveries = new ArrayList<>();
        String line = "";
        try (BufferedReader deliveryReader = new BufferedReader(new FileReader("deliveries.csv"))) {
            deliveryReader.readLine();
            while ((line = deliveryReader.readLine()) != null) {

                String[] deliveryData = line.split(",");
                Delivery delivery = new Delivery(Integer.parseInt(deliveryData[DELIVERY_MATCH_ID]),
                        deliveryData[DELIVERY_BATTING_TEAM],Integer.parseInt(deliveryData[DELIVERY_BALL]),
                        deliveryData[DELIVERY_BOWLER],Integer.parseInt(deliveryData[DELIVERY_EXTRA_RUNS]),
                        Integer.parseInt(deliveryData[DELIVERY_TOTAL_RUNS]));
                deliveries.add(delivery);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return deliveries;
    }



    private static void findMatchesPlayedPerYear(List<Match> matches) {
        Map<String, Integer> matchesPlayedPerYear = new HashMap<>();

        for(Match match : matches){

            String season = match.getSeason();
            if (matchesPlayedPerYear.get(season) == null) {
                matchesPlayedPerYear.put(season,0);
            }
            int countNumberOfMatches= matchesPlayedPerYear.get(season);
            matchesPlayedPerYear.put(season, countNumberOfMatches + 1);
        }
        for (Map.Entry<String, Integer> me : matchesPlayedPerYear.entrySet()) {
            System.out.print("In season "+me.getKey() + " number of matches played :");
            System.out.println(me.getValue());

        }
        System.out.println("=========================================================================");
    }

    private static void findMatchesWonByPerTeam(List<Match> matches) {
        Map<String, Integer> matchesWinnerTeam = new HashMap<>();

        for(Match match : matches){

            String winnerTeam = match.getWinner();
            if (matchesWinnerTeam.get(winnerTeam) == null) {
                matchesWinnerTeam.put(winnerTeam,0);
            }
            int countNumberOfMatches= matchesWinnerTeam.get(winnerTeam);
            matchesWinnerTeam.put(winnerTeam, countNumberOfMatches + 1);
        }
        for (Map.Entry<String, Integer> me : matchesWinnerTeam.entrySet()) {

            System.out.print("Team "+me.getKey() + " won number of matches : ");
            System.out.println(me.getValue());

        }
        System.out.println("=========================================================================");

    }

    private static  void findExtraRunsConcededPerTeam(List<Match> matches,List <Delivery>deliveries){

        Map<String,Integer> extraRuns = new HashMap<>();

        for( Match match:matches) {
            if ("2016".equals(match.getSeason())) {

                for (Delivery delivery : deliveries) {
                    if (match.getId().equals(delivery.getMatch_id())) {

                        extraRuns.put(delivery.getBatting_team(),
                                extraRuns.getOrDefault(delivery.getBatting_team(),
                                        0)+ delivery.getExtra_runs());
                    }
                }
            }
        }
//        for(Match match : matches) {
//            matchidtoseason.put(match.getId(), match.getSeason());
//        }
//            String season = "2016";
//
//            for (Delivery delivery : deliveries) {
//                String battingTeam = delivery.getBatting_team();
//                int extraruns = delivery.getExtra_runs();
//                int match_id = delivery.getMatch_id();
//                if (matchidtoseason.get(match_id).equals(season)) {
//                //if (delivery.getMatch_id().equals("season")) {
//                    if (extraRuns.get(battingTeam) == null) {
//                        extraRuns.put(battingTeam, 0);
//                    }
//                    extraRuns.put(battingTeam, (extraRuns.get(battingTeam) + extraruns));
//                }


        for (Map.Entry<String, Integer> me : extraRuns.entrySet()) {
            System.out.print("In 2016 extra runs conceded by "+me.getKey() + " is :  "+me.getValue());
            System.out.println();
        }
        System.out.println("=========================================================================");

    }
    private static  void findTopEconomicBowlers(List<Match> matches,List <Delivery>deliveries) {
        Map<String, Integer> bowlerRuns = new HashMap<>();
        Map<String, Integer> bowlerBalls = new HashMap<>();
        Map<Integer, String> matchidtoseason = new HashMap<>();
        Map<String, Double> bowlingAverage = new HashMap<>();

        for (Match match : matches) {
            matchidtoseason.put(match.getId(), match.getSeason());
        }

        for (Delivery delivery : deliveries) {
            int match_id = delivery.getMatch_id();
            String bowler = delivery.getBowler();
            int runs = delivery.getTotal_runs();

            if (matchidtoseason.get(match_id).equals("2015")) {

                if (bowlerBalls.get(bowler) == null) {
                    bowlerBalls.put(bowler, 0);
                }
                if (bowlerRuns.get(bowler) == null) {
                    bowlerRuns.put(bowler, 0);
                }


                bowlerBalls.put(bowler, bowlerBalls.get(bowler) + 1);
                int sum=bowlerRuns.get(bowler);
                bowlerRuns.put(bowler, (sum + runs));


            }
        }

                for (String bowler : bowlerBalls.keySet()) {
                    Double balls = Double.valueOf(bowlerBalls.get(bowler));
                    Double runs = Double.valueOf(bowlerRuns.get(bowler));

                    double average = runs / (balls / 6);
//                    System.out.println(bowler+" runs "+runs+"   over "+(balls/6));
                    bowlingAverage.put(bowler, average);
                }

                Set<Map.Entry<String,Double>> entries = bowlingAverage.entrySet();
                List<Map.Entry<String,Double>> list= new ArrayList<>(entries);
                Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
                    @Override
                    public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
                        return o1.getValue().compareTo(o2.getValue());
                    }

                });

                for (int i=0;i< list.size();i++)
                {
                    System.out.println("Bowler name : "+ list.get(i));
                }


        System.out.println("================================================================================");
            }

    private static void findManOfMatches(List<Match> matches) {
        Map<String, Integer> manOfThematch = new HashMap<>();

        for (Match match : matches) {

            String player_of_match = match.getPlayer_of_match();
            String season = match.getSeason();
            if (manOfThematch.get(player_of_match) == null) {
                manOfThematch.put(player_of_match, 0);
            }
            if ("2016".equals(season)) {

                int countNumberOfMatches = manOfThematch.get(player_of_match);
                manOfThematch.put(player_of_match, countNumberOfMatches + 1);
            }
        }

        Set<Map.Entry<String, Integer>> entries = manOfThematch.entrySet();
        List<Map.Entry<String, Integer>> list = new ArrayList<>(entries);
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }

        });

        Collections.reverse(list);
        for (int i=0;i<5;i++)
        {
            System.out.println("In 2016 man of the match : " + list.get(i) +" times");
        }


        System.out.println("=========================================================================");

    }




}