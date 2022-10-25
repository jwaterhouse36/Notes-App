package io.josh.notes

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service


@Service
class NotesService(
    val repository: NotesRepository
) {
    fun getAllNotes(): MutableIterable<Note> = repository.findAll()

    fun getNoteById(id: Int): Note = repository.findById(id).orElseThrow { Exception("No note found") }

    fun createNote(newNote: Note): Note = repository.save(newNote)

    fun updateNote(id: Int, newInfo: Note): Note {
        val note = getNoteById(id)
        note.title = newInfo.title
        note.body = newInfo.body
        note.date = newInfo.date
        return repository.save(note)

    }

    fun deleteNote(id: Int) = repository.deleteById(id)

}
