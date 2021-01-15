package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;

import java.util.concurrent.TimeUnit;

public class MainPageTests  extends TestBase{
    ChromeDriver wd;

    MainPage mainPage;

    @BeforeMethod
    public void setUp(){
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        wd.get("http://test70.lowcoststrip.com/places/tabs/discover");
    }

    @Test(priority = 2, groups = {"UI"})

    public void sloganValidationTest(){
        String text = "CheapTrip. Pay less, travel more";
        assert mainPage.isSloganContainsText(text);
    }

    @Test(priority = 1, groups = {"functional"})
    public void changelanguageValidationTest() throws InterruptedException{
        mainPage.selectRussianLanguage();
        Thread.sleep(500);
        assert mainPage.isLanguageOnPageRussian();
    }



}
