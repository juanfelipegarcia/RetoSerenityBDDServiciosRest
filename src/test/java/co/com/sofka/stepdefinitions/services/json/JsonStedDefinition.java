package co.com.sofka.stepdefinitions.services.json;

import co.com.sofka.questions.ResponseStatusCode;
import co.com.sofka.questions.ResposeQuestionsJson;
import co.com.sofka.questions.ResposeQuestionsReqres;
import co.com.sofka.stepdefinitions.ServiceSetup;
import co.com.sofka.stepdefinitions.services.reqres.ReqresStepDefinition;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;

import static co.com.sofka.tasks.DoGet.doGet;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class JsonStedDefinition extends ServiceSetup {

    public static Logger LOGGER = Logger.getLogger(JsonStedDefinition.class);

    @Given("el Usuario está en la Url https:\\/\\/jsonplaceholder.typicode.com\\/ y desea eliminar informacion de usuario.")
    public void elUsuarioEstáEnLaUrlHttpsJsonplaceholderTypicodeComYDeseaEliminarInformacionDeUsuario() {
        try {
            super.setUpJson();
            LOGGER.info("** Inicio primer scenario de Json");
        }catch (Exception e){
            LOGGER.error(e);
            LOGGER.info("Error en el inicio del primer Scenario Json");
        }
    }

    @When("cuando el Usuario realiza la peticion de eliminado  de usuario")
    public void cuandoElUsuarioRealizaLaPeticionDeEliminadoDeUsuario() {
        try {
            actor.attemptsTo(doGet().withTheResource(RESOURSE_JON));
            LOGGER.info("** Inicio peticion");
        }catch (Exception e){
            LOGGER.error(e);
            LOGGER.info("Error en el inicio del primer Scenario Json");
        }

    }
    @Then("el Usuario deberá ver un codigo de respuesta de usuario eliminado")
    public void elUsuarioDeberáVerUnCodigoDeRespuestaDeUsuarioEliminado() {
        try {
            actor.should(seeThat("Codigo de respuesta", ResponseStatusCode.was(), equalTo(200))
                        );
            LOGGER.info("** Verificacion scenario 1");
        }catch (Exception e){
            LOGGER.error(e);
            LOGGER.info("Error en el inicio del primer Scenario Json");
        }

    }

    @Given("el Cliente está en la Url https://jsonplaceholder.typicode.com/ y Busca el usuario")
    public void elClienteEstáEnLaUrlHttpsReqresInYBuscaElUsuario() {
        try {
            super.setUpJson();
            LOGGER.info("** Inicio segundo scenario de Json");
        }catch (Exception e){
            LOGGER.error(e);
            LOGGER.info("Error en el inicio del segundo Scenario Json");
        }
    }

    @When("cuando el cliente realiza la peticion de busqueda  de usuario selecionado")
    public void cuandoElClienteRealizaLaPeticionDeBusquedaDeUsuario() {
        try {
            actor.attemptsTo(doGet().withTheResource(RESOURSE_JON));
            LOGGER.info("** Inicio peticion");
        }catch (Exception e){
            LOGGER.error(e);
            LOGGER.info("Error en el inicio del primer Scenario Json");
        }
    }
    @Then("el cliente deberá ver un codigo de respuesta de usuario es encontrado")
    public void elClienteDeberáVerUnCodigoDeRespuestaDeUsuarioEsEncontrado() {
        try {
            actor.should(
                    seeThat("El codigo de respuesta :", ResponseStatusCode
                            .was(), equalTo(200)),
                    seeThat("el User ID esperado es: ",
                            info -> new ResposeQuestionsJson().answeredBy(actor).getUserId(),
                            equalTo(1)),
                    seeThat("el ID esperado es: ",
                            info -> new ResposeQuestionsJson().answeredBy(actor).getId(),
                            equalTo(1)),
                    seeThat("el title esperado es: ",
                            info -> new ResposeQuestionsJson().answeredBy(actor).getTitle(),
                            equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"))
            );
            LOGGER.info("Verificacion scenario 2 Json");
        }catch (Exception e){
            LOGGER.error(e);
            LOGGER.info("Error en el inicio del primer Scenario Json");
        }
    }

}


