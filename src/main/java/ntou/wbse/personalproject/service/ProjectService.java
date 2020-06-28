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

    public Quest getQuestByName(String name) {
        return questRepository.findByNameContainingIgnoreCase(name);
    }

    public Quest createQuest(QuestRequest request) {
        Quest quest = new Quest();
        quest.setName(request.getName());
        quest.setAttribute(request.getAttribute());
        quest.setKeyword(request.getKeyword());

        return questRepository.insert(quest);
    }

    public Quest replaceQuest(String name, QuestRequest request) {
        Quest oldQuest = getQuestByName(name);

        Quest newQuest = new Quest();
        newQuest.setId(oldQuest.getId());
        newQuest.setName(request.getName());
        newQuest.setAttribute(request.getAttribute());
        newQuest.setKeyword(request.getKeyword());

        return questRepository.save(newQuest);
    }

    public void deleteQuest(String name) {
        Quest selectQuest = questRepository.findByNameContainingIgnoreCase(name);
        questRepository.deleteById(selectQuest.getId());
    }

    public Weapon getWeaponById(String weaponId) {
        return weaponRepository.findByWeaponIdContainingIgnoreCase(weaponId);
    }
    public List<Weapon> getWeaponsByWeaponType(String weaponType) {
        return weaponRepository.findByWeaponTypeContainingIgnoreCase(weaponType);
    }

    public List<Weapon> getWeaponsByAttribute(String attribute) {
        return weaponRepository.findByAttributeContainingIgnoreCase(attribute);
    }

    public List<Weapon> getWeapons(WeaponQueryParameter weaponQueryParameter) {
        return weaponRepository.findByAttributeAndWeaponTypeOrderByAttribute(
                weaponQueryParameter.getAttribute(), weaponQueryParameter.getWeaponType()
        );
    }

    public Weapon createWeapon(WeaponRequest request) {
        Weapon weapon = new Weapon();

        weapon.setAttribute(request.getAttribute());
        weapon.setName(request.getName());
        weapon.setPicName(request.getPicName());
        weapon.setSeries(request.getSeries());
        weapon.setWeaponType(request.getWeaponType());
        weapon.setWeaponId(request.getWeaponId());

        return weaponRepository.insert(weapon);
    }

    public Weapon replaceWeapon(String weaponId, WeaponRequest request) {
        Weapon oldWeapon = getWeaponById(weaponId);

        Weapon newWeapon = new Weapon();
        newWeapon.setId(oldWeapon.getId());
        newWeapon.setWeaponId(weaponId);
        newWeapon.setSeries(request.getSeries());
        newWeapon.setWeaponType(request.getWeaponType());
        newWeapon.setName(request.getName());
        newWeapon.setAttribute(request.getAttribute());
        newWeapon.setPicName(request.getPicName());
        newWeapon.setWeaponId(request.getWeaponId());

        return weaponRepository.save(newWeapon);
    }

    public void deleteWeapon(String weaponId) {
        Weapon selectWeapon = weaponRepository.findByWeaponIdContainingIgnoreCase(weaponId);
        weaponRepository.deleteById(selectWeapon.getId());
    }

}
