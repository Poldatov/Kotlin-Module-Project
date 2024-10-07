class NotesApp(private val menu: Menu) {
    private val archives = mutableListOf<Archive>()

    fun run() {
        mainMenu()
    }

    fun mainMenu() {
        menu.displayMenu(listOf(
            "Создать архив" to ::createArchive,
            "Просмотреть архивы" to ::viewArchives,
            "Выход" to ::exitProgram
        ), "Список архивов:")
    }

    private fun createArchive() {
        val name = menu.readLine("Введите имя архива:")
        if (name.isNotBlank()) {
            val archive = Archive(name, mutableListOf())
            archives.add(archive)
        } else {
            println("Имя архива не может быть пустым.")
        }
        mainMenu()
    }

    fun viewArchives() {
        if (archives.isEmpty()) {
            println("Нет доступных архивов.")
            mainMenu()
            return
        }

        menu.displayMenu(archives.map { archive ->
            archive.name to { ArchiveMenu(menu, archive, this::viewArchives).show() }
        } + listOf("Назад" to ::mainMenu), "Список архивов:")
    }

    private fun exitProgram() {
        println("Выход из программы.")
        System.exit(0)
    }
}
