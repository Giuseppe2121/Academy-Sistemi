package com.sistemi.service;

import com.sistemi.entity.Tutorial;

import java.util.List;
import java.util.Map;

public interface TutorialService {

    public Tutorial saveOrUpdateTutorial(Tutorial tutorial);

    public Map<String,Boolean> removeTtutorial(Integer id);

    public List<Tutorial> findAllTutorials();

    public List<Tutorial> findAllTutorialsByName(String name);

    public Tutorial findTutorialById(Integer id);
}
