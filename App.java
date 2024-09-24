/**
 * public: declaração de exportação pública de uma classe/método/função/variável/etc...
 * 
 * class: declaração de classe (objeto)
 * 
 * HelloWorld: nome da classe (principal), que tem que ser igual ao nome do arquivo HelloWorld.java
 * 
 * { "abre chaves": inicia o bloco de código
 * 
 * static: declaração de método/função/variável estática, pois essa declaração faz com que os dados não sejam perdidos/vazados na memória ou processamento
 * 
 * void (nulo): nesse caso, significa que o método não irá retornar, ou seja o retorno é: "nulo"
 * 
 * main (principal): nome do método, neste caso, é o método principal, que irá executar o projeto
 * 
 * ( "abre parênteses": início da declaração de parâmetros ou argumentos
 * 
 * String (texto): é o tipo do parâmetro ou argumento, serve também para declarar tipo de variável
 * 
 * [] "abre e fecha colchetes": declaração de uma matriz
 * 
 * args (argumentos): é o nome do parâmetro ou argumento
 * 
 * ) "fechar parênteses": fim da declaração de parâmetros ou argumentos
 * 
 * System (sistema): declaração/invocação da classe "System"
 * 
 * . "ponto": operador de invocação
 * 
 * out (saída): depois do ponto, serve como uma declaração/invocação da subclasse "out", proveniente da classe "System"
 * 
 * println (imprimir "print" linha "ln" -> line): depois do ponto, serve como uma declaração/invocação do método "println", pois logo após tem um "abre parênteses"
 * Obs: quando tem o "new" (novo) antes é uma declaração/invocação/criação de um novo objeto
 * 
 * "Hello World!": é o texto propriamente dito, dentro de aspas duplas
 * 
 * "": aspas duplas: declaração/definição de texto
 * 
 * ; "ponto e vírgula": é a declaração de finalização de linha de código
 * 
 * } "fecha chaves": é a declaração de finalização de bloco de código
 */
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
