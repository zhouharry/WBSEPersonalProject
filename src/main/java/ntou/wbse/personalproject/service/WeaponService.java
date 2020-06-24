package ntou.wbse.personalproject.service;

import ntou.wbse.personalproject.entity.*;
import ntou.wbse.personalproject.exception.*;
import ntou.wbse.personalproject.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class WeaponService {
    
	@Autowired
	private WeaponRepository repository;
	
	public WeaponService(WeaponRepository repository) {
		this.repository = repository;
	}
	
	public Weapon getWeapon(String id) {
		return repository.findById(id).orElseThrow(() -> new NotFoundException("Can't find weapon. "));
	}
	
	/*public Weapon getWeaponByAttribute(String attribute) {
		return repository.findByAttribute(attribute).orElseThrow(() -> new NotFoundException("Can't find weapon. "));
	}*/
	
	public Weapon createWeapon(WeaponRequest request) {
		Weapon weapon = new Weapon();
		weapon.setSeries(request.getSeries());
		weapon.setAttribute(request.getAttribute());
		weapon.setType(request.getType());
		weapon.setName(request.getName());
		
		return repository.insert(weapon);
	}
	
	public Weapon replaceWeapon(String id, WeaponRequest request) {
		Weapon oldWeapon = getWeapon(id);
		
		Weapon newWeapon = new Weapon();
		newWeapon.setId(oldWeapon.getId());
		newWeapon.setSeries(request.getSeries());
		newWeapon.setAttribute(request.getAttribute());
		newWeapon.setType(request.getType());
		newWeapon.setType(request.getName());
		
		return repository.save(newWeapon);
	}
	
	public void deleteWeapon(String id) {
		repository.deleteById(id);
	}
	
	public List<Weapon> getWeapons(QuestQueryParameter param) {
		String orderedBy = param.getOrderedBy();
		String sortRule = param.getSortRule();
		String keyword = param.getKeyword();

		Sort sort = null;
		if (orderedBy != null && sortRule != null) {
			Sort.Direction direction = sortRule.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;

			sort = Sort.by(direction, orderedBy);
		}

		if (keyword == null) {
			keyword = "";
		}

		if (sort != null) {
			return repository.findByNameContainingIgnoreCase(keyword, sort);
		} else {
			return repository.findByAttributeContainingIgnoreCase(keyword);
		}
	}
}
