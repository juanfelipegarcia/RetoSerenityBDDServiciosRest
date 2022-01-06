package co.com.sofka.stepdefinitions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

public class ServiceSetup {
    protected static final String URL_BASE_REQRES = "https://reqres.in";
    protected static final String RESOURSE_REQRES1 = "/api/user/23";
    protected static final String RESOURSE_REQRES2 = "/api/register";
    protected static final String URL_BASE_JSON = "https://jsonplaceholder.typicode.com";
    protected static final String RESOURSE_JON = "/posts/1";
    protected static final String RESOURSE_JON2 = "/posts";


    protected Actor actor = new Actor("felipe");

    protected void setUpReqres(){
        actorCanReqres();
    }
    private void actorCanReqres(){
        actor.can(CallAnApi.at(URL_BASE_REQRES));
    }
    protected void setUpJson(){
        actorCanJson();
    }
    private void actorCanJson(){
        actor.can(CallAnApi.at(URL_BASE_JSON));
    }


}
