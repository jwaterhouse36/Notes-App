package io.josh.notes

import org.slf4j.LoggerFactory.getLogger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class NotesController(
    val notesService: NotesService
) {
    val logger = LoggerFactory.getLogger(this::class.java)!!

    @GetMapping("/")
    fun homePage(): String = "Welcome to the Notes App"

    @GetMapping("/notes")
    fun getAllNotes(): MutableIterable<Note> = notesService.getAllNotes()

    @GetMapping("/notes/{id}")
    fun getNoteById(@PathVariable id: Int): Note? = notesService.getNoteById(id)

    @PostMapping("/notes/create")
    fun createNote(@RequestBody note: Note): Note = notesService.createNote(note)

    @PutMapping("/notes/edit/{id}")
    fun updateNote(@PathVariable id: Int, @RequestBody newInfo: Note): Note = notesService.updateNote(id, newInfo)

    @DeleteMapping("/notes/{id}")
    fun deleteNote(@PathVariable id: Int) = notesService.deleteNote(id)
}