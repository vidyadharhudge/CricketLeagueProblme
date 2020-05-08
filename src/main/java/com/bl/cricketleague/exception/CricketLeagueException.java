package com.bl.cricketleague.exception;

public class CricketLeagueException extends RuntimeException
{
    public enum ExceptionType
    {
        FILE_NOT_FOUND,WRONG_DELIMITER,NO_CENSUS_DATA;
    }
    public CricketLeagueException.ExceptionType type;
    public CricketLeagueException(CricketLeagueException.ExceptionType type, String message)
    {
        super(message);
        this.type=type;
        System.out.println(message);
    }

}
