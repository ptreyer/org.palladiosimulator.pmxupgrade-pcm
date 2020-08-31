package tools.descartes.pmx.pcm.builder.measuringfiles.exporter;

import org.eclipse.emf.common.util.EList;
import org.palladiosimulator.pcm.resourceenvironment.ProcessingResourceSpecification;
import org.palladiosimulator.pcm.resourceenvironment.ResourceContainer;
import org.palladiosimulator.pcm.resourceenvironment.ResourceEnvironment;
import org.palladiosimulator.pcm.resourcetype.ResourceRepository;
import org.palladiosimulator.pcm.resourcetype.ResourceType;
import org.palladiosimulator.pcm.usagemodel.UsageModel;
import org.palladiosimulator.pcm.usagemodel.UsageScenario;
import tools.descartes.pmx.pcm.builder.measuringfiles.model.measuringpoint.MeasuringPointRS;
import tools.descartes.pmx.pcm.builder.measuringfiles.model.measuringpoint.MeasuringPointRepository;
import tools.descartes.pmx.pcm.builder.measuringfiles.model.measuringpoint.MeasuringPoint;
import tools.descartes.pmx.pcm.builder.measuringfiles.model.measuringpoint.MeasuringPointUC;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MeasuringFileExporterService {

    public void createMeasuringPointFile(String outputDir, UsageModel usageModel, ResourceEnvironment resourceEnvironment, ResourceRepository resourceRepository) {
        MeasuringPointRepository measuringPointRepository = new MeasuringPointRepository();

        measuringPointRepository.getMeasuringPoints().addAll(extractResources(resourceEnvironment));
        measuringPointRepository.getMeasuringPoints().addAll(extractUsageScenario(usageModel));

        try {
            JAXBContext jCont = JAXBContext.newInstance(MeasuringPointRepository.class);
            Marshaller marshal = jCont.createMarshaller();
            marshal.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshal.marshal(measuringPointRepository, new File(outputDir + "measuring.measuringpoint"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

    private List<MeasuringPoint> extractResources(ResourceEnvironment resourceEnvironment) {
        List<MeasuringPoint> result = new ArrayList<>();

        EList<ResourceContainer> resourceContainerList = resourceEnvironment.getResourceContainer_ResourceEnvironment();
        for (ResourceContainer resourceContainer : resourceContainerList) {
            EList<ProcessingResourceSpecification> prs = resourceContainer.getActiveResourceSpecifications_ResourceContainer();

            for (ProcessingResourceSpecification processingResourceSpecification : prs) {
                MeasuringPoint measuringPoint = new MeasuringPoint();
                measuringPoint.setType(MeasuringPoint.PCMMEASURINGPOINT_AR);
                measuringPoint.setStringRepresentation(resourceContainer.getEntityName() + ", CPU");
                measuringPoint.setResourceURIRepresentation(MeasuringPoint.PCMRESOURCEURI_AR + processingResourceSpecification.getId());
                measuringPoint.setMeasuringPointRS(new MeasuringPointRS(processingResourceSpecification.getId()));
                result.add(measuringPoint);
            }
        }

        return result;
    }

    private List<MeasuringPoint> extractUsageScenario(UsageModel usageModel) {
        List<MeasuringPoint> result = new ArrayList<>();

        EList<UsageScenario> usageScenarios = usageModel.getUsageScenario_UsageModel();

        for (UsageScenario usageScenario : usageScenarios) {
            MeasuringPoint measuringPoint = new MeasuringPoint();
            measuringPoint.setType(MeasuringPoint.PCMMEASURINGPOINT_UC);
            measuringPoint.setStringRepresentation("Usage Scenario: " + usageScenario.getEntityName());
            measuringPoint.setResourceURIRepresentation(MeasuringPoint.PCMRESOURCEURI_UC + usageScenario.getId());
            measuringPoint.setMeasuringPointUC(new MeasuringPointUC(usageScenario.getId()));
            result.add(measuringPoint);
        }
        return result;
    }

    private List<MeasuringPoint> extractExternalCalls(ResourceRepository resourceRepository) {
        List<MeasuringPoint> result = new ArrayList<>();

        EList<ResourceType> resourceTypes = resourceRepository.getAvailableResourceTypes_ResourceRepository();
        for (ResourceType resourceType : resourceTypes) {
            //resourceType.
        }


        return result;
    }


}
