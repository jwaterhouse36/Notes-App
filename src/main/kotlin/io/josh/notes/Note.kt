package io.josh.notes

import java.util.Date
import javax.persistence.*


@Entity
@Table(name = "notes", schema = "public")
data class Note(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Int,
    @Column(name = "title")
    var title: String,
    @Column(name = "body")
    var body: String,
    @Column(name = "date")
    var date: Date
)
