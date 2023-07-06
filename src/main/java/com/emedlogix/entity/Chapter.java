package com.emedlogix.entity;

import org.aspectj.weaver.ast.Not;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "emed_chapter")
public class Chapter {

    @Id
    @Column(nullable = false)
    String id;
    String icdReference;
    String description;

    @OneToMany(mappedBy="chapter")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    List<Notes> notes;
    String version;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIcdReference() {
        return icdReference;
    }

    public void setIcdReference(String icdReference) {
        this.icdReference = icdReference;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Notes> getNotes() {
        notes = notes==null?new ArrayList<>():notes;
        return notes;
    }

    public void setNotes(List<Notes> notes) {
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
        return "Chapter{" +
                "id='" + id + '\'' +
                ", icdReference='" + icdReference + '\'' +
                ", description='" + description + '\'' +
                ", notes=" + notes +
                ", version='" + version + '\'' +
                '}';
    }
}
