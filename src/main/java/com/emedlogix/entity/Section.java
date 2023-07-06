package com.emedlogix.entity;

import org.hibernate.annotations.Cascade;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "emed_section")
public class Section {
    @Id
    @Column(nullable = false)
    String code;
    String chapterId;
    String icdReference;
    String version;
    @OneToMany(mappedBy="section")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    List<Notes> notes;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<Notes> getNotes() {
        notes = notes==null?new ArrayList<>():notes;
        return notes;
    }

    public void setNotes(List<Notes> notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Section{" +
                "code='" + code + '\'' +
                ", chapterId='" + chapterId + '\'' +
                ", icdReference='" + icdReference + '\'' +
                ", version='" + version + '\'' +
                ", notes=" + notes +
                '}';
    }
}
