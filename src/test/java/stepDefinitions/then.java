package stepDefinitions;
import io.cucumber.java.pt.Entao;
import org.json.JSONObject;
import org.junit.Assert;
import statements.ConsultarSimulacao;
import statements.DeletarSimulacao;
import statements.InserirSimulacao;
import suporte.DataController;

import javax.xml.crypto.Data;

public class then {

    ConsultarSimulacao cpf = new ConsultarSimulacao();
    InserirSimulacao inserir = new InserirSimulacao();
    DeletarSimulacao deletar = new DeletarSimulacao();

    @Entao("o endpoint irá retornar uma mensagem se o cliente possui ou nao uma restrição")
    public void o_endpoint_irá_retornar_uma_mensagem_se_o_cliente_possui_ou_nao_uma_restrição() {
        cpf.validaCamposRestricao();
        System.out.println("finalizando");
    }

    @Entao("o endpoint irá retornar uma mensagem <msg> dizendo que o CPF está duplicado")
    public void o_endpoint_irá_retornar_uma_mensagem_msg_dizendo_que_o_cpf_está_duplicado() {
        cpf.validaCamposRestricao();
    }

    @Entao("o endpoint irá retornar uma mensagem dizendo que o cliente não está cadastrado na base com a mensagem {string}")
    public void o_endpoint_irá_retornar_uma_mensagem_dizendo_que_o_cliente_não_está_cadastrado_na_base_com_a_mensagem_msg_msg(String msg) {
        cpf.validaCamposRestricao();
        String dados = DataController.getData().get("DADOS").substring(13, 43);
        Assert.assertEquals(msg, dados);
    }

    @Entao("o endpoint irá retornar todas as simulações cadastradas")
    public void o_endpoint_irá_retornar_todas_as_simulações_cadastradas() {
        cpf.validaCamposArray();
    }

    @Entao("o endpoint irá retornar os dados da simulação")
    public void o_endpoint_irá_retornar_os_dados_da_simulação() {
        cpf.validaCampos();
        JSONObject obj = new JSONObject(DataController.getData().get("DADOS"));
        int id = 0;
        if(obj.has("id")) {
            id = obj.getInt("id");
            deletar.deletarSimulacao(id);
            cpf.consultarCPF(obj.get("cpf").toString(), 404);
            System.out.println("CPF foi inserido validado e deletado");
        }
    }

    @Entao("o endpoint irá retornar status e um erro")
    public void o_endpoint_irá_retornar_status_e_um_erro() {
        System.out.println("Finalizando execução");
    }

    @Entao("o endpoint irá retornar as informacoes do cpf")
    public void o_endpoint_irá_retornar_as_informacoes_do_cpf() {
        cpf.validaCampos();

    }

    @Entao("o endpoint irá retornar a mensagem {string} de erro")
    public void o_endpoint_irá_retornar_a_mensagem_de_erro(String msg) {
        inserir.validarMsgDeErro();
    }

    @Entao("o endpoint irá retornar uma nova simulacao")
    public void o_endpoint_irá_retornar_uma_nova_simulacao() {
        cpf.validaCampos();
    }

    @Entao("o endpoint irá retornar o status {int}")
    public void o_endpoint_irá_retornar_o_status(Integer int1) {
        System.out.println("finalizando execucao");
    }
}
