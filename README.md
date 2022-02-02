## Descrição do Projeto
O projeto utiliza Vue (Vuex, VueRouter) e Axios no frontend e Spring Boot, Spring Data e banco de dados H2.

Para iniciar o Backend, importe o projeto (Maven) utilizando seu IDE preferido.
Para iniciar o Frontend, utilize o seguinte código no terminal:

    cd ./frontend
    npm run server

## Detalhes do Backend
O backend, feito utilizando Spring Boot, aplica uma arquitetura em três camadas (Controller, Service e Repository) e expõe as seguintes rotas:

 - **GET** *"/transfer"* -> Busca todas as transferência
 -  **POST** *"/transfer"* -> Realiza uma nova transferência

Para aplicar as regras de taxação, foi utilizado uma estrutura inspirada no design pattern [*Chain of Responsability*](https://refactoring.guru/pt-br/design-patterns/chain-of-responsibility), onde classes implementam a interface nomeada *OperationTaxHandler* e os dois métodos:

 - **canHandle**, utilizado para indicar que a classe sabe lidar com algum tipo de operação
 - **calculateTax**, onde é implementado o cálculo da taxa.

Esta estrutura é exposta via um *facade* chamado **OperationTaxFacade**, que possuí somente o método **calculateOperationTax**.  Isso facilita a criação de novos tipos de operação e cálculos de taxa respectivos, enquanto o facade esconde detalhes da implementação de quem utiliza esta estrutura.

Foi criado um **CalendarUtils** com um método que facilita lidar com adição de datas.

Foi criado um **SaveTransferVO** e um **TransferMapper** (manual), utilizados no Controller para separar a entidade da classe que lida com a requisição do usuário.

Foi criada uma **Exception** personalizada chamada **InvalidInputException**, utilizada para sinalizar que algum valor utilizado pelo usuário nas requisições não é válido.

Não foi utilizado **Lombok**.


