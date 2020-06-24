package ntou.wbse.personalproject.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

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

import ntou.wbse.personalproject.entity.*;
import ntou.wbse.personalproject.service.*;

@RestController
@RequestMapping(value = "/weapons")
public class WeaponController {

	@Autowired
	private WeaponService weaponService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Weapon> getWeapon(@PathVariable("id") String id) {
		Weapon weapon = weaponService.getWeapon(id);
		return ResponseEntity.ok(weapon);
	}
	
	/*@GetMapping(value = "/{attribute}")
	public ResponseEntity<Weapon> getWeaponByAttribute(@PathVariable("attribute") String attribute) {
		Weapon weapon = weaponService.getWeapon(attribute);
		return ResponseEntity.ok(weapon);
	}*/
	
	@PostMapping
	public ResponseEntity<Weapon> createWeapon(@Valid @RequestBody WeaponRequest request) {
		Weapon weapon = weaponService.createWeapon(request);
		
		URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(weapon.getId())
                .toUri();

        return ResponseEntity.created(location).body(weapon);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Weapon> replaceWeapon(
	        @PathVariable("id") String id, @Valid @RequestBody WeaponRequest request) {
	    Weapon weapon = weaponService.replaceWeapon(id, request);
	    return ResponseEntity.ok(weapon);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Weapon> deleteWeapon(@PathVariable("id") String id) {
	    weaponService.deleteWeapon(id);
	    return ResponseEntity.noContent().build();
	}

	@GetMapping
	public ResponseEntity<List<Weapon>> getWeapons(@ModelAttribute QuestQueryParameter param) {
	    List<Weapon> weapons = weaponService.getWeapons(param);
	    return ResponseEntity.ok(weapons);
	}
	
	@GetMapping(value = "/{attribute}")
	public ResponseEntity<List<Weapon>> getWeaponsByAttribute(@PathVariable("attribute") String attribute, @ModelAttribute QuestQueryParameter param) {
		param.setKeyword(attribute);
		List<Weapon> weapons = weaponService.getWeapons(param);
	    return ResponseEntity.ok(weapons);
	}
}
