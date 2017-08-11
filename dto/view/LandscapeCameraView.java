package app.dto.view;

import com.google.gson.annotations.Expose;

public class LandscapeCameraView {
    @Expose
    private String make;

    public LandscapeCameraView() {
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }
}
