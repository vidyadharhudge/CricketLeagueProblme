package com.bl.cricketleague.model;

import com.opencsv.bean.CsvBindByName;

public class IplMostRuns
{

    @CsvBindByName(column = "POS")
    public double POS;

    @CsvBindByName(column = "PLAYER")
    public String PLAYER;

    @CsvBindByName(column = "Mat")
    public double Mat;

    @CsvBindByName(column = "Inns")
    public double Inns;

    @CsvBindByName(column = "NO")
    public double NO;

    @CsvBindByName(column = "Runs")
    public double Runs;

    @CsvBindByName(column = "HS")
    public String HS;

    @CsvBindByName(column = "Avg")
    public double Avg;

    @CsvBindByName(column = "BF")
    public double BF;

    @CsvBindByName(column = "SR")
    public double SR;

    @CsvBindByName(column = "100")
    public double hundred;

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
