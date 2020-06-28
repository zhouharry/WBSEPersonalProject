package ntou.wbse.personalproject.controller;

import ntou.wbse.personalproject.entity.*;
import ntou.wbse.personalproject.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/personalProject")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping(value = "/quest/{name}")
    public ResponseEntity<Quest> getQuest(@PathVariable("name") String name) {
        Quest quest = projectService.getQuestByName(name);
        return ResponseEntity.ok(quest);
    }

    @GetMapping(value = "/quests/{attribute}")
    public ResponseEntity<List<Quest>> getQuests(@PathVariable("attribute") String attribute) {
        List<Quest> questList = projectService.getQuestsByAttribute(attribute);
        return ResponseEntity.ok(questList);
    }

    @PostMapping(value = "/quest/create")
    public ResponseEntity<Quest> createQuest(@Valid @RequestBody QuestRequest questRequest) {
        Quest quest = projectService.createQuest(questRequest);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/")
                .buildAndExpand(quest.getId())
                .toUri();

        return ResponseEntity.created(location).body(quest);
    }

    @PostMapping(value = "/quest/{name}")
    public ResponseEntity<Quest> replaceQuest(@PathVariable("name") String name, @Valid@RequestBody QuestRequest questRequest) {
        Quest quest = projectService.replaceQuest(name, questRequest);

        return ResponseEntity.ok(quest);
    }

    @DeleteMapping(value = "/quest/{name}")
    public ResponseEntity<Quest> deleteQuest(@PathVariable("name") String name) {
        projectService.deleteQuest(name);

        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/weapons/attribute/{attribute}")
    public ResponseEntity<List<Weapon>> getWeaponsByAttribute(@PathVariable("attribute") String attribute) {
        List<Weapon> weapons = projectService.getWeaponsByAttribute(attribute);
        return ResponseEntity.ok(weapons);
    }

    @GetMapping(value = "/weapon/{weaponId}")
    public ResponseEntity<Weapon> getWeaponByWeaponId(@PathVariable("weaponId")String weaponId) {
        Weapon weapon = projectService.getWeaponById(weaponId);
        return ResponseEntity.ok(weapon);
    }

    @GetMapping(value = "/weapons/weaponType/{weaponType}")
    public ResponseEntity<List<Weapon>> getWeaponsByWeaponType(@PathVariable("weaponType")String weaponType) {
        List<Weapon> weapons = projectService.getWeaponsByWeaponType(weaponType);
        return ResponseEntity.ok(weapons);
    }

    @GetMapping(value = "/weapons")
    public ResponseEntity<List<Weapon>> getWeapons(WeaponQueryParameter weaponQueryParameter) {
        List<Weapon> weapons = projectService.getWeapons(weaponQueryParameter);

        return ResponseEntity.ok(weapons);
    }

    @PostMapping(value = "/weapon/create")
    public ResponseEntity<Weapon> createWeapon(@Valid@RequestBody WeaponRequest weaponRequest) {
        Weapon weapon = projectService.createWeapon(weaponRequest);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/")
                .buildAndExpand(weapon.getId())
                .toUri();

        return ResponseEntity.created(location).body(weapon);
    }

    @PostMapping(value = "/weapon/{weaponId}")
    public ResponseEntity<Weapon> replaceWeapon(@PathVariable("weaponId")String weaponId, @Valid@RequestBody WeaponRequest weaponRequest) {
        Weapon weapon = projectService.replaceWeapon(weaponId, weaponRequest);

        return ResponseEntity.ok(weapon);
    }

    @DeleteMapping(value = "/weapon/{weaponId}")
    public ResponseEntity<Weapon> deleteWeapon(@PathVariable("weaponId")String weaponId) {
        projectService.deleteWeapon(weaponId);

        return ResponseEntity.noContent().build();
    }
}
