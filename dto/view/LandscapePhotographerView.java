package app.dto.view;

import app.models.Lens;
import app.models.abstractions.Camera;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.springframework.data.annotation.Transient;

import java.util.List;

public class LandscapePhotographerView {
    @Expose
    @SerializedName("FirstName")
    private String firstName;
    @Expose
    @SerializedName("LastName")
    private String lastName;
    @Expose
    @SerializedName("CameraMake")
    private String camProd;

    private LandscapeCameraView primaryCamera;
    @Expose
    @SerializedName("LensesCount")
    private int lensesCount;

    private List<Lens> lenses;

    public LandscapePhotographerView() {
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

    public String getCamProd() {
        return camProd;
    }

    public void setCamProd(String camProd) {
        this.camProd = camProd;
    }

    public LandscapeCameraView getPrimaryCamera() {
        return primaryCamera;
    }

    public void setPrimaryCamera(LandscapeCameraView primaryCamera) {
        this.primaryCamera = primaryCamera;
    }

    public int getLensesCount() {
        return lensesCount;
    }

    public void setLensesCount(int lensesCount) {
        this.lensesCount = lensesCount;
    }

    public List<Lens> getLenses() {
        return lenses;
    }

    public void setLenses(List<Lens> lenses) {
        this.lenses = lenses;
    }
}
