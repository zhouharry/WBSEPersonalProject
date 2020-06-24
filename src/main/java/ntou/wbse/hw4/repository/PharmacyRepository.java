package ntou.wbse.hw4.repository;

import ntou.wbse.hw4.entity.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PharmacyRepository extends MongoRepository<Note, String> {

    Note findByPharmacyIdContainingIgnoreCase(String pharmacyId);

}
