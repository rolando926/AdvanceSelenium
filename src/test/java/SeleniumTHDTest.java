import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by RXC8414 on 2/21/2017.
 */
public class SeleniumTHDTest{

    Overlay util = new Overlay();

    @BeforeClass
    public void setUp(){
        //navigate to THD
        Assert.assertTrue(util.navigateURL("http://www.homedepot.com",util.headerSearch),"Error: ");
    }

    @Test
    public void verifyCanSearchItem(){
        //Search for item = hammer
        Assert.assertTrue(util.verifyCanSearchByItem("hammer"),"Error: ");

        //Verify landing Page
        Assert.assertTrue(util.verifyLandPageHammer(),"Error: ");

        //Select hammer with 15 < price > 10
        Assert.assertTrue(util.verifyCanSelectItem(),"Error: ");

        //Validate Overlay
        Assert.assertTrue(util.verifyOverlay(),"Error: ");
    }

    @AfterClass
    public void cleanUp(){
        util.closeDriver();
    }
}