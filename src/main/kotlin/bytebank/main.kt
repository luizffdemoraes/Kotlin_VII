package br.com.alura.bytebank

import br.com.alura.bytebank.modelo.Endereco

fun main() {

//    val endereco = Endereco(logradouro = "rua vergueiro", numero = 3185)
//    val enderecoEmMaiusculo = "${endereco.logradouro}, ${endereco.numero}".toUpperCase()
//    println(enderecoEmMaiusculo)

    //O let sempre vai ter a chamada a partir de um objeto
    //chamadas encadeadas
    Endereco(logradouro = "rua vergueiro", numero = 3185)
        .let { endereco ->
            "${endereco.logradouro}, ${endereco.numero}".toUpperCase()
        }.let (::println)

    val enderecosComComplemento = listOf(Endereco(complemento = "casa"),
        Endereco(),
        Endereco(complemento = "apartamento"))
        .filter { endereco -> endereco.complemento.isNotEmpty() }
        .let(::println)

}

/*
O “generics” nada mais é do que uma técnica para nós referenciarmos qualquer tipo de objeto,
ou seja, nós temos a mesma característica de um “N”. Qual é a grande diferença dos “generics”?
É que nós podemos trabalhar com “generics” de tal forma que nós podemos, por exemplo, nesse caso,
mandarmos como o parâmetro do tipo função e lá dentro do escopo da função, nós vamos garantir
que quem chamou aqui vai ser exatamente o mesmo tipo sem fazer qualquer tipo de “cast”.

//O let sempre vai ter a chamada a partir de um objeto

"".let(::testeRecebeString)

1.let {
    it
}
teste(1, {})

fun testeRecebeString(valor: String) {

}

val testeFuncao: () -> Unit

//higher order function - Uma função recebendo outra ou função de auta ordem
fun teste(teste: Int, bloco: () -> Unit) {

}

//isso não e muito comum
//fun teste(teste: Int, bloco: () -> Unit): () -> Unit {
//    return {
//
//    }
//}

 */

