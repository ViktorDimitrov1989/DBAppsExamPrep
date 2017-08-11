package app.models.abstractions;

import app.models.Photographer;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cameras")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public abstract class Camera {
    private Long id;
    private String make;
    private String model;
    private boolean isFullFrame;
    private int minIso;
    private int maxIso;
    //private Photographer owner;

    private String cameraType;

    public Camera() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "camera_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    @Column(name = "make")
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @NotNull
    @Column(name = "model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Column(name = "is_full_frame")
    public boolean isFullFrame() {
        return isFullFrame;
    }

    public void setFullFrame(boolean fullFrame) {
        isFullFrame = fullFrame;
    }

    @NotNull
    @Min(value = 100)
    @Column(name = "min_iso")
    public int getMinIso() {
        return minIso;
    }

    public void setMinIso(int minIso) {
        this.minIso = minIso;
    }

    @Column(name = "max_iso")
    public int getMaxIso() {
        return maxIso;
    }

    public void setMaxIso(int maxIso) {
        this.maxIso = maxIso;
    }

    /*@OneToOne
    public Photographer getOwner() {
        return owner;
    }*/

    /*public void setOwner(Photographer owner) {
        this.owner = owner;
    }*/

    @Column(name="type", nullable=false, updatable=false, insertable=false)
    protected String getCameraType() {
        return cameraType;
    }

    public void setCameraType(String cameraType) {
        this.cameraType = cameraType;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", this.cameraType, this.make, this.model);
    }
}
