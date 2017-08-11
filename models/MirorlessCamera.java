package app.models;

import app.models.abstractions.Camera;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Mirorless")
public class MirorlessCamera extends Camera {
    private String maxVideoResolution;
    private int maxFrame;

    public MirorlessCamera() {
    }

    @Column(name = "max_video_resolution")
    public String getMaxVideoResolution() {
        return maxVideoResolution;
    }

    public void setMaxVideoResolution(String maxVideoResolution) {
        this.maxVideoResolution = maxVideoResolution;
    }

    @Column(name = "max_frame")
    public int getMaxFrame() {
        return maxFrame;
    }

    public void setMaxFrame(int maxFrame) {
        this.maxFrame = maxFrame;
    }
}
