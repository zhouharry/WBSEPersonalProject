package ntou.wbse.personalproject.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import ntou.wbse.personalproject.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import ntou.wbse.personalproject.entity.Quest;
import ntou.wbse.personalproject.entity.QuestRequest;
import ntou.wbse.personalproject.entity.QuestQueryParameter;

@RestController
@RequestMapping(value = "/quests")
public class QuestController {

	@Autowired
	private ProjectService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Quest> getQuest(@PathVariable("id") String id) {
		Quest quest = questService.getQuest(id);
		return ResponseEntity.ok(quest);
	}
	
	@PostMapping
	public ResponseEntity<Quest> createQuest(@Valid @RequestBody QuestRequest request) {
		Quest quest = questService.createQuest(request);
		
		URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(quest.getId())
                .toUri();

        return ResponseEntity.created(location).body(quest);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Quest> replaceQuest(
	        @PathVariable("id") String id, @Valid @RequestBody QuestRequest request) {
		Quest quest = questService.replaceQuest(id, request);
	    return ResponseEntity.ok(quest);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Quest> deleteProduct(@PathVariable("id") String id) {
	    questService.deleteQuest(id);
	    return ResponseEntity.noContent().build();
	}

	@GetMapping
	public ResponseEntity<List<Quest>> getProducts(@ModelAttribute QuestQueryParameter param) {
	    List<Quest> quest = questService.getQuests(param);
	    return ResponseEntity.ok(quest);
	}
}
