package app.models;

import javax.persistence.*;

@Entity
@Table(name = "accessories")
public class Accessory {
    private Long id;
    private String name;
    private Photographer owner;

    public Accessory() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accessory_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    @JoinColumn(name = "photographer_id")
    public Photographer getOwner() {
        return owner;
    }

    public void setOwner(Photographer owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return String.format("%s", this.name);
    }
}
