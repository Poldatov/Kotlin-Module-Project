class ArchiveMenu(private val menu: Menu, private val archive: Archive, private val goBack: () -> Unit) {
    fun show() {
        menu.displayMenu(listOf(
            "Создать заметку" to { createNote() },
            "Просмотреть заметки" to { viewNotes() },
            "Назад" to goBack
        ), "Меню архива: ${archive.name}")
    }

    private fun createNote() {
        val title = menu.readLine("Введите название заметки:")
        val content = menu.readLine("Введите содержание заметки:")
        if (title.isNotBlank() && content.isNotBlank()) {
            archive.notes.add(Note(title, content))
        } else {
            println("Название и содержание заметки не могут быть пустыми.")
        }
        show()
    }

    private fun viewNotes() {
        if (archive.notes.isEmpty()) {
            println("Нет доступных заметок.")
            show()
            return
        }

        menu.displayMenu(archive.notes.map { note ->
            note.title to { NoteMenu(menu, note, this::show).show() }
        } + listOf("Назад" to { show() }), "Список заметок:")
    }
}
