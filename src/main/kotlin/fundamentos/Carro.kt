package fundamentos

class Carro(var cor: String, val anoFabricacao: Int, val dono: Dono ) {
}

data class Dono(var nome: String, var idade: Int){

}
fun main (){
    var carro = Carro("Verde", 2021, Dono("Jamilson", 27))
    println(carro.cor)
    carro.cor = "Azul"
    println(carro.cor)

    println(carro.dono)
    carro.dono.nome = "Jamal"
    println(carro.dono.nome)
}