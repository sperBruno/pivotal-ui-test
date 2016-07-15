package com.fundacionjala.pivotal.cucumber.stepdefinition.projects;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import static com.fundacionjala.pivotal.pages.SettingSteps.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by BrunoBarrios on 7/7/2016.
 */
public class ProjectAssert {

    private ProjectsStepDef projectsStepDef;

    private ProjectSettingsStepDef projectSettingsStepDef;

    public ProjectAssert(ProjectsStepDef projectsStepDef, ProjectSettingsStepDef projectSettingsStepDef) {
        this.projectsStepDef = projectsStepDef;
        this.projectSettingsStepDef = projectSettingsStepDef;
    }

    @And("^Validate all setting projects$")
    public void validateAllSettingProjects() {
        projectSettingsStepDef.getValuesMap().keySet().stream().forEach((step) -> {
            assertEquals(projectSettingsStepDef.getGeneralSettingForm().getAssertionMap().get(step), projectSettingsStepDef.getValuesMap().get(step));
        });
    }

    @Then("^I expect a message say (.*)$")
    public void iExpectAMessageChangeSaved(String messageSay) {
        assertEquals(messageSay, projectSettingsStepDef.getGeneralSettingForm().getMessageTest());
    }


}
