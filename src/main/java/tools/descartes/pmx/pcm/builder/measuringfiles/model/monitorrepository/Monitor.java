package tools.descartes.pmx.pcm.builder.measuringfiles.model.monitorrepository;

import org.palladiosimulator.pcm.core.CoreFactory;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.UUID;

@XmlAccessorType(XmlAccessType.FIELD)
public class Monitor {

    public static final String ENTITYNAME_UC = "UsageScenarioMonitor";
    public static final String ENTITYNAME_AR = "ActiveResourceMonitor";
    public static final String ENTITYNAME_EC = "ExternalCallActionMonitor";

    @XmlAttribute(name="id")
    private String id;

    @XmlAttribute(name="entityName")
    private String entityName;

    @XmlElement(name="measurementSpecifications")
    private MeasurementSpecification measurementSpecification;

    @XmlElement(name="measuringPoint")
    private MeasuringPointRef measuringPoint;

    public Monitor() {
        this.id = "_" + UUID.randomUUID().toString().replaceAll("-", "");
    }

    public String getId() {
        return id;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public MeasurementSpecification getMeasurementSpecification() {
        return measurementSpecification;
    }

    public void setMeasurementSpecification(MeasurementSpecification measurementSpecification) {
        this.measurementSpecification = measurementSpecification;
    }

    public MeasuringPointRef getMeasuringPoint() {
        return measuringPoint;
    }

    public void setMeasuringPoint(MeasuringPointRef measuringPoint) {
        this.measuringPoint = measuringPoint;
    }
}
