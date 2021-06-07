package br.com.alura.bytebank

/*
    Tipo função
    () Os parênteses determinaM os parâmetros que nós podemos receber em um tipo função.
    -> Essa flecha é para dividir entre os parênteses e o retorno.
    Unit É o tipo do retorno
    - Uma função fica dentro de uma variavel
    e agora podemos executar a função quando a gente quiser com base na que já existe
    Implementação a partir de uma classe é necessario sobrescrever um operador especial invoke
    para que torne uma implementação de classe invocavel.

    “lazy evaluation”, que seria uma avaliação preguiçosa,
    que só faz exatamente quando nós chamarmos e não quando nós simplesmente inicializamos
    ou indicamos qual é o seu retorno.

    “lazy evaluation”
    Avaliação preguiçosa é uma técnica usada em programação para atrasar a computação
    até um ponto em que o resultado da computação é considerado suficiente, o necessário

 */

fun main() {
//    testaTipoFuncaoReferencia()
//    testaTipoFuncaoClasse()

    /*
     2 Recursos para inicializar o tipo função
     - expressão lambda ou uma função anônima,
     elas ficam muito vinculadas à nossa variável.

     função anônima:
     Basicamente nós vamos declarar como se tivesse uma função e aqui dentro
     nós colocamos uma função que seja compatível ao tipo que nós queremos,
     que seria uma função que não tem nenhum parâmetro e ela não retorna nada.
     Então isso é uma implementação de uma função anônima.

     Detalhes para considerar ao utilizar expressão lambda
     no momento que temos parametros e não utilizamos devemos renomear para _
     isso significa que esse parametro não será utilizado só para bater a quantidade de
     parametros

     Então, o que seria de diferente?
     Quando eu considero, ou não, a expressão lambda ou a função anônima?

     A função anônima nós vamos considerar em situações nas quais nós queremos deixar
     bem claro o que nós queremos colocar como parâmetro.
     Como estamos vendo aqui, o que queremos colocar como retorno e também qual
     o escopo de execução do código. Por quê? Porque aqui no escopo de execução
     de código nós podemos executar o que quisermos, mas também somos obrigados
     a falar quem retorna o quê. Ele não vai retornar a última expressão,
     assim como nós vemos na expressão lambda.

     Ele não retorna dessa maneira, ele retorna como se fosse uma função mesmo.
     Então é dessa forma que funciona da função anônima.
     Ela é uma maneira mais explícita de implementar uma expressão lambda.
     Nós podemos entender dessa maneira.
     */

    //Inferir no tipo precisa deixar claro os valores do parametros e o tipo
//    val minhaFuncaoLambda  =  {a: Int, b: Int ->
    val minhaFuncaoLambda: (Int, Int) -> Int =  {a, b ->
       a + b
    }
    println("Executa soma da função lambda: ${minhaFuncaoLambda(15,10)}")

//    val minhaFuncaoAnonima: = fun(a: Int, b: Int): Int {
    val minhaFuncaoAnonima: (Int, Int) -> Int = fun(a, b): Int {
        println("Executa como anonima")
        return a + b
    }
    println(minhaFuncaoAnonima(10, 2))
}

fun testaTipoFuncaoClasse() {
    //Similares objeto de classe
//    val minhaFuncaoClasse = Soma()
    val minhaFuncaoClasse: (Int, Int) -> Int = Soma()
    /*
        Só passamos os parametros quando chamamos o Invoke a
         avaliação e feita so quando executamos a chamada - lazy evaluation
     */
    println(minhaFuncaoClasse(10, 10))
}

fun testaTipoFuncaoReferencia() {
    /*
     Similares referencia de função
     Ao inferir o KFunction0 essa referência que representa uma função quando é feito a introspecção
     é uma tecnica de reflection

     Quando nós vamos usar o tipo função, ele precisa ser igual a referência da função
     que estamos mandando ou igual ao que nós estamos querendo inicializar.
     */
    val minhaFuncao: (Int, Int) -> Int = ::soma
//    val minhaFuncao = ::soma
    println(minhaFuncao(5, 10))
}

//Compativel com assinatura
//shift + f6 para alterar a função de teste para soma
fun soma(a: Int, b: Int): Int {
    return a + b
}

//Alterar assinatura
class Soma : (Int, Int) -> Int {
    override fun invoke(a: Int, b: Int): Int = a + b
}

