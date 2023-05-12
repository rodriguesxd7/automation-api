package Requests;

import io.restassured.RestAssured;
import org.json.JSONObject;
import suporte.*;

public class TypeRequests {

   public static final String uri = "http://localhost:8080/api/v1/";
   String response;

    public void criarSimulacao(JSONObject obj, int status) throws AssertionError {
        try {
            response = RestAssured
                    .given()
                    .contentType("application/json")
                    .body(obj.toString())
                    .when()
                    .post(uri + "simulacoes")
                    .then()
                    .statusCode(status)
                    .extract()
                    .response().getBody().asString();
        } catch (AssertionError e) {
            System.out.println("Ocorreu uma excecao: " + e + " ao executar o post");
        }

        DataController.getData().put("DADOS", response);
    }

    public void consultarCPF(String cpf, int status) {
        try {
            response = RestAssured
                    .given()
                    .contentType("application/json")
                    .when()
                    .get(uri + "simulacoes/" + cpf)
                    .then()
                    .statusCode(status)
                    .extract()
                    .response().getBody().asString();
        } catch (AssertionError e) {
            System.out.println("Ocorreu uma excecao: " + e + " ao executar o get");
        }

        DataController.getData().put("DADOS", response);
    }

    public void alterarSimulacao(JSONObject obj, String cpf, int status) {
        try {
            response = RestAssured
                    .given()
                    .contentType("application/json")
                    .body(obj.toString())
                    .when()
                    .put(uri + "simulacoes/" + cpf)
                    .then()
                    .statusCode(status)
                    .extract()
                    .response().getBody().asString();
        } catch (AssertionError e) {
            System.out.println("Ocorreu uma excecao: " + e + " ao executar o put");
        }

        DataController.getData().put("DADOS", response);
    }

    public void deletarSimulacao(int id) {
        try {
            response = RestAssured
                    .given()
                    .contentType("application/json")
                    .when()
                    .delete(uri + "simulacoes/" + id)
                    .then()
                    .statusCode(200)
                    .extract()
                    .response().getBody().asString();
        } catch (AssertionError e) {
            System.out.println("Ocorreu uma excecao: " + e + " ao executar o delete");
        }

        DataController.getData().put("DADOS", response);
    }

    public void consultarRestricao(String cpf, int status) {
        try {
            response = RestAssured
                    .given()
                    .contentType("application/json")
                    .when()
                    .get(uri + "restricoes/" + cpf)
                    .then()
                    .statusCode(status)
                    .extract()
                    .response().getBody().asString();
        } catch (AssertionError e) {
            System.out.println("Ocorreu uma excecao: " + e + " ao executar o get");
        }

        DataController.getData().put("DADOS", response);
    }
}
