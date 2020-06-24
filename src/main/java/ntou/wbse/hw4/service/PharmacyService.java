package ntou.wbse.hw4.service;

import ntou.wbse.hw4.entity.Note;
import ntou.wbse.hw4.entity.NoteRequest;
import ntou.wbse.hw4.entity.Pharmacy;
import ntou.wbse.hw4.entity.QueryParameter;
import ntou.wbse.hw4.exception.NotFoundException;
import ntou.wbse.hw4.model.MaskHandler;
import ntou.wbse.hw4.repository.PharmacyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@Service
public class PharmacyService {

    @Autowired
    private MaskHandler maskHandler;

    @Autowired
    private PharmacyRepository repository;

    public PharmacyService(MaskHandler maskHandler, PharmacyRepository repository) {
        this.repository = repository;
        this.maskHandler = maskHandler;
        try {
            this.maskHandler.initialize();
        } catch (IOException | URISyntaxException e) {
            System.err.println(e);
        }

    }

    public Pharmacy getPharmacy(String id) {
        return maskHandler.getPharmacy(id);
    }

    public List<Pharmacy> getPharmacies(QueryParameter queryParameter) {
        return maskHandler.findPharmacies(queryParameter.getPharmacyName(), queryParameter.getZone());
    }

    public Note createNote(String pharmacyId, String noteContent) {
        Note note = new Note();
        note.setPharmacyId(pharmacyId);
        note.setNote(noteContent);

        return repository.insert(note);
    }

    public Note replaceNote(String pharmacyId, NoteRequest request) {
        Note oldNote = repository.findByPharmacyIdContainingIgnoreCase(pharmacyId);
        Note newNote = new Note();

        newNote.setId(oldNote.getId());
        newNote.setPharmacyId(request.getPharmacyId());
        newNote.setNote(request.getNote());

        return repository.save(newNote);
    }

    public void deleteNote(String pharmacyId) {
        Note selectNote = repository.findByPharmacyIdContainingIgnoreCase(pharmacyId);
        repository.deleteById(selectNote.getId());
    }
}
