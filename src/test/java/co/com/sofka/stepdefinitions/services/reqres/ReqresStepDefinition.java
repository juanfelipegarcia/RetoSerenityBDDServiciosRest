package co.com.sofka.stepdefinitions.services.reqres;

import co.com.sofka.models.PostReqresModel;
import co.com.sofka.questions.ResponseStatusCode;
import co.com.sofka.questions.ResposeQuestionsReqres;
import co.com.sofka.stepdefinitions.ServiceSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;

import static co.com.sofka.tasks.DoGet.doGet;
import static co.com.sofka.tasks.DoPost.doPost;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class ReqresStepDefinition extends ServiceSetup {

    public static Logger LOGGER = Logger.getLogger(ReqresStepDefinition.class);
    private PostReqresModel postReqresModel;

    private String correo;
    private String password;

    //Scenario Nº 1
    @Given("el Cliente está en la Url https://reqres.in/ y Busca el usuario Veintitres.")
    public void elClienteEstaEnLaUrlHttpsReqresInYBuscaElUsuarioVeintitres() {
        try {
            super.setUpReqres();
            LOGGER.info("Inicio primer scenario de Reqres");
        }catch (Exception e){
            LOGGER.error(e);
            LOGGER.info("Error en el inicio del primer Scenario Reqres GET");
        }
    }

    @When("cuando el cliente realiza la peticion de busqueda  de usuario")
    public void cuandoElClienteRealizaLaPeticionDeBusquedaDeUsuario() {
        try {
            actor.attemptsTo(doGet().withTheResource(RESOURSE_REQRES1));
            LOGGER.info("Inicio peticion Reqres");
        }catch (Exception e){
            LOGGER.error(e);
            LOGGER.info("Error en el inicio del primer Scenario Reqres GET");
        }
    }
    @Then("el cliente deberá ver un codigo de respuesta de usuario no encontrado")
    public void elClienteDeberaVerUnCodigoDeRespuestaDeUsuarioNoEncontrado() {
        try {
            actor.should(seeThat("Codigo de respuesta", ResponseStatusCode.was(), equalTo(404)));
            LOGGER.info("Verificacion scenario 1 Reqres");
        }catch (Exception e){
            LOGGER.error(e);
            LOGGER.info("Error en el inicio del primer Scenario Reqres GET");
        }
    }

    //Scenario Nº 2
    @Given("el Cliente está en la Url https:\\/\\/reqres.in\\/ y digita su usuario {string} y contraseña {string}")
    public void elClienteEstaEnLaUrlHttpsReqresInYDigitaSuUsuarioYContrasenna(String usuario, String password) {
        try {
            super.setUpReqres();
            correo = usuario;
            this.password = password;
            LOGGER.info("Inicio Segundo scenario de Reqres");
        }catch (Exception e){
            LOGGER.error(e);
            LOGGER.info("Error en el inicio del primer Scenario Reqres GET");
        }
    }

    @When("cuando el cliente realiza la peticion de creacion de usuario")
    public void cuandoElClienteRealizaLaPeticionDeCreacionDeUsuario() {
        try {
            actor.attemptsTo(doPost()
                    .withTheResource(RESOURSE_REQRES2)
                    .andTheBodyRequest(bodyRequestReqres())
                );
            LOGGER.info("Inicio peticion Reqres");
        }catch (Exception e){
            LOGGER.error(e);
            LOGGER.info("Error en el inicio del primer Scenario Reqres GET");
        }
    }

    @Then("el cliente deberá ver un codigo de respuesta éxitoso y los datos creados")
    public void elClienteDeberaVerUnCodigoDeRespuestaExitosoYLosDatosCreados() {
        try {
            actor.should(
                    seeThat("El codigo de respuesta :", ResponseStatusCode
                            .was(), equalTo(200)),
                    seeThat("el ID esperado es: ",
                            info -> new ResposeQuestionsReqres().answeredBy(actor).getId(),
                            equalTo(4))
                );
            LOGGER.info("Verificacion scenario 2 Reqres");
        }catch (Exception e){
            LOGGER.error(e);
            LOGGER.info("Error en el inicio del primer Scenario Reqres GET");
        }
    }

    private String bodyRequestReqres(){
        return "{\n" +
                "    \"email\": \""+correo+"\",\n" +
                "    \"password\": \""+password+"\"\n" +
                "}";
    }




}
