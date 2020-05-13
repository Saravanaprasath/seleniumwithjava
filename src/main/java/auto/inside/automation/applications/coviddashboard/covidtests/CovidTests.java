package auto.inside.automation.applications.coviddashboard.covidtests;

import auto.inside.automation.applications.coviddashboard.covid.CovidPage;
import auto.inside.automation.testbase.Base;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class CovidTests extends Base {
    CovidPage covid;

    public CovidTests() {
        covid = PageFactory.initElements(driver, CovidPage.class);
    }

    //Tests
    @Test
    public void openDashboard() {
        covid.goToDashBoard();

    }

    @Test
    public void printStates() throws InterruptedException {
        covid.getStateNames();
        covid.getCount();
    }

    @Test
    public void getCounts() throws InterruptedException {
        covid.getCount();
    }

    @Test
    public void writeData(){
        covid.writeData();
    }
}
