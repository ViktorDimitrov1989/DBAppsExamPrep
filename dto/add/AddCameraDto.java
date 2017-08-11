package app.dto.add;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class AddCameraDto {
    @Expose
    @NotNull
    private String make;
    @Expose
    @NotNull
    private String model;
    @Expose
    private boolean isFullFrame;
    @Expose
    @SerializedName(value = "minISO")
    @Min(value = 100)
    @NotNull
    private int minIso;
    @Expose
    @SerializedName(value = "maxISO")
    private int maxIso;
    @Expose
    @SerializedName(value = "MaxShutterSpeed")
    private int maxShutterSpeed;
    @Expose
    private String maxVideoResolution;
    @Expose
    @SerializedName(value = "maxFrameRate")
    private int maxFrame;
    @Expose
    private String type;

    public AddCameraDto() {
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isFullFrame() {
        return isFullFrame;
    }

    public void setFullFrame(boolean fullFrame) {
        isFullFrame = fullFrame;
    }

    public int getMinIso() {
        return minIso;
    }

    public void setMinIso(int minIso) {
        this.minIso = minIso;
    }

    public int getMaxIso() {
        return maxIso;
    }

    public void setMaxIso(int maxIso) {
        this.maxIso = maxIso;
    }

    public int getMaxShutterSpeed() {
        return maxShutterSpeed;
    }

    public void setMaxShutterSpeed(int maxShutterSpeed) {
        this.maxShutterSpeed = maxShutterSpeed;
    }

    public String getMaxVideoResolution() {
        return maxVideoResolution;
    }

    public void setMaxVideoResolution(String maxVideoResolution) {
        this.maxVideoResolution = maxVideoResolution;
    }

    public int getMaxFrame() {
        return maxFrame;
    }

    public void setMaxFrame(int maxFrame) {
        this.maxFrame = maxFrame;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
