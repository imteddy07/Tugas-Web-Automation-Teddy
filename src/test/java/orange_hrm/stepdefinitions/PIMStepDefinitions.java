package orange_hrm.stepdefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import orange_hrm.pageObjects.HRMPIMPageObjects;
import tasks.ClickOn;
import tasks.InputText;
import tasks.NavigateTo;
import tasks.VerifyDisplayed;

public class PIMStepDefinitions {
    @And("{actor} access employee list")
    public void accessEmployee(Actor actor) throws Exception {
        actor.wasAbleTo(NavigateTo.theURL("HRM Employee List"));
    }
    @And("{actor} can see new employee list result")
    public void listResult(Actor actor) throws Exception {
        actor.attemptsTo(VerifyDisplayed.element("Employee List"));
    }
    @And("{actor} search for new employee")
    public void filterEmployee(Actor actor) throws Exception{
        actor.attemptsTo(InputText.onField("employeeName", "Teddy Aditya"), ClickOn.button("Search"));
    }
    @When("{actor} add new employee with required field only")
    public void addEmployee(Actor actor) throws Exception {
        actor.attemptsTo(
                ClickOn.button("Add"),
                InputText.onField("firstName", "Teddy"),
                InputText.onField("lastName", "Aditya"),
                ClickOn.button("Save")
        );
    }

    @Then("{actor} can see my Personal Details")
    public void personalDetails(Actor actor) throws Exception{
        actor.attemptsTo(VerifyDisplayed.element("Personal Details"));
    }
    @And("{actor} update new employee's middle name")
    public void updateEmployee(Actor actor) throws Exception {
        actor.attemptsTo(
                ClickOn.employeeList(),
                ClickOn.button("Edit"),
                InputText.onField("editMiddleName", "Aditya"),
                ClickOn.button("Save")
        );
    }
    @Then("{actor} can see the Personal Details has changed")
    public void updatedEmployee(Actor actor) {
        actor.attemptsTo(Ensure.that(HRMPIMPageObjects.EDIT_MIDDLE_NAME_FIELD).value().isEqualTo("Aditya"));

    }
    @And("{actor} delete new emplyee")
    public void deleteEmployee(Actor actor) throws Exception {
        actor.attemptsTo(
                ClickOn.checkbox(),
                ClickOn.button("Delete"),
                ClickOn.button("OK")
        );
    }

    @Then("{actor} can deleted new employee")
    public void validateDelete(Actor actor) throws Exception{
        actor.attemptsTo(
                VerifyDisplayed.element("No Employee")
        );
    }
}

