package app.models;

import app.models.abstractions.Camera;
import app.validators.phone.Phone;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "photographers")
public class Photographer {
    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private Camera primaryCamera;
    private Camera secondaryCamera;
    private List<Lens> lenses;
    private List<Accessory> accessories;
    private List<WorkShop> workShops;
    private List<WorkShop> trainedWorkshops;

    public Photographer() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "photographer_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @NotNull
    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Phone
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @NotNull
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "primary_camera_id")
    public Camera getPrimaryCamera() {
        return primaryCamera;
    }

    public void setPrimaryCamera(Camera primaryCamera) {
        this.primaryCamera = primaryCamera;
    }

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "secondary_camera_id")
    public Camera getSecondaryCamera() {
        return secondaryCamera;
    }

    public void setSecondaryCamera(Camera secondaryCamera) {
        this.secondaryCamera = secondaryCamera;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "owner")
    public List<Lens> getLenses() {
        return lenses;
    }

    public void setLenses(List<Lens> lenses) {
        this.lenses = lenses;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "owner")
    public List<Accessory> getAccessories() {
        return accessories;
    }

    public void setAccessories(List<Accessory> accessories) {
        this.accessories = accessories;
    }

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "participant")
    public List<WorkShop> getWorkShops() {
        return workShops;
    }

    public void setWorkShops(List<WorkShop> workShops) {
        this.workShops = workShops;
    }

    @OneToMany(mappedBy = "trainer")
    public List<WorkShop> getTrainedWorkshops() {
        return trainedWorkshops;
    }

    public void setTrainedWorkshops(List<WorkShop> tranedWorkshops) {
        this.trainedWorkshops = tranedWorkshops;
    }

    @Override
    public String toString() {
        return String.format("%s %s | Lenses: %d", this.firstName, this.lastName, this.lenses.size());
    }
}
