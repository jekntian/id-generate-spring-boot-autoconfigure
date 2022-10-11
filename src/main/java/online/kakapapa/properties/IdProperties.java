package online.kakapapa.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author Tien.Chang
 */
@ConfigurationProperties(prefix = IdProperties.PREFIX)
public class IdProperties {
    public static final String PREFIX = "kakapapa";

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date epochDate;
    private Long workId;
    private Long dataCenterId;

    public Date getEpochDate() {
        return epochDate;
    }

    public void setEpochDate(Date epochDate) {
        this.epochDate = epochDate;
    }

    public Long getWorkId() {
        return workId;
    }

    public void setWorkId(Long workId) {
        this.workId = workId;
    }

    public Long getDataCenterId() {
        return dataCenterId;
    }

    public void setDataCenterId(Long dataCenterId) {
        this.dataCenterId = dataCenterId;
    }
}