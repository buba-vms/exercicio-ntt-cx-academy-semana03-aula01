# Utilizando a aplicação

## Listar todas as Pessoas

**GET** localhost:8080/pessoas

- Enviar uma requisição GET para o endpoint /pessoas.

## Retornar uma Pessoa pelo ID

**GET** localhost:8080/pessoas/{id}

- Enviar uma requisição GET para o endpoint /pessoas/{id}, onde {id} é o ID da pessoa que você deseja retornar.

## Inserir Pessoa

**POST** localhost:8080/pessoas

- Enviar uma requisição POST para o endpoint /pessoas com o seguinte body:<br>
- O campo id é gerado automaticamente pelo banco de dados.<br>
  {<br>
  "nome": "Nome da Pessoa",<br>
  "cpf": "000.000.000-00",<br>
  "rg": "0000000000",<br>
  "dataDeNascimento": "2020-01-10",<br>
  "estadoCivil": "Estado Civil",<br>
  "telefone": "Telefone",<br>
  "email": "email@email.com"<br>
  }

## Atualizar Dados da Pessoa pelo ID

**PUT** localhost:8080/pessoas/{id}<br>

- Enviar uma requisição PUT para o endpoint /pessoas/{id}, onde {id} é o ID da pessoa que você deseja atualizar, com o seguinte body:
- Você pode omitir os dados que não serão atualizados, e a aplicação irá utilizar os dados em memória;<br>
  {<br>
  "nome": "Nome da Pessoa",<br>
  "cpf": "000.000.000-00",<br>
  "rg": "0000000000",<br>
  "dataDeNascimento": "2020-01-10",<br>
  "estadoCivil": "Estado Civil",<br>
  "telefone": "Telefone",<br>
  "email": "email@email.com"<br>
  }
