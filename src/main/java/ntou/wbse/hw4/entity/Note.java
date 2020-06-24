package ntou.wbse.hw4.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Note")
public class Note {
	private String id;
	private String pharmacyId;
	private String note;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPharmacyId() {
		return pharmacyId;
	}

	public void setPharmacyId(String pharmacyId) {
		this.pharmacyId = pharmacyId;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "Note [id=" + id + ", pharmacyId=" + pharmacyId + ", note=" + note + "]";
	}

}
