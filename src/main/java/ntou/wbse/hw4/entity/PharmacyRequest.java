package ntou.wbse.hw4.entity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PharmacyRequest {

    @NotEmpty(message = "Pharmacy name isn't provided.")
    private String name;

    @NotEmpty(message = "Pharmacy adderss isn't provided.")
    private String address;

    @NotEmpty(message = "Pharmacy phone isn't provided.")
    private String phone;

    @NotNull
    @Min(value = 0, message = "Number of Adult Masks can't smaller than 0.")
    private int numberOfAdultMasks;

    @NotNull
    @Min(value = 0, message = "Number of Children Masks can't smaller than 0.")
    private int numberOfChildrenMasks;

    @NotEmpty(message = "Update time isn't provided.")
    private String updatedTime;

    @NotEmpty(message = "Note isn't provided.")
    private String note;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getNumberOfAdultMasks() {
        return numberOfAdultMasks;
    }

    public void setNumberOfAdultMasks(int numberOfAdultMasks) {
        this.numberOfAdultMasks = numberOfAdultMasks;
    }

    public int getNumberOfChildrenMasks() {
        return numberOfChildrenMasks;
    }

    public void setNumberOfChildrenMasks(int numberOfChildrenMasks) {
        this.numberOfChildrenMasks = numberOfChildrenMasks;
    }

    public String getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
