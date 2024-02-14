package com.example.iplvault.Data;

import com.example.iplvault.Entity.Match;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MatchDataProcessor implements  ItemProcessor<MatchInfo, Match>{
    private static final Logger log = LoggerFactory.getLogger(MatchDataProcessor.class);

    @Override
    public Match process(final MatchInfo matchInfo) {

        Match match = new Match();
        match.setId(Long.parseLong(matchInfo.getId()));
        match.setCity(matchInfo.getCity());
        match.setDate(LocalDateTime.parse(matchInfo.getDate()));
        match.setVenue(matchInfo.getVenue());

        //set team 1 and team 2 depending on innings order..
        String firstInningsTeam, secondInningsTeam;
        if("bat".equals(matchInfo.getToss_decision())){
            firstInningsTeam=matchInfo.getToss_winner();
            secondInningsTeam=matchInfo.getToss_winner().equals(matchInfo.getTeam1())
                    ? matchInfo.getTeam2() : matchInfo.getTeam1();
        }else {
            secondInningsTeam = matchInfo.getToss_winner();
            firstInningsTeam = matchInfo.getToss_winner().equals(matchInfo.getTeam1())
                    ? matchInfo.getTeam2() : matchInfo.getTeam1();
        }
        match.setTeam1(firstInningsTeam);
        match.setTeam2(secondInningsTeam);
        match.setTossWinner(matchInfo.getToss_winner());
        match.setTossDecision(matchInfo.getToss_decision());
        match.setResult(matchInfo.getResult());
        match.setSeason(matchInfo.getSeason());
        match.setPlayerOfMatch(matchInfo.getPlayer_of_match());
        match.setDlAapplied(matchInfo.getDl_applied());
        match.setWinner(matchInfo.getWinner());
        match.setWinByWickets(Integer.parseInt(matchInfo.getWin_by_wickets()));
        match.setWinByRuns(Integer.parseInt(matchInfo.getWin_by_runs()));
        match.setUmpire1(matchInfo.getUmpire1());
        match.setUmpire3(matchInfo.getUmpire3());
        match.setUmpire2(matchInfo.getUmpire2());
        return match;
}






}