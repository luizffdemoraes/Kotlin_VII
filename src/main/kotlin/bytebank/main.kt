package br.com.alura.bytebank

import br.com.alura.bytebank.modelo.Autenticavel
import br.com.alura.bytebank.modelo.Endereco
import br.com.alura.bytebank.modelo.SistemaInterno

fun main() {

//    val endereco = Endereco(logradouro = "rua vergueiro", numero = 3185)
//    val enderecoEmMaiusculo = "${endereco.logradouro}, ${endereco.numero}".toUpperCase()
//    println(enderecoEmMaiusculo)

    //O let sempre vai ter a chamada a partir de um objeto
    //chamadas encadeadas
    Endereco(logradouro = "rua vergueiro", numero = 3185)
            //apply é um recever não temos acesso a argumento
        .apply {
            "$logradouro, $numero".toUpperCase()
        }.let (::println)

    listOf(Endereco(complemento = "casa"),
        Endereco(),
        Endereco(complemento = "apartamento"))
        .filter (predicate = { endereco -> endereco.complemento.isNotEmpty() })
        .let(::println)
        .let(block = (::println))

    //Isso aqui só acontece quando a função falar que esse codigo foi executado
    soma(1,5, resultado = {valor ->

        println(valor)
    })
    //Isso aqui só acontece quando a função falar que esse codigo foi executado
    soma(1,5, resultado = (::println))

    val autenticavel = object : Autenticavel {
        val senha = 1234
        override fun autentica(senha: Int) = this.senha == senha
    }

    SistemaInterno().entra(autenticavel, 1234, autenticado = {
        println("realizar Pagamento")
    })

}
//Variações
fun soma(a: Int, b: Int, resultado:(Int) -> Unit){
    println("antes da soma")
    resultado(a+b)
    println("depois da soma")
}
//Normal
//fun soma(a: Int, b: Int): Int{
//    return a + b
//}


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

