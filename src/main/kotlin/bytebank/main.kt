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
    //Similares
//    val minhaFuncao: () -> Unit = ::teste
    val minhaFuncao = ::teste
    println(minhaFuncao())
    //Similares
//    val minhaFuncaoClasses: () -> Unit = Teste()
    val minhaFuncaoClasses = Teste()
    println(minhaFuncaoClasses())
}

//Compativel com assinatura
fun teste() {
    println("executa teste")
}


class Teste : () -> Unit {
    override fun invoke() {
        println("executa invoke do Teste")
    }

}

