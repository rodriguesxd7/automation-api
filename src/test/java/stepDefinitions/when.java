package stepDefinitions;
import io.cucumber.java.pt.Quando;
import statements.AlterarSimulacao;
import statements.ConsultarSimulacao;
import statements.DeletarSimulacao;
import statements.InserirSimulacao;

public class when {

    ConsultarSimulacao cpf = new ConsultarSimulacao();
    InserirSimulacao inserir = new InserirSimulacao();
    AlterarSimulacao alterar = new AlterarSimulacao();
    DeletarSimulacao deletar = new DeletarSimulacao();

    @Quando("eu realizar uma chamada GET no endpoint apiv1restricoescpf passando o CPF {string} retornando o status {int}")
    public void eu_realizar_uma_chamada_get_no_endpoint_apiv1restricoescpf_passando_o_cpf_cpf_retornando_o_status_status(String user, int status) {
        cpf.consultarRestricao(user, status);
    }

    @Quando("eu realizar uma chamada GET no endpoint apiv1simulacoescpf passando o CPF {string} retornando o status {int}")
    public void eu_realizar_uma_chamada_get_no_endpoint_apiv1simulacoescpf_passando_o_cpf_cpf_retornando_o_status_status(String user, int status) {
        cpf.consultarCPF(user, status);
    }


    @Quando("eu realizar uma chamada PUT no endpoint apiv1simulacoes")
    public void eu_realizar_uma_chamada_put_no_endpoint_api_v1_simulacoes() {

    }

    @Quando("alterar o cpf {string} com o valor {int} com status {int}")
    public void alterar_o_cpf_com_o_valor_com_status(String cpf, int valor, int status) {
        alterar.alterarSimulacao(cpf, valor, status);
    }

    @Quando("eu realizar uma chamada GET no endpoint apiv1simulacoes retornando status {int}")
    public void eu_realizar_uma_chamada_get_no_endpoint_api_v1_simulacoes_retornando_status_status(int status) {
        cpf.consultarCPF("", status);
    }

    @Quando("eu realizar uma chamada POST no endpoint apiv1simulacoes {int}")
    public void eu_realizar_uma_chamada_post_no_endpoint_api_v1_simulacoes_status(int status) {
        inserir.novaSimulacao(status);
    }

    @Quando("eu realizar uma chamada POST no endpoint apiv1simulacoes com um campo a menos {int}")
    public void eu_realizar_uma_chamada_post_no_endpoint_apiv1simulacoes_com_um_campo_a_menos(int status) {
        inserir.novaSimulacaoComCampoFaltando(status);
    }

    @Quando("eu realizar uma chamada POST no endpoint apiv1simulacoes cpf duplicado {int}")
    public void eu_realizar_uma_chamada_post_no_endpoint_apiv1simulacoes_cpf_duplicado(int status) {
        inserir.novaSimulacaoDuplicada(status);
    }

    @Quando("passar os dados corretos mas faltando um campo no body")
    public void passar_os_dados_corretos_mas_faltando_um_campo_no_body() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Quando("no body passar uma parcela {int} menor que dois com retorno do status {int}")
    public void no_body_passar_uma_parcela_menor_que_dois_com_retorno_do_status(Integer parcela, Integer status) {
        inserir.novaSimulacaoComParcelaMenorQueDois(status, parcela);
    }

    @Quando("no body passar um valor {int} maior que quarenta mil com retorno do status {int}")
    public void no_body_passar_um_valor_maior_que_quarenta_mil_com_retorno_do_status(Integer valor, Integer status) {
        inserir.novaSimulacaoComMarioQueQuarentaMil(status, valor);
    }

    @Quando("enviar o id {int}")
    public void enviar_o_id(int id) {
        deletar.deletarSimulacao(id);
    }


}
