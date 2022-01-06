package co.com.sofka.questions;

import co.com.sofka.models.GetJsonModel;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ResposeQuestionsJson implements Question {


    @Override
    public GetJsonModel answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(GetJsonModel.class);
    }
}
