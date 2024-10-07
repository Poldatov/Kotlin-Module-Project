import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val menu = Menu(scanner)
    val app = NotesApp(menu)
    app.run()
}
