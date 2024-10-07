import java.util.Scanner

class Menu(private val scanner: Scanner) {
    fun displayMenu(options: List<Pair<String, () -> Unit>>, prompt: String = "Выберите опцию:") {
        while (true) {
            println(prompt)
            options.forEachIndexed { index, option -> println("${index}. ${option.first}") }

            val input = scanner.nextLine()
            val optionIndex = input.toIntOrNull()

            if (optionIndex != null && optionIndex in options.indices) {
                options[optionIndex].second()
                break
            } else {
                println("Неверный ввод, попробуйте снова.")
            }
        }
    }

    fun readLine(prompt: String): String {
        println(prompt)
        return scanner.nextLine()
    }
}
