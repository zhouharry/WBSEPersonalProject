package ntou.wbse.personalproject.repository;

import ntou.wbse.personalproject.entity.Weapon;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeaponRepository extends MongoRepository<Weapon, String> {
    
	List<Weapon> findByNameContainingIgnoreCase(String questName);
	
	List<Weapon> findByAttributeContainingIgnoreCase(String attribute);
}
