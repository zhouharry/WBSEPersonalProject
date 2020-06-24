package ntou.wbse.hw4.controller;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import ntou.wbse.hw4.entity.*;
import ntou.wbse.hw4.service.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.BooleanOperators;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/pharmacy")
public class PharmacyController {

    @Autowired
    private PharmacyService pharmacyService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pharmacy> getPharmacy(@PathVariable("id") String id) {
        Pharmacy pharmacy = pharmacyService.getPharmacy(id);
        return ResponseEntity.ok(pharmacy);
    }

    @GetMapping
    public ResponseEntity<List<Pharmacy>> getPharmacies(QueryParameter queryParameter) {
        List<Pharmacy> pharmacies = pharmacyService.getPharmacies(queryParameter);
        return ResponseEntity.ok(pharmacies);
    }

    /*@PostMapping(value = "/{id}/note")
    public ResponseEntity<Note> createNote(@PathVariable("id")String pharmacyId, NoteRequest request) {
        Note note = pharmacyService.createNote(pharmacyId, request.getNote());

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(note.getId())
                .toUri();
        return ResponseEntity.created(location).body(note);
    }

    @DeleteMapping(value = "/{id}/note")
    public ResponseEntity<Note> deleteNote(@PathVariable("id") String pharmacyId) {
        pharmacyService.deleteNote(pharmacyId);
        return ResponseEntity.noContent().build();
    }*/
}
