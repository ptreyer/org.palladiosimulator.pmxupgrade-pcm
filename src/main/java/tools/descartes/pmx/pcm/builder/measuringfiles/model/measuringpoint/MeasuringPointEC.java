package tools.descartes.pmx.pcm.builder.measuringfiles.model.measuringpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class MeasuringPointEC {

    // TODO
    @XmlAttribute(name = "href")
    private String href = "extracted.repository#";

    public MeasuringPointEC(String id) {
        this.href = href + id;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
