class NoteMenu(private val menu: Menu, private val note: Note, private val goBack: () -> Unit) {
    fun show() {
        println("Название: ${note.title}")
        println("Содержание: ${note.content}")
        menu.displayMenu(listOf("Назад в меню заметки" to goBack))
    }
}
