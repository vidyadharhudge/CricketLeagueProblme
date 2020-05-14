package com.bl.cricketleague;
import com.bl.cricketleague.exception.CricketLeagueException;
import com.bl.cricketleague.model.IplMostRuns;
import com.bl.cricketleague.model.IplMostWickets;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;

public class CricketLeague {
    List<IplMostRuns> censusCSVList = null;
    List<IplMostWickets> iplMostWicketsList = null;

        public Integer readFileForRuns(String filePath) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            censusCSVList = csvBuilder.getCSVFileList(reader, IplMostRuns.class);
            return censusCSVList.size(); }
        catch (IOException e) {
            throw new CricketLeagueException(CricketLeagueException.ExceptionType.FILE_NOT_FOUND, "Enter Correct File And Type");
        } catch (RuntimeException e) {
            throw new CricketLeagueException(CricketLeagueException.ExceptionType.WRONG_DELIMITER, "Check Delimiter And Header"); } }

        public Integer readFileForWickets(String filePath) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            iplMostWicketsList = csvBuilder.getCSVFileList(reader, IplMostWickets.class);
            return iplMostWicketsList.size(); }
        catch (IOException e) {
            throw new CricketLeagueException(CricketLeagueException.ExceptionType.FILE_NOT_FOUND, "Enter Correct File And Type");}
        catch (RuntimeException e) {
            throw new CricketLeagueException(CricketLeagueException.ExceptionType.WRONG_DELIMITER, "Check Delimiter And Header"); } }

        public String getSortedWiseWicketsWithBestAllRounder() {
        if(iplMostWicketsList.size()==0 || iplMostWicketsList==null)
            throw new CricketLeagueException(CricketLeagueException.ExceptionType.NO_CENSUS_DATA,"No Data");
        Comparator<IplMostWickets> iplMostWicketsComparator = Comparator.comparing(census ->census.Runs);
        iplMostWicketsComparator.thenComparing(census->census.Wkts);
        this.sortForWickets(iplMostWicketsComparator);
        String sortedCensusJson = new Gson().toJson(iplMostWicketsList);
        return sortedCensusJson; }

        public String getSortedMaximumWicketsWithBestBowlingAvg() {
        if(iplMostWicketsList.size()==0 || iplMostWicketsList==null)
            throw new CricketLeagueException(CricketLeagueException.ExceptionType.NO_CENSUS_DATA,"No Data");
        Comparator<IplMostWickets> iplMostWicketsComparator = Comparator.comparing(census -> (census.Wkts));
        iplMostWicketsComparator.thenComparing(census->census.Avg);
        this.sortForWickets(iplMostWicketsComparator);
        String sortedCensusJson = new Gson().toJson(iplMostWicketsList);
        return sortedCensusJson; }

        public String getSortedMaximumWicketsWithBestBowlingAvgBestSR() {
        if(iplMostWicketsList.size()==0 || iplMostWicketsList==null)
            throw new CricketLeagueException(CricketLeagueException.ExceptionType.NO_CENSUS_DATA,"No Data");
        Comparator<IplMostWickets> iplMostWicketsComparator = Comparator.comparing(census -> ((census.Runs/census.Wkts)+census.SR)/2);
        this.sortForWickets(iplMostWicketsComparator);
        String sortedCensusJson = new Gson().toJson(iplMostWicketsList);
        return sortedCensusJson; }

        public String getSortedWiseWicketsWithBestStrikingRate5w4W() {
        if(iplMostWicketsList.size()==0 || iplMostWicketsList==null)
            throw new CricketLeagueException(CricketLeagueException.ExceptionType.NO_CENSUS_DATA,"No Data");
        Comparator<IplMostWickets> iplMostWicketsComparator = Comparator.comparing(census -> census.FiveWickets);
        iplMostWicketsComparator.thenComparing(census->census.FourWickets);
        iplMostWicketsComparator.thenComparing(census->census.SR);
        this.sortForWickets(iplMostWicketsComparator);
        String sortedCensusJson = new Gson().toJson(iplMostWicketsList);
        return sortedCensusJson; }

        public String getSortedWiseWicketsWithBestEconomyRate() {
        if(iplMostWicketsList.size()==0 || iplMostWicketsList==null)
            throw new CricketLeagueException(CricketLeagueException.ExceptionType.NO_CENSUS_DATA,"No Data");
        Comparator<IplMostWickets> iplMostWicketsComparator = Comparator.comparing(census -> census.Econ);
        this.sortForWickets(iplMostWicketsComparator);
        String sortedCensusJson = new Gson().toJson(iplMostWicketsList);
        return sortedCensusJson; }

        public String getSortedWiseWicketsWithBestStrikingRate() {
        if(iplMostWicketsList.size()==0 || iplMostWicketsList==null)
            throw new CricketLeagueException(CricketLeagueException.ExceptionType.NO_CENSUS_DATA,"No Data");
        Comparator<IplMostWickets> iplMostWicketsComparator = Comparator.comparing(census -> ((census.Ov)*6)/census.Wkts);
        this.sortForWickets(iplMostWicketsComparator);
        String sortedCensusJson = new Gson().toJson(iplMostWicketsList);
        return sortedCensusJson; }

        public String getSortedWicketsWithBestBowlingAvrages() {
        if(iplMostWicketsList.size()==0 || iplMostWicketsList==null)
            throw new CricketLeagueException(CricketLeagueException.ExceptionType.NO_CENSUS_DATA,"No Data");
        Comparator<IplMostWickets> iplMostWicketsComparator = Comparator.comparing(census -> (census.Runs/census.Wkts));
        this.sortForWickets(iplMostWicketsComparator);
        String sortedCensusJson = new Gson().toJson(iplMostWicketsList);
        return sortedCensusJson; }

        public String getSortedWiseRunsWithBestAvrage() {
        if(censusCSVList.size()==0 || censusCSVList==null)
            throw new CricketLeagueException(CricketLeagueException.ExceptionType.NO_CENSUS_DATA,"No Data");
        Comparator<IplMostRuns> iplMostRunsComparator = Comparator.comparing(census -> (census.Runs+census.Avg)/2);
        this.sort(iplMostRunsComparator);
        String sortedCensusJson = new Gson().toJson(censusCSVList);
        return sortedCensusJson; }

        public String getSortedWiseAvrageWithBestSR() {
        if(censusCSVList.size()==0 || censusCSVList==null)
            throw new CricketLeagueException(CricketLeagueException.ExceptionType.NO_CENSUS_DATA,"No Data");
        Comparator<IplMostRuns> iplMostRunsComparator = Comparator.comparing(census -> (census.Avg+census.SR)>100);
        this.sort(iplMostRunsComparator);
        String sortedCensusJson = new Gson().toJson(censusCSVList);
        return sortedCensusJson; }

        public String getSortedStrikeRate6s4s()  {
        if(censusCSVList.size()==0 || censusCSVList==null)
            throw new CricketLeagueException(CricketLeagueException.ExceptionType.NO_CENSUS_DATA,"No Data");
        Comparator<IplMostRuns> iplMostRunsComparator = Comparator.comparing(census -> (census.Runs/census.BF)*100);
        this.sort(iplMostRunsComparator);
        String sortedCensusJson = new Gson().toJson(censusCSVList);
        return sortedCensusJson; }

        public String getSortedWise6sAnd4s()  {
        if(censusCSVList.size()==0 || censusCSVList==null)
            throw new CricketLeagueException(CricketLeagueException.ExceptionType.NO_CENSUS_DATA,"No Data");
        Comparator<IplMostRuns> iplMostRunsComparator = Comparator.comparing(census -> census.sixs+census.fours);
        this.sort(iplMostRunsComparator);
        String sortedCensusJson = new Gson().toJson(censusCSVList);
        return sortedCensusJson; }

        public String getSortedWiseStrikeRate()  {
        if(censusCSVList.size()==0 || censusCSVList==null)
            throw new CricketLeagueException(CricketLeagueException.ExceptionType.NO_CENSUS_DATA,"No Data");
        Comparator<IplMostRuns> iplMostRunsComparator = Comparator.comparing(census -> census.SR);
        this.sort(iplMostRunsComparator);
        String sortedCensusJson = new Gson().toJson(censusCSVList);
        return sortedCensusJson; }

        public String getAvrageWiseSorted()  {
        if(censusCSVList.size()==0 || censusCSVList==null)
            throw new CricketLeagueException(CricketLeagueException.ExceptionType.NO_CENSUS_DATA,"No Data");
        Comparator<IplMostRuns> iplMostRunsComparator = Comparator.comparing(census -> census.Avg);
        this.sort(iplMostRunsComparator);
        String sortedCensusJson = new Gson().toJson(censusCSVList);
        return sortedCensusJson; }

    /*Function To Sort Wickets Data*/
    private void sortForWickets(Comparator<IplMostWickets> iplMostWicketsComparator) {
        for (int i = 0; i < iplMostWicketsList.size()-1; i++){
            for (int j=0; j < iplMostWicketsList.size()-i-1; j++){
                IplMostWickets census1 = iplMostWicketsList.get(j);
                IplMostWickets census2 = iplMostWicketsList.get(j+1);
                if (iplMostWicketsComparator.compare(census1,census2)<0){
                    iplMostWicketsList.set(j,census2);
                    iplMostWicketsList.set(j+1,census1); } } }
    }

    /*Function To Sort Runs Data*/
    private void sort(Comparator<IplMostRuns> iplMostRunsComparator) {
        for (int i = 0; i < censusCSVList.size()-1; i++){
            for (int j=0; j < censusCSVList.size()-i-1; j++){
                IplMostRuns census1 = censusCSVList.get(j);
                IplMostRuns census2 = censusCSVList.get(j+1);
                if (iplMostRunsComparator.compare(census1,census2)<0){
                    censusCSVList.set(j,census2);
                    censusCSVList.set(j+1,census1); } } } }
    }



