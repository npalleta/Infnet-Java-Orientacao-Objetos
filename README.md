# Infnet-Java-Orientacao-Objetos

Niky Lima

## Projeto da disciplina
Tecnologia Java e Orientação à Objetos.

### Crie um projeto que organize as regras de negócio em seis classes da seguinte maneira:
-  Uma classe mãe abstrata
-  Três classes filhas
-  Uma classe concreta sem mãe
-  Uma classe principal que tenha dois relacionamentos:
-  1:1 com a classe concreta
-  1:n com a classe mãe

### O projeto será organizado em 4 features:

**Feature - 01**
- Todas as classes precisam ter pelo menos três atributos e todos
os tipos de dados precisam ser utilizados em pelo menos uma
ocorrência.
- As classes de teste precisam ter pelo menos três instâncias dos
objetos.
- Todas as classes de domínio precisam ter o toString
implementado.
- A classe de associação (“Solicitante”) precisa ter um construtor
que receba todos os atributos como parâmetro.

**Feature - 02**
- É necessário criar um método abstrato na classe mãe.
- Cada filha precisa implementar diferentemente o método abstrato.

**Feature - 03**
- Criação de um atributo do tipo vetor.
- Criação de um atributo do tipo Set.
- Criação do relacionamento entre a classe principal e a mãe com
List.

**Feature - 04**
- Criação de classes de exceptions para tratar regras de negócio.
- Cada classe de negócio deve usar uma classe de exception.
- Fazer a leitura de um arquivo texto com o layout definido pelo
aluno.
- Um arquivo texto deve ser gerado com um layout diferente da
entrada.

IMPORTANTE: Assim que terminar, faça o commit do projeto no seu
repositório do git e informe o link no seu arquivo PDF e poste no Moodle.
Utilize o seu nome para nomear o arquivo, identificando também a
disciplina no seguinte formato:
“nomedoaluno_nomedadisciplina_pd.PDF”.

# Explicação

- Projeto utilizando Java 11;
- Apache Maven;
- IDE: IntelliJ.

**O Projeto desenvolvido por mim, foi baseado em um cadastro simples de aluno**
*As convenções utilizadas foram escolhidas para que os envolvidos na vida escolar do aluno se apresentassem nos dados de um formulário de informação escolar.*

### Comandos para excução do projeto:

- Rodando os testes:

```bash
mvn clean test
```

- Executando a classe Main:


```bash
mvn exec:java -D"exec.mainClass"="br.com.infnet.project.Main"
```

**Atividade - Calculadora de Preço de Produto**
*Para o desafio utilizando leitura e escrita em arquivos, a execução fica à caracter da classe CalculadoraPrecoProdutos.*
- Basicamente, temos 3 atributos, nomeProduto, valor e percentual de desconto. Com esses dados é apresentado o valor de desconto no produto, alimentado pelo arquivo resources/produtos.txt.
- O arquivo de saída é apresentado na pasta resources/ arquivo resultado_data_da_execução.txt.

```bash
mvn exec:java -D"exec.mainClass"="br.com.infnet.project.CalculadoraPrecoProdutos"
```
