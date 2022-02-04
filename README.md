## Descrição do Projeto
O projeto utiliza Vue (Vuex, VueRouter) e Axios no frontend e Spring Boot, Spring Data e banco de dados H2.

Inicie o backend primeiro. Para isso, importe o projeto (Maven) utilizando seu IDE preferido.
Para iniciar o Frontend, utilize o seguinte código no terminal:

    cd ./frontend
    npm run server

Assim, provavelmente estarão expostos nos seguintes endereços:

 - **Backend** -> localhost:8080
 - **Frontend** -> localhost:8081 (automático)
## Detalhes do Backend
O backend foi desenvolvido aplicando uma arquitetura em três camadas (Controller, Service e Repository) e expõe as seguintes rotas:

 - **GET** *"/transfer"* -> Busca todas as transferência
 - **POST** *"/transfer"* -> Realiza uma nova transferência
 - **POST** *"/transfer/cotate"* -> Itera sobre todos os tipos de operação e calcula as taxas

Para aplicar as regras de taxação, foi utilizado uma estrutura inspirada no design pattern [*Chain of Responsability*](https://refactoring.guru/pt-br/design-patterns/chain-of-responsibility), onde classes implementam a interface nomeada *OperationTaxHandler* e os dois métodos:

 - **canHandle**, utilizado para indicar que a classe sabe lidar com algum tipo de operação
 - **calculateTax**, onde é implementado o cálculo da taxa.

Esta estrutura é exposta via um *facade* chamado **OperationTaxFacade**, que possuí somente o método **calculateOperationTax**.  Isso facilita a criação de novos tipos de operação e cálculos de taxa respectivos, enquanto o facade esconde detalhes da implementação de quem utiliza esta estrutura.

Foi criado um **CalendarUtils** com um método que facilita lidar com adição de datas.

Foi criado um **SaveTransferVO** e um **TransferMapper** (manual), utilizados no Controller para separar a entidade da classe que lida com a requisição do usuário.

Foi criada uma **Exception** personalizada chamada **InvalidInputException**, utilizada para sinalizar que algum valor utilizado pelo usuário nas requisições não é válido.

Não foi utilizado **Lombok**.

Não foi criada estrutura de Usuário e segurança (Spring Security e sessions)

## Detalhes do Frontend
Foi utilizado um plugin (v-mask) para máscara de valores.

Foi construído componentes próprios, assim como os métodos de validação.

Toda chamada para API é feita na store, utilizando Vuex, assim como a recuperação de dados.








