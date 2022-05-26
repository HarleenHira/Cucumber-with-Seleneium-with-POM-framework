package steps;

import com.pages.AccountPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class AcountPageSteps {
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private AccountPage accountPage;

    @Given("User has already logged in to application")
    public void user_has_already_logged_in_to_application(DataTable dataTable) {
        List<Map<String, String>> credList = dataTable.asMaps();
        String username = credList.get(0).get("username");
        String password = credList.get(0).get("password");
        DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        accountPage = loginPage.doLogin(username, password);
    }

    @Given("user is on accounts page")
    public void user_is_on_accounts_page() {
        String title=accountPage.getAccountPageTitle();
        System.out.println("the title is "+title);
    }

    @Then("user gets accounts section")
    public void user_gets_accounts_section(DataTable sectionsTable) {
        List<String> expectedAccountSectionsList = sectionsTable.asList();
        System.out.println("ExpectedList " + expectedAccountSectionsList);
        List<String> actualAccountList = accountPage.getAccountsList();
        System.out.println("Actual list" + actualAccountList);
        Assert.assertTrue(expectedAccountSectionsList.containsAll(actualAccountList));
    }

    @Then("Account section count should be {int}")
    public void account_section_count_should_be(Integer expectedSectionCount) {
        Assert.assertTrue(accountPage.getAccountsSectionCount() == expectedSectionCount);
    }

}
