package br.com.alura.bytebank

import br.com.alura.bytebank.modelo.Endereco

fun main() {
    /*
    O “generics” nada mais é do que uma técnica para nós referenciarmos qualquer tipo de objeto,
    ou seja, nós temos a mesma característica de um “N”. Qual é a grande diferença dos “generics”?
    É que nós podemos trabalhar com “generics” de tal forma que nós podemos, por exemplo, nesse caso,
    mandarmos como o parâmetro do tipo função e lá dentro do escopo da função, nós vamos garantir
    que quem chamou aqui vai ser exatamente o mesmo tipo sem fazer qualquer tipo de “cast”.
     */

    val testeFuncao: () -> Unit

    //O let sempre vai ter a chamada a partir de um objeto
    Endereco().let ({
        it
    })
    "".let(::testeRecebeString)

    1.let {
        it
    }
    teste(1, {})
}

fun testeRecebeString(valor: String) {

}

//higher order function - Uma função recebendo outra ou função de auta ordem
fun teste(teste: Int, bloco: () -> Unit) {

}

//isso não e muito comum
//fun teste(teste: Int, bloco: () -> Unit): () -> Unit {
//    return {
//
//    }
//}

