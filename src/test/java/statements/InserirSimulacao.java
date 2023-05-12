package statements;

import Requests.TypeRequests;
import org.json.JSONObject;
import suporte.DataController;

public class InserirSimulacao {

    TypeRequests requests = new TypeRequests();

    public void novaSimulacao (int status) {
        JSONObject obj = new JSONObject();
        obj.put("nome", "Fulano");
        obj.put("cpf", 63254196987L);
        obj.put("email", "bruno.rodrigues@gmail.com");
        obj.put("valor", 5000);
        obj.put("parcelas", 5);
        obj.put("seguro", true);

        requests.criarSimulacao(obj, status);
    }

    public void novaSimulacaoDuplicada (int status) {
        JSONObject obj = new JSONObject();
        obj.put("nome", "Fulano");
        obj.put("cpf", 63254196587L);
        obj.put("email", "bruno.rodrigues@gmail.com");
        obj.put("valor", 5000);
        obj.put("parcelas", 5);
        obj.put("seguro", true);

        requests.criarSimulacao(obj, status);
    }

    public void novaSimulacaoComCampoFaltando (int status) {
        JSONObject obj = new JSONObject();
        obj.put("nome", "Fulano");
        obj.put("cpf", 63254196587L);
        obj.put("email", "bruno.rodrigues@gmail.com");
        obj.put("valor", 5000);
        obj.put("parcelas", 5);

        requests.criarSimulacao(obj, status);
    }

    public void novaSimulacaoComParcelaMenorQueDois (int status, int parcelas) {
        JSONObject obj = new JSONObject();
        obj.put("nome", "Fulano");
        obj.put("cpf", "15935798765");
        obj.put("email", "bruno.rodrigues@gmail.com");
        obj.put("valor", "5000");
        obj.put("parcelas", parcelas);
        obj.put("seguro", true);

        requests.criarSimulacao(obj, status);
    }

    public void novaSimulacaoComMarioQueQuarentaMil (int status, int valor) {
        JSONObject obj = new JSONObject();
        obj.put("nome", "Fulano");
        obj.put("cpf", "25795135123");
        obj.put("email", "bruno.rodrigues@gmail.com");
        obj.put("valor", valor);
        obj.put("parcelas", "3");
        obj.put("seguro", true);

        requests.criarSimulacao(obj, status);
    }

    public void validarMsgDeErro() {
        String fields[] = {"erros"};
        JSONObject obj = new JSONObject(DataController.getData().get("DADOS"));

        for (int i = 0; i < obj.length(); i++) {
            if (obj.has(fields[i])) {
                System.out.println("O campo: " + fields[i] + " foi encontrado - Valor: " + obj.get(fields[i]));
            } else {
                System.out.println("O campo: " + fields[i] + " nao foi encontrado");
            }
        }
    }
}
