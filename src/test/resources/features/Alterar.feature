#language: pt

  Funcionalidade: Realizar alterações

   Esquema do Cenario: Atualizar uma simulação já existente
      #Pré condição: CPF já deve ter simulação cadastrada
      Dado que eu preciso atualizar uma simulação já existente
      Quando alterar o cpf <cpf> com o valor <valor> com status <status>
      Então o endpoint irá retornar uma nova simulacao

     Exemplos:
       | cpf           | valor | status |
       | "66414919004" | 35000 | 200    |
