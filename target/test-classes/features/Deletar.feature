#language: pt

Funcionalidade: Realizar alterações

  Esquema do Cenario: Deletar uma simulacao
      #Pré condição: CPF já deve ter simulação cadastrada
    Dado que eu preciso deletar uma simulação existente
    Quando enviar o id <id>
    Então o endpoint irá retornar o status 200

    Exemplos:
      | id |
      | 18 |