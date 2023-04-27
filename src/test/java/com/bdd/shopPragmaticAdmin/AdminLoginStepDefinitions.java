package com.bdd.shopPragmaticAdmin;

import com.bdd.utils.BrowserActions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

public class AdminLoginStepDefinitions {
    private static final String LOGIN_ADMIN_URL="https://shop.pragmatic.bg/admin/";
    private static final By LOC_USERNAME=By.id("input-username");
    private static final By LOC_PASSWORD=By.id("input-password");
    private static final By LOC_LOGIN_BUTTON=By.xpath("//button[@class='btn btn-primary']");
    private static final By LOC_LOGOUT_BUTTON = By.xpath("//a[contains(@href, 'logout')]");


    @Given("the user is on the admin login page")
    public void the_user_is_on_the_admin_login_page() {
        BrowserActions.driver.get(LOGIN_ADMIN_URL);
    }

    @When("the user logs in using the username {string} and password{string}")
    public void theUserLogsInUsingTheUsernameAndPassword(String username, String password) {
        BrowserActions.driver.findElement(LOC_USERNAME).sendKeys(username);
        BrowserActions.driver.findElement(LOC_PASSWORD).sendKeys(password);


    }

    @And("the user clicks on the login button")
    public void theUserClicksOnTheLoginButton() {
        BrowserActions.driver.findElement(LOC_LOGIN_BUTTON).click();


    }

    @Then("the user should successfully log in into the admin panel")
    public void theUserShouldSuccessfullyLogInIntoTheAdminPanel() {
        String actualAdminPanelTitle = BrowserActions.driver.getTitle();
        Assert.assertEquals(actualAdminPanelTitle,"Dashboard", "The login was not successful!!!");

    }
    @And("the user logs out via logout button")
    public void theUserLogsOutViaLogoutButton() {
        BrowserActions.driver.findElement(LOC_LOGOUT_BUTTON).click();
    }
}
