/**
 * NIM : 10120207
 * Nama : Vikri Frediansyah
 * Kelas : IF-5
 */

package com.thisvyx.diaryapp_10120207;

public class NoteModel {

    int id;
    String noteTittle, noteCategory, noteDetails, noteDate, noteTime;

    NoteModel(){

    }

    public NoteModel(String noteTittle, String noteCategory, String noteDetails, String noteDate, String noteTime) {
        this.noteTittle = noteTittle;
        this.noteCategory = noteCategory;
        this.noteDetails = noteDetails;
        this.noteDate = noteDate;
        this.noteTime = noteTime;
    }

    public NoteModel(int id, String noteTittle, String noteCategory, String noteDetails, String noteDate, String noteTime) {
        this.id = id;
        this.noteTittle = noteTittle;
        this.noteCategory = noteCategory;
        this.noteDetails = noteDetails;
        this.noteDate = noteDate;
        this.noteTime = noteTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNoteTittle() {
        return noteTittle;
    }

    public void setNoteTittle(String noteTittle) {
        this.noteTittle = noteTittle;
    }

    public String getNoteCategory() {
        return noteCategory;
    }

    public void setNoteCategory(String noteCategory) {
        this.noteCategory = noteCategory;
    }

    public String getNoteDetails() {
        return noteDetails;
    }

    public void setNoteDetails(String noteDetails) {
        this.noteDetails = noteDetails;
    }

    public String getNoteDate() {
        return noteDate;
    }

    public void setNoteDate(String noteDate) {
        this.noteDate = noteDate;
    }

    public String getNoteTime() {
        return noteTime;
    }

    public void setNoteTime(String noteTime) {
        this.noteTime = noteTime;
    }
}
