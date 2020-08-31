package tools.descartes.pmx.pcm.builder.measuringfiles.model.monitorrepository;

import org.palladiosimulator.pcm.core.CoreFactory;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class ProcessingType {

    @XmlAttribute(name="id")
    private String id;

    @XmlAttribute(name="xsi:type")
    private final String type = "monitorrepository:FeedThrough";

    public ProcessingType() {
        this.id = "" + CoreFactory.eINSTANCE.createPCMRandomVariable();
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }
}
