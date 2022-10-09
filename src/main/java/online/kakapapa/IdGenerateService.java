package online.kakapapa;

import java.util.Objects;

/**
 * @author Tien.Chang
 */
public class IdGenerateService {
    private IdProperties properties;

    public IdGenerateService(IdProperties properties) {
        this.properties = properties;
    }

    public Long generate() {
        if ((Objects.isNull(properties.getDataCenterId()) || Objects.isNull(properties.getWorkId())) && Objects.isNull(properties.getEpochDate())) {
            return new SnowflakeIdWorker().nextId();
        } else if (Objects.nonNull(properties.getDataCenterId()) && Objects.nonNull(properties.getWorkId()) && Objects.nonNull(properties.getEpochDate())) {
            return new SnowflakeIdWorker(properties.getWorkId(), properties.getDataCenterId(), properties.getEpochDate().getTime()).nextId();
        } else if (Objects.nonNull(properties.getEpochDate())) {
            return new SnowflakeIdWorker(properties.getEpochDate().getTime()).nextId();
        } else {
            return new SnowflakeIdWorker(properties.getWorkId(), properties.getWorkId()).nextId();
        }
    }

    public String generateStr() {
        return this.generate().toString();
    }

    public String generateBinary() {
        return Long.toBinaryString(this.generate());
    }
}