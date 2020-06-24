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

    @GetMapping(value = "quest/{name}")
    public ResponseEntity<Quest> getQuest(@PathVariable("name") String name) {
        Quest quest = projectService.getQuestByName(name);
        return ResponseEntity.ok(quest);
    }

    @GetMapping(value = "weapon/{name}")
    public ResponseEntity<List<Weapon>> getWeaponsByName(@PathVariable("name") String name) {
        List<Weapon> weaponList = projectService.getWeaponsByName(name);
        return ResponseEntity.ok(weaponList);
    }

    @GetMapping(value = "quest/{attribute}")
    public ResponseEntity<List<Quest>> getQuests(@PathVariable("attribute") String attribute) {
        List<Quest> questList = projectService.getQuestsByAttribute(attribute);
        return ResponseEntity.ok(questList);
    }

    @GetMapping(value = "weapon/{attribute}")
    public ResponseEntity<List<Weapon>> getWeaponsByAttribute(@PathVariable("attribute") String attribute) {
        List<Weapon> weaponList = projectService.getWeaponsByAttribute(attribute);
        return ResponseEntity.ok(weaponList);
    }

    @PostMapping(value = "/quest/{name}/create")
    public ResponseEntity<Quest> createQuest(@Valid @RequestBody QuestRequest questRequest) {
        Quest quest = projectService.createQuest(questRequest);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{name}")
                .buildAndExpand(quest.getId())
                .toUri();

        return ResponseEntity.created(location).body(quest);
    }
}
