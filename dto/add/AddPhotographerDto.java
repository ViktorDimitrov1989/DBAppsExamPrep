package app.dto.add;

import app.models.Lens;
import app.models.abstractions.Camera;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class AddPhotographerDto {
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private String phone;
    @Expose
    @SerializedName("lenses")
    private List<Long> lensesIds;
    private Camera primaryCamera;
    private Camera secondaryCamera;
    private List<Lens> lenses;

    public AddPhotographerDto() {
        lenses = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Camera getPrimaryCamera() {
        return primaryCamera;
    }

    public void setPrimaryCamera(Camera primaryCamera) {
        this.primaryCamera = primaryCamera;
    }

    public Camera getSecondaryCamera() {
        return secondaryCamera;
    }

    public void setSecondaryCamera(Camera secondaryCamera) {
        this.secondaryCamera = secondaryCamera;
    }

    public List<Lens> getLenses() {
        return lenses;
    }

    public void setLenses(List<Lens> lenses) {
        this.lenses = lenses;
    }

    public List<Long> getLensesIds() {
        return lensesIds;
    }

    public void setLensesIds(List<Long> lensesIds) {
        this.lensesIds = lensesIds;
    }

    @Override
    public String toString() {
        return String.format("%s %s | Lenses: %d", this.firstName, this.lastName, this.lenses.size());
    }
}
