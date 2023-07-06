package com.emedlogix.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "emed_section_ref")
public class SectionReference {
    @Id
    String id;
    String chapterId;
    String icdReference;
    String first;
    String last;
    String notes;
    String version;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChapterId() {
        return chapterId;
    }

    public void setChapterId(String chapterId) {
        this.chapterId = chapterId;
    }

    public String getIcdReference() {
        return icdReference;
    }

    public void setIcdReference(String icdReference) {
        this.icdReference = icdReference;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "SectionReference{" +
                "id='" + id + '\'' +
                ", chapterId='" + chapterId + '\'' +
                ", icdReference='" + icdReference + '\'' +
                ", first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", notes='" + notes + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
