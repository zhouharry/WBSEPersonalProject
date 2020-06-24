package ntou.wbse.personalproject.service;

import ntou.wbse.personalproject.entity.*;
import ntou.wbse.personalproject.exception.*;
import ntou.wbse.personalproject.model.*;
import ntou.wbse.personalproject.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProjectService {

    @Autowired
    private QuestRepository questRepository;

    @Autowired
    private WeaponRepository weaponRepository;

    public ProjectService(QuestRepository questRepository, WeaponRepository weaponRepository) {
        this.questRepository = questRepository;
        this.weaponRepository = weaponRepository;
    }

    public List<Quest> getQuestsByAttribute(String attribute) {
        return questRepository.findByAttributeContainingIgnoreCase(attribute);
    }

    public List<Weapon> getWeaponsByAttribute(String attribute) {
        return weaponRepository.findByAttributeContainingIgnoreCase(attribute);
    }

    public Quest getQuestsByName(String name) {
        return questRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Weapon> getWeaponByName(String name) {
        return weaponRepository.findByNameContainingIgnoreCase(name);
    }

    public Quest createQuest(QuestRequest request) {
        Quest quest = new Quest();
        quest.setName(request.getName());
        quest.setAttribute(request.getAttribute());
        quest.setKeyword(request.getKeyword());

        return questRepository.insert(quest);
    }

    public void deleteQuest(String name) {
        Quest selectQuest = questRepository.findByNameContainingIgnoreCase(name);
        questRepository.deleteById(selectQuest.getId());
    }


}
