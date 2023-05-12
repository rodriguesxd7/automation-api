package statements;
import Requests.TypeRequests;
import org.json.JSONArray;
import org.json.JSONObject;
import suporte.DataController;

public class ConsultarSimulacao {

    TypeRequests req = new TypeRequests();

    public void consultarRestricao(String cpf, int status) {
        req.consultarRestricao(cpf, status);
    }

    public void consultarCPF (String cpf, int status) {
        req.consultarCPF(cpf, status);
    }

    public void validaCamposRestricao() {
        String fields[] = {"mensagem"};
        JSONObject obj = new JSONObject(DataController.getData().get("DADOS"));

        for (int i = 0; i < obj.length(); i++) {
            if (obj.has(fields[i])) {
                System.out.println("O campo: " + fields[i] + " foi encontrado - Valor: " + obj.get(fields[i]));
            } else {
                System.out.println("O campo: " + fields[i] + " nao foi encontrado");
            }
        }
    }

    public void validaCampos() {
        String fields[] = {"id", "nome", "cpf", "email", "valor", "parcelas", "seguro"};
        JSONObject obj = new JSONObject(DataController.getData().get("DADOS"));

        for (int i = 0; i < obj.length(); i++) {
            if (obj.has(fields[i])) {
                System.out.println("O campo: " + fields[i] + " foi encontrado - Valor: " + obj.get(fields[i]));
            } else {
                System.out.println("O campo: " + fields[i] + " nao foi encontrado");
            }
        }
    }

    public void validaCamposArray() {
        String fields[] = {"id", "nome", "cpf", "email", "valor", "parcelas", "seguro"};
        JSONArray array = new JSONArray(DataController.getData().get("DADOS"));

        for (int j = 0; j < array.length(); j++) {
            JSONObject obj = array.getJSONObject(j);

            for (String field : fields) {
                if (obj.has(field)) {
                    Object value = obj.get(field);
                    System.out.println("O campo: " + field + " foi encontrado - Valor: " + value);
                } else {
                    System.out.println("O campo: " + field + " não foi encontrado");
                }
            }
        }
    }
}
