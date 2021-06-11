package com.bdd.BDDFundTransfer;

import Core.BaseTest;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class FundTransferStepDefinitions extends BaseTest {
    private WebDriver driver;


    @Given("the user is on Fund Transfer Page")
    public void the_user_is_on_Fund_Transfer_Page() {
        driver.get("http://pragmatic.bg/automation/lecture15/fundTransfer.html");
    }

    @When("he enters {string} as payee name")
    public void he_enters_as_payee_name(String payeeName) {
        WebElement payeeWebElement = driver.findElement(By.id("payee"));
        Select payeeDropDown = new Select(payeeWebElement);
        payeeDropDown.selectByVisibleText(payeeName);
    }

    @When("he enters {string} as amount")
    public void he_enters_as_amount(String amount) {
        WebElement amountInputField = driver.findElement(By.id("amount"));
        amountInputField.sendKeys(amount);
    }

    @When("he Submits request for Fund Transfer")
    public void he_Submits_request_for_Fund_Transfer() {
        driver.findElement(By.id("transfer")).click();
    }

    @Then("ensure the fund transfer is complete with {string} message")
    public void ensure_the_fund_transfer_is_complete_with_message(String expectedFundTransferSuccessMessage) {
        Assert.assertEquals(driver.findElement(By.id("message")).getText(), expectedFundTransferSuccessMessage, "bug beeee");
    }

    @Then("ensure a transaction failure message {string} is displayed")
    public void ensure_a_transaction_failure_message_is_displayed(String expectedFundTransferFailureMessage) {
        Assert.assertEquals(driver.findElement(By.id("message")).getText(), expectedFundTransferFailureMessage, "bug beeee");

    }



}
