package com.example.monolithic_app.repository;

import com.example.monolithic_app.model.user;
import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;
@Repository

public interface userRepository extends JpaRepository<user, Long> {

}
