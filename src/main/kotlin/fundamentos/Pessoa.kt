package fundamentos

data class Pessoa(var nome: String, var idade: Int) {

}
fun main (){
    var gustavo = Pessoa("Gustavo", 24)
    println(gustavo)
}