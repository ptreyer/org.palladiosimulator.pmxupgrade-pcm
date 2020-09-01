package tools.descartes.pmx.pcm.builder.measuringfiles.model.monitorrepository;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import java.util.UUID;

@XmlAccessorType(XmlAccessType.FIELD)
public class MetricDescription {

    @XmlAttribute(name="xsi:type")
    private final String type = "metricspec:NumericalBaseMetricDescription";

    @XmlAttribute(name="href")
    private String href = "pathmap://METRIC_SPEC_MODELS/commonMetrics.metricspec#";

    // TODO id, woher?
    public MetricDescription() {
        this.href = href + "_" + UUID.randomUUID().toString().replaceAll("-", "");;
    }

    public String getType() {
        return type;
    }

    public String getHref() {
        return href;
    }
}
