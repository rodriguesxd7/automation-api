package statements;

import Requests.TypeRequests;
import org.json.JSONObject;

import java.io.IOException;

public class AlterarSimulacao {

    TypeRequests requests = new TypeRequests();

    public void alterarSimulacao (String cpf, int valor, int status) {
        JSONObject obj = new JSONObject();
        obj.put("nome", "Fulano");
        obj.put("cpf", cpf);
        obj.put("email", "bruno.rodrigues@gmail.com");
        obj.put("valor", valor);
        obj.put("parcelas", "3");
        obj.put("seguro", true);

        requests.alterarSimulacao(obj, cpf, status);
    }
}
