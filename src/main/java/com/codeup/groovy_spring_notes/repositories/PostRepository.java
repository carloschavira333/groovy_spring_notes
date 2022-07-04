package com.codeup.groovy_spring_notes.repositories;

import com.codeup.groovy_spring_notes.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
