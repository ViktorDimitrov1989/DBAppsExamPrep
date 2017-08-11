package app.terminal;

import app.dto.add.*;
import app.dto.view.LandscapePhotographerView;
import app.dto.view.LensXmlView;
import app.dto.view.OrderedPhotographerView;
import app.dto.view.SameCamPhotographerXmlView;
import app.dto.wrappers.AddAccessoryWrapper;
import app.dto.wrappers.AddWorkshopsWrapper;
import app.dto.wrappers.SameCameraPhotographersWrapper;
import app.models.DSLRCamera;
import app.models.MirorlessCamera;
import app.models.Photographer;
import app.models.abstractions.Camera;
import app.services.*;
import app.utils.DtoMappingUtil;
import app.utils.JsonSerializer;
import app.utils.XmlSerializer;
import app.utils.constants.Constants;
import app.utils.validation.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TerminalController implements CommandLineRunner {
    //services and utils comes here autowire them
    private LensService lensService;
    private CameraService cameraService;
    private PhotographerService photographerService;
    private AccessoriesService accessoriesService;
    private WorkshopService workshopService;

    //utils
    private JsonSerializer jsonSerializer;
    private XmlSerializer xmlSerializer;

    @Autowired
    public TerminalController(LensService lensService,
                              CameraService cameraService,
                              PhotographerService photographerService,
                              AccessoriesService accessoriesService,
                              WorkshopService workshopService,
                              JsonSerializer jsonSerializer,
                              XmlSerializer xmlSerializer) {
        this.lensService = lensService;
        this.cameraService = cameraService;
        this.photographerService = photographerService;
        this.accessoriesService = accessoriesService;
        this.workshopService = workshopService;
        this.jsonSerializer = jsonSerializer;
        this.xmlSerializer = xmlSerializer;
    }

    @Override
    public void run(String... strings) throws Exception {
        //importLenses();
        //importCameras();
        //importPhotographers();
        //importAccessories();
        //importWorkshops();
        //exportOrderedPhotographers();
        //exportLandscapePhotographers();
        exportPhotographersWithSameCameraMake();

    }

    private void exportPhotographersWithSameCameraMake() {
        List<SameCamPhotographerXmlView> photographersViews = this.photographerService.sameCamMakePhotographers();

        for (SameCamPhotographerXmlView photographer : photographersViews) {
            photographer.setFullName(photographer.getFirstName() + " " + photographer.getLastName());
            photographer.setPrimeCam(photographer.getPrimaryCamera().getMake() + " " + photographer.getPrimaryCamera().getModel());
        }

        /*photographersViews = photographersViews
                .stream()
                .filter(x -> x.getLenses().getLenses().size() > 0)
                .collect(Collectors.toList());*/

        for (SameCamPhotographerXmlView photographer : photographersViews) {
            if(photographer.getLenses().getLenses().size() == 0){
                photographer.setLenses(null);
            }

            if(photographer.getLenses() != null){
                for (LensXmlView lens : photographer.getLenses().getLenses()) {
                    String make = lens.getMake();
                    int focalLength = lens.getFocalLength();
                    double maxAperture = lens.getMaxAperture();

                    lens.setInfo(String.format("%s %smm f%s", make, focalLength, maxAperture));
                }
            }

        }

        SameCameraPhotographersWrapper photographersWrapper = new SameCameraPhotographersWrapper();
        photographersWrapper.setPhotographers(photographersViews);

        this.xmlSerializer.serialize(photographersWrapper,
                Constants.OUTPUT_XML_FILES_PATH + Constants.OUTPUT_XML_SAME_CAMERAS_PHOTOGRAPHERS_FILE);

    }

    private void exportLandscapePhotographers() {
        List<LandscapePhotographerView> photographers = this.photographerService
                .findAllLandscapePhotographers();

        this.jsonSerializer.serialize(photographers,
                Constants.OUTPUT_JSON_FILES_PATH + Constants.OUTPUT_JSON_LANDSCAPE_PHOTOGRAPHERS_FILE);
    }

    private void exportOrderedPhotographers() {
        List<OrderedPhotographerView> photographerViews = this.photographerService.findAllOrderePhotographers();

        for (OrderedPhotographerView photographer : photographerViews) {
            if (photographer.getPhone() == null){
                photographer.setPhone("null");
            }
        }

        this.jsonSerializer.serialize(photographerViews,
                Constants.OUTPUT_JSON_FILES_PATH + Constants.OUTPUT_JSON_ORDERED_PHOTOGRAPHERS_FILE);

    }

    private void importWorkshops() {
        AddWorkshopsWrapper workshopsWrapper = this.xmlSerializer.deserialize(AddWorkshopsWrapper.class,
                Constants.INPUT_XML_FILES_PATH + Constants.INPUT_XML_WORKSHOPS_FILE);

        String debug = "";

        this.workshopService.saveWorkshops(workshopsWrapper);

    }

    private void importAccessories() {
        AddAccessoryWrapper accessoryWrapper = this.xmlSerializer.deserialize(AddAccessoryWrapper.class,
                Constants.INPUT_XML_FILES_PATH + Constants.INPUT_XML_ACCESSORIES_FILE);

        this.accessoriesService.saveAccessories(accessoryWrapper.getAccessories());
    }

    private void importPhotographers() {
        AddPhotographerDto[] photographers = this.jsonSerializer.deserialize(AddPhotographerDto[].class,
                Constants.INPUT_JSON_FILES_PATH + Constants.INPUT_JSON_PHOTOGRAPHERS_FILE);

        for (AddPhotographerDto photographerDto : photographers) {
            Photographer photographer = DtoMappingUtil.convert(photographerDto, Photographer.class);
            this.photographerService.savePhotographer(photographer, photographerDto.getLensesIds());
        }

    }

    private void importCameras() {
        AddCameraDto[] cameras = this.jsonSerializer.deserialize(AddCameraDto[].class,
                Constants.INPUT_JSON_FILES_PATH + Constants.INPUT_JSON_CAMERAS_FILE);

        for (AddCameraDto camera : cameras) {
            Camera cam = null;
            if ("DSLR".equals(camera.getType())) {
                cam = DtoMappingUtil.convert(camera, DSLRCamera.class);
                this.cameraService.saveCamera(cam);
            } else if ("Mirrorless".equals(camera.getType())) {
                cam = DtoMappingUtil.convert(camera, MirorlessCamera.class);
                this.cameraService.saveCamera(cam);
            }

        }
    }

    private void importLenses() {
        AddLensDto[] lenses = this.jsonSerializer.deserialize(AddLensDto[].class,
                Constants.INPUT_JSON_FILES_PATH + Constants.INPUT_JSON_LENS_FILE);

        for (AddLensDto lense : lenses) {
            try {
                this.lensService.saveLens(lense);
                System.out.println(lense);
            } catch (Exception e) {
                System.out.println("Error invalid data provided!");
            }
        }
    }


}
