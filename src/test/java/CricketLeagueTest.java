import com.bl.cricketleague.CricketLeague;
import com.bl.cricketleague.exception.CricketLeagueException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.bl.cricketleague.FilePaths.IPL_MOST_RUN_SHEET;

public class CricketLeagueTest
{
    CricketLeague cricketLeague;

    @Before
    public void setup()
    {
        cricketLeague=new CricketLeague();
    }

    /* Tc 1.1 :Given The Ipl Most Run Csv File, Check To Ensure The Number Of Record Matches */
    @Test
    public void givenFilePath_WhenNoOfRecordMatches_ThenReturnTrue()
    {
            int noOfRecords=cricketLeague.readFile(IPL_MOST_RUN_SHEET);
            Assert.assertEquals(100,noOfRecords);
    }

}
