package com.bl.cricketleague;

import com.bl.cricketleague.exception.CricketLeagueException;
import com.bl.cricketleague.model.IplMostRuns;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class CricketLeague
{

    public static void main(String[] args)
    {
        System.out.println("Welcome To Cricket League Problme Statment");

    }

    public static Integer readFile(String filePath)
    {
        int count=0;
        try
        {
            BufferedReader reader= Files.newBufferedReader(Paths.get(filePath));

            CsvToBean<IplMostRuns> csvToBean= new CsvToBeanBuilder(reader)
                    .withType(IplMostRuns.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            Iterator<IplMostRuns> stateCensesAnalyzerClassIterator=csvToBean.iterator();
            while (stateCensesAnalyzerClassIterator.hasNext())
            {
                IplMostRuns iplMostRuns=stateCensesAnalyzerClassIterator.next();
                count++;
            }
        }
        catch ( IOException e)
        {
            throw new CricketLeagueException(CricketLeagueException.ExceptionType.FILE_NOT_FOUND,"Enter Correct File And Type");
        }
        catch ( RuntimeException e)
        {
            throw new CricketLeagueException(CricketLeagueException.ExceptionType.WRONG_DELIMITER,"Check Delimiter And Header");
        }
        return count;
    }
}
