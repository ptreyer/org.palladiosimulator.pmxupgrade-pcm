package tools.descartes.pmx.pcm.builder.measuringfiles.model.monitorrepository;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class MetricDescription {

    @XmlAttribute(name="xsi:type")
    private final String type = "metricspec:NumericalBaseMetricDescription";

    //TODO
    @XmlAttribute(name="href")
    private final String href = "pathmap://METRIC_SPEC_MODELS/commonMetrics.metricspec#_6rYmYs7nEeOX_4BzImuHbA";

    public String getType() {
        return type;
    }

    public String getHref() {
        return href;
    }
}
