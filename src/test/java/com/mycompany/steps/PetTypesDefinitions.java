package com.mycompany.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.Matchers.*;

public class PetTypesDefinitions {

    @Given("cliente con recurso {string}, query {string}, header {string}")
    public void cliente_con_recurso_query_header(String basePath, String queryParam, String contentType) {
        var queryParts = queryParam.split("=", 2);
        var queryKey = queryParts[0];
        var queryValue = queryParts[1];
        given()
                .basePath(basePath)
                .queryParam(queryKey, queryValue)
                .contentType(contentType);
    }

    @Given("el cliente tiene configurado el recurso {string} con header {string}")
    public void el_cliente_tiene_configurado_el_recurso_con_header(String basePath, String contentType) {
        given()
                .basePath(basePath)
                .contentType(contentType);
    }

    @When("el cliente hace una solicitud GET")
    public void el_cliente_hace_una_solicitud_get() {
        when().get().andReturn();
    }

    @Then("el servidor debe de responder con un status {int}")
    public void el_servidor_debe_de_responder_con_un_status(Integer statusCode) {
        then().statusCode(statusCode);
    }

    @Then("el cuerpo de la respuesta debe de ser una lista de tipos de mascotas")
    public void el_cuerpo_de_la_respuesta_debe_de_ser_una_lista_de_tipos_de_mascotas() {
        then().body("$", not(empty()));
        then().body("size()", greaterThan(0));
//        then().body("size()", is(6));
//        then().body("size()", hasSize(100));
//        then().body("[0].id", notNullValue());
//        then().body("[0].name", notNullValue());
//        then().body("id", notNullValue(), "name", notNullValue());
//        then().body("id", everyItem(notNullValue()));
//        then().body("name", everyItem(notNullValue()));
    }

    @Then("el cuerpo de la respuesta contiene la propiedad id con el valor {int}")
    public void el_cuerpo_de_la_respuesta_contiene_la_propiedad_id_con_el_valor(Integer id) {
        then().body("id", is(id));
    }
    @Then("el cuerpo de la respuesta contiene la propiedad name con el valor {string}")
    public void el_cuerpo_de_la_respuesta_contiene_la_propiedad_name_con_el_valor(String name) {
        then().body("name", is(name));
    }
}
