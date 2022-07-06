package com.codeup.groovy_spring_notes.repositories;

import com.codeup.groovy_spring_notes.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
