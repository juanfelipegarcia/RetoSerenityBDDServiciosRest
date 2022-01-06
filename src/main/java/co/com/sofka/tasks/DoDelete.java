package co.com.sofka.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;

public class DoDelete implements Task {

    private String resource;

    public DoDelete withTheResource(String resource) {
        this.resource = resource;
        return this;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Delete.from(resource)
                        .with(
                                requestSpecification -> requestSpecification.contentType(ContentType.JSON)
                                        .relaxedHTTPSValidation()
                        )
        );
    }

    public static DoDelete doDelete(){
        return new DoDelete();
    }

}

