package app.dto.add;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddLensDto {
    @Expose
    private String make;
    @Expose
    private int focalLength;
    @Expose
    private double maxAperture;
    @Expose
    private String compatibleWith;

    public AddLensDto() {
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getFocalLength() {
        return focalLength;
    }

    public void setFocalLength(int focalLength) {
        this.focalLength = focalLength;
    }

    public double getMaxAperture() {
        return maxAperture;
    }

    public void setMaxAperture(double maxAperture) {
        this.maxAperture = maxAperture;
    }

    public String getCompatibleWith() {
        return compatibleWith;
    }

    public void setCompatibleWith(String compatibleWith) {
        this.compatibleWith = compatibleWith;
    }

    @Override
    public String toString() {
        return String.format("Successfully imported %s %s f%.1f", this.make, this.focalLength, this.maxAperture);
    }
}
