package com.bl.cricketleague;

public class CSVBuilderFactory
{
    public static ICSVBuilder createCSVBuilder() {
        return new OpenCSVBuilder();
    }
}
