enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario (val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60, var nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }

    override fun toString(): String {
        return "Formacao(nome='$nome', conteudos=$conteudos, inscritos=$inscritos)"
    }
}

fun main() {
    val aluno1 = Usuario(nome = "Vinícius")
    val aluno2 = Usuario(nome = "Guilherme")

    val cursoDeProgramacao: List<ConteudoEducacional> = mutableListOf(
        ConteudoEducacional(nome = "Métodos", duracao = 20, nivel = Nivel.INTERMEDIARIO),
        ConteudoEducacional(nome = "Variáveis", duracao = 10, nivel = Nivel.BASICO),
        ConteudoEducacional(nome = "Tratamento de Exceções", duracao = 20, nivel = Nivel.DIFICIL)
    )

    val formacao = Formacao(nome = "Formação em Kotlin", conteudos = cursoDeProgramacao)

    formacao.matricular(aluno1)
    formacao.matricular(aluno2)

    println(formacao)
}
