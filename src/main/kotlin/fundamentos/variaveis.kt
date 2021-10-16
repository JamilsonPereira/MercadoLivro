package fundamentos

fun main(){

    //quando declaro uma variavel com "var" significa que o valor possa ser alterado posteriormente
    var nome: String
    //quando declaro uma variavel com "val" seu valor nao pode ser alterado
    val nomeVal : String
}

class variaveis{
    // A forma de dec
    lateinit var teste: String
    fun iniciaVariaveis(){
        teste = "Teste"
    }
}