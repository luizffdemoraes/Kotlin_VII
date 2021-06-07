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
    testaTipoFuncaoReferencia()
    testaTipoFuncaoClasse()

    /*
     2 Recursos para inicializar o tipo função
     - expressão lambda ou uma função anônima,
     elas ficam muito vinculadas à nossa variável.

     função anônima:
     Basicamente nós vamos declarar como se tivesse uma função e aqui dentro
     nós colocamos uma função que seja compatível ao tipo que nós queremos,
     que seria uma função que não tem nenhum parâmetro e ela não retorna nada.
     Então isso é uma implementação de uma função anônima.
     */

//    val minhaFuncaoLambda =  {
//        println("Executa como lambda")
//    }
//    println(minhaFuncaoLambda())
//
//
//    val minhaFuncaoAnonima: () -> Unit = fun() {
//        println("Executa como anonima")
//    }
//    println(minhaFuncaoAnonima())
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

