package bytebank.teste

import br.com.alura.bytebank.modelo.Autenticavel
import br.com.alura.bytebank.modelo.SistemaInterno

fun testaHOF() {
    //Isso aqui só acontece quando a função falar que esse codigo foi executado
    soma(1, 5, resultado = { valor ->

        println(valor)
    })
    //Isso aqui só acontece quando a função falar que esse codigo foi executado
    soma(1, 5, resultado = (::println))
    //ao utilizar um receiver não e possiver criar uma apelido pois temos um this
    somaReceiver(1, 5,resultado ={
        println(this)
    })
    somaReceiver(1, 5,resultado = (::println) )

    val autenticavel = object : Autenticavel {
        val senha = 1234
        override fun autentica(senha: Int) = this.senha == senha
    }

    val sistema = SistemaInterno()
    sistema.entra(autenticavel, 1234, autenticado = {
        println("realizar Pagamento")
    })

    sistema.entraReceiver(autenticavel, 1234, autenticado = {
        pagamento()
    })
}

//Variações
fun soma(a: Int, b: Int, resultado: (Int) -> Unit) {
    println("antes da soma")
    resultado(a + b)
    println("depois da soma")
}

fun somaReceiver(a: Int, b: Int, resultado: Int.() -> Unit){
    println("antes da soma")
    val total = a + b
    total.resultado()
    println("depois da soma")
}


//Normal
//fun soma(a: Int, b: Int): Int{
//    return a + b
//}
