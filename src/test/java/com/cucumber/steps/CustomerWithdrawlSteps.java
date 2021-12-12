package com.cucumber.steps;

import com.bank.pages.AccountPage;
import com.bank.utility.Utility;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class CustomerWithdrawlSteps extends Utility {
    @And("^Customer clicks on 'Withdraw' Tab$")
    public void customerClicksOnWithdrawTab() {
        new AccountPage().clickOnWithdrawlTab();
    }

    @And("^Customer enter withdrawl amount \"([^\"]*)\"$")
    public void customerEnterWithdrawlAmount(String withdrawlAmount) {
        pmwaitWithThreadSleep(10);
        new AccountPage().enterWithdrawlAmount("50");
    }

    @And("^Customer clicks on 'Withdraw' button$")
    public void customerClicksOnWithdrawButton() {
        pmwaitWithThreadSleep(10);
        new AccountPage().clickOnWithdrawlButton();
    }

    @Then("^Customer has successfully withdrawn requirement amount$")
    public void customerHasSuccessfullyWithdrawnRequirementAmount() {
        pmwaitWithThreadSleep(10);
        new AccountPage().verifyTransactionSuccessfulMessage();
    }
}
