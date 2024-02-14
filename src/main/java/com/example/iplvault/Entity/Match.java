package com.example.iplvault.Entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class Match {

    private long id;
    private String season;
    private String city;
    private LocalDateTime date;
    private String team1;
    private String team2;
    private String tossWinner;
    private String tossDecision;
    private String result;
    private String dlAapplied;
    private String winner;
    private int winByRuns;
    private int winByWickets;
    private String playerOfMatch;
    private String venue;
    private String umpire1;
    private String umpire2;
    private String umpire3;
}
