package pages;

import base.BasePageWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultsSearchPageWebDriver extends BasePageWebDriver {
    public ResultsSearchPageWebDriver(WebDriver driver) {
        super(driver);
    }
    public void checkOpenResultsSearchPage(){
        isElementDisplayed(By.xpath("(//a[@href='/search/Film?q=мир'])[1]"));
        isElementDisplayed(By.xpath("(//a[@href='/search/Series?q=мир'])[1]"));
        isElementDisplayed(By.xpath("(//a[@href='/search/Channel?q=мир'])[1]"));
        isElementDisplayed(By.xpath("(//a[@href='/search/Programme?q=мир'])[1]"));
    }
}
