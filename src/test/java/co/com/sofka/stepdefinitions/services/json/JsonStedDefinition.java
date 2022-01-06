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

    public static Logger LOGGER = Logger.getLogger(ReqresStepDefinition.class);

    @Given("el Usuario está en la Url https:\\/\\/jsonplaceholder.typicode.com\\/ y desea eliminar informacion de usuario.")
    public void elUsuarioEstáEnLaUrlHttpsJsonplaceholderTypicodeComYDeseaEliminarInformacionDeUsuario() {
        super.setUpJson();
        LOGGER.info("** Inicio primer scenario de Json");
    }

    @When("cuando el Usuario realiza la peticion de eliminado  de usuario")
    public void cuandoElUsuarioRealizaLaPeticionDeEliminadoDeUsuario() {
        actor.attemptsTo(doGet().withTheResource(RESOURSE_JON));
        LOGGER.info("** Inicio peticion");
    }
    @Then("el Usuario deberá ver un codigo de respuesta de usuario eliminado")
    public void elUsuarioDeberáVerUnCodigoDeRespuestaDeUsuarioEliminado() {
        actor.should(seeThat("Codigo de respuesta", ResponseStatusCode.was(), equalTo(200))

        );
        LOGGER.info("** Verificacion scenario 1");
    }

    @Given("el Cliente está en la Url https://jsonplaceholder.typicode.com/ y Busca el usuario")
    public void elClienteEstáEnLaUrlHttpsReqresInYBuscaElUsuario() {
        super.setUpJson();
        LOGGER.info("** Inicio segundo scenario de Json");
    }

    @When("cuando el cliente realiza la peticion de busqueda  de usuario selecionado")
    public void cuandoElClienteRealizaLaPeticionDeBusquedaDeUsuario() {
        actor.attemptsTo(doGet().withTheResource(RESOURSE_JON));
        LOGGER.info("** Inicio peticion");
    }
    @Then("el cliente deberá ver un codigo de respuesta de usuario es encontrado")
    public void elClienteDeberáVerUnCodigoDeRespuestaDeUsuarioEsEncontrado() {
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
        LOGGER.info("Verificacion scenario 2 Reqres");
    }



}
