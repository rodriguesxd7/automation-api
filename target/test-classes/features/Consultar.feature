#language: pt

Funcionalidade: Realizar consultas


  Esquema do Cenario: Realizar uma consulta de um cliente com restrição
      #Pré condição: Cliente deve estar cadastrado na base
    Dado que eu preciso saber se o cliente possui restrição
    Quando eu realizar uma chamada GET no endpoint apiv1restricoescpf passando o CPF <cpf> retornando o status <status>
    Entao o endpoint irá retornar uma mensagem se o cliente possui ou nao uma restrição

    Exemplos:
      | cpf           | status |
      | "97093236014" | 200    |
      | "60094146012" | 200    |
      | "84809766080" | 200    |
      | "62648716050" | 200    |
      | "26276298085" | 200    |
      | "01317496094" | 200    |
      | "55856777050" | 200    |
      | "19626829001" | 200    |
      | "24094592008" | 200    |
      | "58063164083" | 200    |


  Esquema do Cenario: Realizar uma consulta de um cliente não cadastrado
      #Pré condição: Cliente não deve estar cadastrado na base
    Dado que eu preciso saber se o cliente está cadastrado na base
    Quando eu realizar uma chamada GET no endpoint apiv1simulacoescpf passando o CPF <cpf> retornando o status <status>
    Então o endpoint irá retornar uma mensagem dizendo que o cliente não está cadastrado na base com a mensagem <msg>

    Exemplos:
      | cpf           | status | msg                              |
      | "40987654676" | 404    | "CPF 40987654676 não encontrado" |


  Esquema do Cenário: Realizar uma consulta de todas as simulações existentes
      #Pré condição: Deve ter simulações cadastradas
    Dado que eu preciso verificar todas as simulações cadastradas
    Quando eu realizar uma chamada GET no endpoint apiv1simulacoes retornando status <status>
    Então o endpoint irá retornar todas as simulações cadastradas

    Exemplos:
      | status |
      | 200    |

  Esquema do Cenário: Realizar uma consulta por cpf
      #Pré condição: Deve ter simulações cadastradas
    Dado que eu preciso verificar um cpf especifico
    Quando eu realizar uma chamada GET no endpoint apiv1simulacoescpf passando o CPF <cpf> retornando o status <status>
    Então o endpoint irá retornar as informacoes do cpf

    Exemplos:
      | status | cpf           |
      | 200    | "66414919004" |
