package br.com.alura.bytebank

import br.com.alura.bytebank.modelo.Cliente
import br.com.alura.bytebank.modelo.ContaPoupanca
import br.com.alura.bytebank.modelo.Endereco
import bytebank.teste.testaHOF


fun main() {
    testaHOF()


}

fun testaRun() {
    val taxaAnual = 0.05
    val taxaMensal: Double = taxaAnual / 12
    println("taxa mensal $taxaMensal")

    val novaConta1 = ContaPoupanca(Cliente(nome = "Alex", cpf = "111.111.111-11", senha = 1234), 1000)
    novaConta1.run {
        deposita(1000.0)
        println(saldo)
        saldo * taxaMensal
    }.let { rendimentoMensal ->
        println(rendimentoMensal)
    }


    val novaConta2 = Cliente(nome = "Luiz", cpf = "222.222.222-22", senha = 1234)
        .let { clienteNovo: Cliente ->
            ContaPoupanca(clienteNovo, 1000)
        }.run {
            deposita(2000.0)
            println(saldo)
            saldo * taxaMensal
        }.let { rendimentoMensal ->
            println("rendimento mensal $rendimentoMensal")
        }

    //calculo de juros compostos
    val rendimentoAnual = run {
        var saldo: Double = novaConta1.saldo
        repeat(12) {
            saldo += saldo * taxaMensal
        }
        saldo
    }

    println("simulacao rendimento mensal $rendimentoAnual")
}

fun testaWith() {
    with(Endereco()) {
        logradouro = "rua vergueiro"
        numero = 318
        bairro = "Vila Mariana"
        cidade = "São Paulo"
        estado = "SP"
        cep = "02310-063"
        complemento = "Apartamento"
        completo()
    }.let { enderecoCompleto: String ->
        println(enderecoCompleto)
    }
}
