package com.bl.cricketleague;
import com.bl.cricketleague.exception.CricketLeagueException;
import com.bl.cricketleague.model.IplMostRuns;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.StreamSupport;


public class CricketLeague {

    List<IplMostRuns> censusCSVList = null;

    public Integer readFile(String filePath) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            censusCSVList = csvBuilder.getCSVFileList(reader, IplMostRuns.class);
            System.out.println(censusCSVList);
            return censusCSVList.size(); }
        catch (IOException e) {
            throw new CricketLeagueException(CricketLeagueException.ExceptionType.FILE_NOT_FOUND, "Enter Correct File And Type");
        } catch (RuntimeException e) {
            throw new CricketLeagueException(CricketLeagueException.ExceptionType.WRONG_DELIMITER, "Check Delimiter And Header");
        }
    }

    /* Function To get number of entries in csv file*/
    private <E> int getCount(Iterator<E> iterator) {
        Iterable<E> csvIterable = () -> iterator;
        int numberOfEnteries = (int) StreamSupport.stream(csvIterable.spliterator(), false).count();
        return numberOfEnteries;
    }

    public String getSortedStrikeRate6s4s()  {
        if(censusCSVList.size()==0 || censusCSVList==null)
            throw new CricketLeagueException(CricketLeagueException.ExceptionType.NO_CENSUS_DATA,"No Data");
        Comparator<IplMostRuns> iplMostRunsComparator = Comparator.comparing(census -> census.SR);
        this.sort(iplMostRunsComparator);
        String sortedCensusJson = new Gson().toJson(censusCSVList);
        return sortedCensusJson;
    }

    public String getSortedWiseFours()  {
        if(censusCSVList.size()==0 || censusCSVList==null)
            throw new CricketLeagueException(CricketLeagueException.ExceptionType.NO_CENSUS_DATA,"No Data");
        Comparator<IplMostRuns> iplMostRunsComparator = Comparator.comparing(census -> census.fours);
        this.sort(iplMostRunsComparator);
        String sortedCensusJson = new Gson().toJson(censusCSVList);
        return sortedCensusJson;
    }

    public String getSortedWiseSixes()  {
        if(censusCSVList.size()==0 || censusCSVList==null)
            throw new CricketLeagueException(CricketLeagueException.ExceptionType.NO_CENSUS_DATA,"No Data");
        Comparator<IplMostRuns> iplMostRunsComparator = Comparator.comparing(census -> census.sixs);
        this.sort(iplMostRunsComparator);
        String sortedCensusJson = new Gson().toJson(censusCSVList);
        return sortedCensusJson;
    }



    public String getSortedWiseStrikeRate()  {
        if(censusCSVList.size()==0 || censusCSVList==null)
            throw new CricketLeagueException(CricketLeagueException.ExceptionType.NO_CENSUS_DATA,"No Data");
        Comparator<IplMostRuns> iplMostRunsComparator = Comparator.comparing(census -> census.SR);
        this.sort(iplMostRunsComparator);
        String sortedCensusJson = new Gson().toJson(censusCSVList);
        return sortedCensusJson;
    }

    public String getAvrageWiseSorted()  {
        if(censusCSVList.size()==0 || censusCSVList==null)
            throw new CricketLeagueException(CricketLeagueException.ExceptionType.NO_CENSUS_DATA,"No Data");
        Comparator<IplMostRuns> iplMostRunsComparator = Comparator.comparing(census -> census.Avg);
        this.sort(iplMostRunsComparator);
        String sortedCensusJson = new Gson().toJson(censusCSVList);
        return sortedCensusJson;
    }

    /*Function To Sort States*/
    private void sort(Comparator<IplMostRuns> iplMostRunsComparator) {
        for (int i = 0; i < censusCSVList.size()-1; i++){
            for (int j=0; j < censusCSVList.size()-i-1; j++){
                IplMostRuns census1 = censusCSVList.get(j);
                IplMostRuns census2 = censusCSVList.get(j+1);
                if (iplMostRunsComparator.compare(census1,census2)<0){
                    censusCSVList.set(j,census2);
                    censusCSVList.set(j+1,census1);
                }
            }
        }
    }
}

