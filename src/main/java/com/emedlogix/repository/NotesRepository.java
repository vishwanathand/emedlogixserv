package com.emedlogix.repository;

import com.emedlogix.entity.Chapter;
import com.emedlogix.entity.Notes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotesRepository extends JpaRepository<Notes, String> {

}
