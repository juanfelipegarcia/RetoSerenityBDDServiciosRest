package co.com.sofka.runners.services.rest;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/services/rest/reqres/Post.feature",
                    "src/test/resources/features/services/rest/reqres/Get.feature",
                    "src/test/resources/features/services/rest/json/Delete.feature",
                    "src/test/resources/features/services/rest/json/Get.feature"},
        glue = {"co.com.sofka.stepdefinitions.services.reqres",
                "co.com.sofka.stepdefinitions.services.json"}
)

public class RestCucumber {
}
