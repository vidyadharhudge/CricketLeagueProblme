package com.bl.cricketleague.model;

import com.opencsv.bean.CsvBindByName;

public class IplMostRuns
{

    @CsvBindByName(column = "POS")
    public String POS;

    @CsvBindByName(column = "PLAYER")
    public String PLAYER;

    @CsvBindByName(column = "Mat")
    public String Mat;

    @CsvBindByName(column = "Inns")
    public String Inns;

    @CsvBindByName(column = "NO")
    public String NO;

    @CsvBindByName(column = "Runs")
    public double Runs;

    @CsvBindByName(column = "HS")
    public String HS;

    @CsvBindByName(column = "Avg")
    public double Avg;

    @CsvBindByName(column = "BF")
    public String BF;

    @CsvBindByName(column = "SR")
    public double SR;

    @CsvBindByName(column = "100")
    public String hundred;

    @CsvBindByName(column = "50")
    public String fifty;

    @CsvBindByName(column = "4s")
    public int fours;

    @CsvBindByName(column = "6s")
    public int sixs;

    public String getPLAYER() {
        return PLAYER;
    }

    @Override
    public String toString() {
        return "IplMostRuns{" +
                "POS='" + POS + '\'' +
                ", PLAYER='" + PLAYER + '\'' +
                ", Mat='" + Mat + '\'' +
                ", Inns='" + Inns + '\'' +
                ", NO='" + NO + '\'' +
                ", Runs='" + Runs + '\'' +
                ", HS='" + HS + '\'' +
                ", Avg='" + Avg + '\'' +
                ", BF='" + BF + '\'' +
                ", SR='" + SR + '\'' +
                ", hundred='" + hundred + '\'' +
                ", fifty='" + fifty + '\'' +
                ", fours='" + fours + '\'' +
                ", sixs='" + sixs + '\'' +
                '}';
    }
}
