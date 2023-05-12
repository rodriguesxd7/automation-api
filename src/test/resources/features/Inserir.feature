#language: pt
  Funcionalidade: Realizar inserções


    Esquema do Cenario: Inserir uma nova simulação com parcelas menor que 2
      #Pré condição: CPF nao pode estar cadastrado na base
      Dado que eu preciso inserir uma nova simulação
      Quando no body passar uma parcela <parcela> menor que dois com retorno do status <status>
      Então o endpoint irá retornar a mensagem <msg> de erro
      Exemplos:
        | status | parcela | msg                                      |
        | 400    | 1       | "Parcelas deve ser igual ou maior que 2" |

    Esquema do Cenario: Inserir uma nova simulação com valor maior que quarenta mil reais
      #Pré condição: CPF nao pode estar cadastrado na base
      Dado que eu preciso inserir uma nova simulação
      Quando no body passar um valor <valor> maior que quarenta mil com retorno do status <status>
      Então o endpoint irá retornar a mensagem <msg> de erro
      Exemplos:
        | status | valor | msg                                         |
        | 400    | 45000 | "Valor deve ser menor ou igual a R$ 40.000" |


    Esquema do Cenario: Inserir uma nova simulação
      #Pré condição: CPF nao pode estar cadastrado na base
      Dado que eu preciso inserir uma nova simulação
      Quando eu realizar uma chamada POST no endpoint apiv1simulacoes <status>
      Então o endpoint irá retornar os dados da simulação
      Exemplos:
        | status |
        | 201    |

    Esquema do Cenario: Inserir uma nova simulação com CPF duplicado
      #Pré condição: CPF já deve ter simulação cadastrada
      Dado que eu preciso inserir uma nova simulação com um cpf já cadastrado
      Quando eu realizar uma chamada POST no endpoint apiv1simulacoes cpf duplicado <status>
      Então o endpoint irá retornar uma mensagem <msg> dizendo que o CPF está duplicado

      Exemplos:
        | status |
        | 400    |

    Esquema do Cenario: Inserir uma nova simulação faltando campo
      #Pré condição: Passar os dados com um campo qualquer faltando
      Dado que eu preciso inserir uma nova simulação
      Quando eu realizar uma chamada POST no endpoint apiv1simulacoes com um campo a menos <status>
      Então o endpoint irá retornar status e um erro

      Exemplos:
        | status |
        | 500    |