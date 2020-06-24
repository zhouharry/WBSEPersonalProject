package ntou.wbse.hw4.entity;

import javax.validation.constraints.NotEmpty;

public class NoteRequest {

    @NotEmpty(message = "pharmacyId isn't provided.")
    private String pharmacyId;

    @NotEmpty(message = "note isn't provided.")
    private String note;

    public String getPharmacyId() {
        return pharmacyId;
    }

    /*public void setPharmacyId(String pharmacyId) {
        this.pharmacyId = pharmacyId;
    }*/

    public String getNote() {
        return note;
    }

    /*public void setNote(String note) {
        this.note = note;
    }*/
}
