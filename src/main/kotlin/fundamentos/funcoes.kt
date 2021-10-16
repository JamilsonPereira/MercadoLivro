package fundamentos

fun main(){
    //inserindo nome em uma função que recebe valores
    dizOi("Teste", 24)
    //declarando funcao dizOi, passando como parametro a funcao retornaNome()
    dizOi(retornaNome(), 31)
    //declarando a funcao dizOi deixando explicito a variavel nome e idade
    dizOi(nome = "Jamelson", idade = 27)
    //Ja que está fixado um valor no metodo na variavel idade, se eu não passar nada aqui irá preencher
    // a idade declarada
    dizOi("Jamelao")
}

fun retornaNome(): String{
    return "Jamilson"
}
//funcao criada para receber valores
fun dizOi(nome: String, idade: Int = 20){
    //o $ serve para concatenar
    println("oi $nome, parabens pelos seus $idade anos")
}