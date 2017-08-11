package app.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "workshops")
public class WorkShop {
    private Long id;
    private String name;
    private Date startDate;
    private Date endDate;
    private String location;
    private double pricePerParticipant;
    private Photographer trainer;
    private List<Photographer> participants;

    public WorkShop() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "workshop_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "start_date")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Column(name = "end_date")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @NotNull
    @Column(name = "location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @NotNull
    @Column(name = "price_per_participant")
    public double getPricePerParticipant() {
        return pricePerParticipant;
    }

    public void setPricePerParticipant(double pricePerParticipant) {
        this.pricePerParticipant = pricePerParticipant;
    }

    @NotNull
    @ManyToOne
    @JoinColumn(name = "photographer_trainer_id")
    public Photographer getTrainer() {
        return trainer;
    }

    public void setTrainer(Photographer trainer) {
        this.trainer = trainer;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "workshops_photographers", joinColumns =
    @JoinColumn(name = "workshop_id", referencedColumnName = "workshop_id"),
            inverseJoinColumns = @JoinColumn(name = "photographer_id", referencedColumnName = "photographer_id"))
    public List<Photographer> getParticipant() {
        return participants;
    }

    public void setParticipant(List<Photographer> participant) {
        this.participants = participant;
    }
}
