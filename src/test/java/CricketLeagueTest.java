import com.bl.cricketleague.CricketLeague;
import com.bl.cricketleague.exception.CricketLeagueException;
import com.bl.cricketleague.model.IplMostRuns;
import com.bl.cricketleague.model.IplMostWickets;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static com.bl.cricketleague.FilePaths.*;

public class CricketLeagueTest {
    CricketLeague cricketLeague;

    @Before
    public void setup() {
        cricketLeague = new CricketLeague();
    }

    /* Tc 1.1 :Given The Ipl Most Run Csv File, Check To Ensure The Number Of Record Matches */
    @Test
    public void givenFilePath_WhenNoOfRecordMatches_ThenReturnTrue() {
        int noOfRecords = cricketLeague.readFileForRuns(IPL_MOST_RUN_SHEET);
        Assert.assertEquals(100, noOfRecords);
    }

    /* T.C 1.2 :Given IPL Censes Csv File Is Incorrect Then Returns Custom Exception */
    @Test
    public void givenCricketLeagueData_WhenWithWrongFile_ThenShouldThrowException() {
        try {
            cricketLeague.readFileForRuns(WRONG_CSV_FILE_PATH);}
        catch (CricketLeagueException e) {
            Assert.assertEquals(CricketLeagueException.ExceptionType.FILE_NOT_FOUND, e.type); }
    }

    /* T.C 1.3 :Given IPL Censes Csv Type Is Incorrect Then Returns Custom Exception */
    @Test
    public void givenCricketLeagueData_WhenWithWrongType_ThenShouldThrowException() {
        try {
            cricketLeague.readFileForRuns(WRONG_CSV_FILE_TYPE);}
        catch (CricketLeagueException e) {
            Assert.assertEquals(CricketLeagueException.ExceptionType.FILE_NOT_FOUND, e.type); }
    }

    /* T.C 1.4 :Given IPL Censes Csv file Is Correct But With Wrong Delimiter Should Rhrow Custom Exception */
    @Test
    public void givenCricketLeagueData_WhenWithWrongDelimiter_ThenShouldThrowException() {
        try {
            cricketLeague.readFileForRuns(WRONG_DELIMITER_FILE);}
         catch (CricketLeagueException e) {
            Assert.assertEquals(CricketLeagueException.ExceptionType.WRONG_DELIMITER, e.type); }
    }

    /* T.C 1.5 :Given IPL Censes Csv file Is Correct But With Wrong Header Should Rhrow Custom Exception */
    @Test
    public void givenCricketLeagueData_WhenWithWrongHeader_ThenShouldThrowException() {
        try {
            cricketLeague.readFileForRuns(WRONG_DELIMITER_FILE);}
        catch (CricketLeagueException e) {
            Assert.assertEquals(CricketLeagueException.ExceptionType.WRONG_DELIMITER, e.type); }
    }

    /* TC 1.6 : Given Cricket Census Data when sorted should return sorted data BY Avrage Wise*/
    @Test
    public void givenCricketLeagueData_whenSorted_shouldReturnSortedDataAvrage() {
        cricketLeague.readFileForRuns(IPL_MOST_RUN_SHEET);
        String sortedCensusData = cricketLeague.getAvrageWiseSorted();
        IplMostRuns[] censusCsv = new Gson().fromJson(sortedCensusData, IplMostRuns[].class);
        String name = censusCsv[0].getPLAYER();
        Assert.assertEquals("MS Dhoni", name); }

    /* TC 2 : Given Cricket League Data when sorted should return sorted data By Strike Rate*/
    @Test
    public void givenCricketLeagueData_whenSorted_shouldReturnSortedStrikeRate() {
        cricketLeague.readFileForRuns(IPL_MOST_RUN_SHEET);
        String sortedCensusData = cricketLeague.getSortedWiseStrikeRate();
        IplMostRuns[] censusCsv = new Gson().fromJson(sortedCensusData, IplMostRuns[].class);
        String name = censusCsv[0].getPLAYER();
        Assert.assertEquals("Ishant Sharma", name); }

    /* TC 3 : Given Cricket League Data when sorted should return sorted data By Sixes*/
    @Test
    public void givenCricketLeagueData_whenSorted_shouldReturnSortedSixesAndFours() {
        cricketLeague.readFileForRuns(IPL_MOST_RUN_SHEET);
        String sortedCensusData = cricketLeague.getSortedWise6sAnd4s();
        IplMostRuns[] censusCsv = new Gson().fromJson(sortedCensusData, IplMostRuns[].class);
        String name = censusCsv[0].getPLAYER();
        Assert.assertEquals("Andre Russell", name); }

        /* TC 4 : Given Cricket League Data when sorted should return sorted data By SR With 4s And 6s*/
    @Test
    public void givenCricketLeagueData_whenSorted_shouldReturnSortedStrikeRateWithSixesAndFours() {
        cricketLeague.readFileForRuns(IPL_MOST_RUN_SHEET);
        String sortedCensusData = cricketLeague.getSortedStrikeRate6s4s();
        IplMostRuns[] censusCsv = new Gson().fromJson(sortedCensusData, IplMostRuns[].class);
        String name = censusCsv[0].getPLAYER();
        Assert.assertEquals("Andre Russell", name); }

    /* TC 5 : Given Cricket League Data when sorted should return sorted data By Avg With Best SR*/
    @Test
    public void givenCricketLeagueData_whenSorted_shouldReturnSortedAvrageWithBestSR() {
        cricketLeague.readFileForRuns(IPL_MOST_RUN_SHEET);
        String sortedCensusData = cricketLeague.getSortedWiseAvrageWithBestSR();
        IplMostRuns[] censusCsv = new Gson().fromJson(sortedCensusData, IplMostRuns[].class);
        String name = censusCsv[0].getPLAYER();
        Assert.assertEquals("David Warner", name); }

    /* TC 6 : Given Cricket League Data when sorted should return sorted data By Runs With Best Avg*/
    @Test
    public void givenCricketLeagueData_whenSorted_shouldReturnSortedRunsWithBestAvg() {
        cricketLeague.readFileForRuns(IPL_MOST_RUN_SHEET);
        String sortedCensusData = cricketLeague.getSortedWiseRunsWithBestAvrage();
        IplMostRuns[] censusCsv = new Gson().fromJson(sortedCensusData, IplMostRuns[].class);
        String name = censusCsv[0].getPLAYER();
        Assert.assertEquals("David Warner", name); }

    /* Tc 7.1 :Given The Ipl Most Wickets Csv File, Check To Ensure The Number Of Record Matches */
    @Test
    public void givenFilePathGForWickets_WhenNoOfRecordMatches_ThenReturnTrue() {
        int noOfRecords = cricketLeague.readFileForWickets(IPL_MOST_WICKET_SHEET);
        Assert.assertEquals(99, noOfRecords); }

    /* TC 7.2 : Given The Ipl Most Wickets Data when sorted should return sorted data By Bowling Avrages*/
    @Test
    public void givenCricketLeagueData_whenSorted_shouldReturnSortedWithTopBowlingAvg() {
        cricketLeague.readFileForWickets(IPL_MOST_WICKET_SHEET);
        String sortedCensusData = cricketLeague.getSortedWicketsWithBestBowlingAvrages();
        IplMostWickets[] censusCsv = new Gson().fromJson(sortedCensusData, IplMostWickets[].class);
        String name = censusCsv[98].getPLAYER();
        Assert.assertEquals("Anukul Roy", name); }

    /* TC 8 : Given The Ipl Most Wickets Data when sorted should return sorted data By Top Striking Rates*/
    @Test
    public void givenCricketLeagueData_whenSorted_shouldReturnSortedWithTopStrikingRate() {
        cricketLeague.readFileForWickets(IPL_MOST_WICKET_SHEET);
        String sortedCensusData = cricketLeague.getSortedWiseWicketsWithBestStrikingRate();
        IplMostWickets[] censusCsv = new Gson().fromJson(sortedCensusData, IplMostWickets[].class);
        String name = censusCsv[98].getPLAYER();
        Assert.assertEquals("Alzarri Joseph", name); }

    /* TC 9 : Given The Ipl Most Wickets Data when sorted should return sorted data By Top Economy Of Bowler*/
    @Test
    public void givenCricketLeagueData_whenSorted_shouldReturnSortedWithTopEconomy() {
        cricketLeague.readFileForWickets(IPL_MOST_WICKET_SHEET);
        String sortedCensusData = cricketLeague.getSortedWiseWicketsWithBestEconomyRate();
        IplMostWickets[] censusCsv = new Gson().fromJson(sortedCensusData, IplMostWickets[].class);
        String name = censusCsv[98].getPLAYER();
        Assert.assertEquals("Shivam Dube", name); }

    /* TC 10 : Given The Ipl Most Wickets Data when sorted should return Best Striking Rate With 5w And 4w */
    @Test
    public void givenCricketLeagueData_whenSorted_shouldReturnSortedStrikeRate5w4w() {
        cricketLeague.readFileForWickets(IPL_MOST_WICKET_SHEET);
        String sortedCensusData = cricketLeague.getSortedWiseWicketsWithBestStrikingRate5w4W();
        IplMostWickets[] censusCsv = new Gson().fromJson(sortedCensusData, IplMostWickets[].class);
        String name = censusCsv[0].getPLAYER();
        Assert.assertEquals("Krishnappa Gowtham", name); }

    /* TC 11 : Given The Ipl Most Wickets Data when sorted should return sorted data By Top Striking Rates And Avg*/
    @Test
    public void givenCricketLeagueData_whenSorted_shouldReturnSortedWithTopStrikingRateAndAvg() {
        cricketLeague.readFileForWickets(IPL_MOST_WICKET_SHEET);
        String sortedCensusData = cricketLeague.getSortedMaximumWicketsWithBestBowlingAvgBestSR();
        IplMostWickets[] censusCsv = new Gson().fromJson(sortedCensusData, IplMostWickets[].class);
        String name = censusCsv[98].getPLAYER();
        Assert.assertEquals("Anukul Roy", name); }

    /* TC 12 : Given The Ipl Most Wickets Data when sorted should return sorted data By Top Wickets */
    @Test
    public void givenCricketLeagueData_whenSorted_shouldReturnSortedTopWicketsWithBestBowling() {
        cricketLeague.readFileForWickets(IPL_MOST_WICKET_SHEET);
        String sortedCensusData = cricketLeague.getSortedMaximumWicketsWithBestBowlingAvg();
        IplMostWickets[] censusCsv = new Gson().fromJson(sortedCensusData, IplMostWickets[].class);
        String name = censusCsv[0].getPLAYER();
        Assert.assertEquals("Krishnappa Gowtham", name); }

    /* TC 13.1 : Given The Ipl Most Wickets Data when sorted should return sorted data By Bolwing */
    @Test
    public void givenCricketLeagueData_whenSorted_shouldReturnBestBowlingAvg() {
        cricketLeague.readFileForWickets(IPL_MOST_WICKET_SHEET);
        cricketLeague.readFileForRuns(IPL_MOST_RUN_SHEET);
        String sortedCensusData = cricketLeague.getSortedWicketsWithBestBowlingAvrages();
        IplMostWickets[] censusCsv = new Gson().fromJson(sortedCensusData, IplMostWickets[].class);
        String name = censusCsv[98].getPLAYER();
        Assert.assertEquals("Anukul Roy", name); }

    /* TC 13.2 : Given The Ipl Most Wickets Data when sorted should return sorted data By Bolwing */
    @Test
    public void givenCricketLeagueData_whenSorted_shouldReturnBestBattingAvgs() {
        cricketLeague.readFileForRuns(IPL_MOST_RUN_SHEET);
        String sortedData = cricketLeague.getAvrageWiseSorted();
        IplMostRuns[] censusCsvs = new Gson().fromJson(sortedData, IplMostRuns[].class);
        String names = censusCsvs[0].getPLAYER();
        Assert.assertEquals("MS Dhoni", names); }

    /* TC 14 : Given The Ipl Most Wickets Data when sorted should return sorted data By Top Runs */
    @Test
    public void givenCricketLeagueData_whenSorted_shouldReturnBestAllRounder() {
        cricketLeague.readFileForWickets(IPL_MOST_WICKET_SHEET);
        String sortedCensusData = cricketLeague.getSortedWiseWicketsWithBestAllRounder();
        IplMostWickets[] censusCsv = new Gson().fromJson(sortedCensusData, IplMostWickets[].class);
        String name = censusCsv[0].getPLAYER();
        Assert.assertEquals("Deepak Chahar", name); }
}

