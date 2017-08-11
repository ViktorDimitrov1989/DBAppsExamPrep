package app.models;

import javax.persistence.*;
import javax.validation.constraints.Digits;

@Entity
@Table(name = "lenses")
public class Lens {
    private Long id;
    private String make;
    private int focalLength;
    private double maxAperture;
    private String compatibleWith;
    private Photographer owner;

    public Lens() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lens_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "make")
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @Column(name = "focal_length")
    public int getFocalLength() {
        return focalLength;
    }

    public void setFocalLength(int focalLength) {
        this.focalLength = focalLength;
    }

    @Digits(integer = 6, fraction = 1)
    @Column(name = "max_aperture")
    public double getMaxAperture() {
        return maxAperture;
    }

    public void setMaxAperture(double maxAperture) {
        this.maxAperture = maxAperture;
    }

    @Column(name = "compatible_width")
    public String getCompatibleWith() {
        return compatibleWith;
    }

    public void setCompatibleWith(String compatibleWith) {
        this.compatibleWith = compatibleWith;
    }

    @ManyToOne
    @JoinColumn(name = "photographer_id")
    public Photographer getOwner() {
        return owner;
    }

    public void setOwner(Photographer owner) {
        this.owner = owner;
    }
}
