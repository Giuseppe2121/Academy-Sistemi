package com.sistemi.repository;

import com.sistemi.entity.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TutorialRepository extends JpaRepository<Tutorial, Integer> {

    //findAll

    //findById

    //save

    //deleteById

    public List<Tutorial> findByName(String name);


}
