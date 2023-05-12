package statements;

import Requests.TypeRequests;

public class DeletarSimulacao {

    TypeRequests requests = new TypeRequests();

    public void deletarSimulacao (int id) {
        requests.deletarSimulacao(id);
    }
}
