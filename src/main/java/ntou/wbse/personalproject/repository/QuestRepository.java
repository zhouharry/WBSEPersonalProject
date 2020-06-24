package ntou.wbse.personalproject.repository;

import ntou.wbse.personalproject.entity.Quest;

import ntou.wbse.personalproject.entity.QuestQueryParameter;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestRepository extends MongoRepository<Quest, String> {
    
	Quest findByNameContainingIgnoreCase(String questName);

	List<Quest> findByAttributeContainingIgnoreCase(String attribute);

}