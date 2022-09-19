package com.example.gdroom_a_10755.room

import androidx.room.*

@Entity
data class Note (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val note: String
)

@Dao
interface NoteDao{

    @Insert
    suspend fun addNote(note:Note)

    @Update
    suspend fun updateNote(note:Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("SELECT * FROM note")
    suspend fun getNotes() : List<Note>

    @Query("SELECT * FROM note WHERE id =:note_id")
    suspend fun getNote(note_id:Int):List<Note>
}