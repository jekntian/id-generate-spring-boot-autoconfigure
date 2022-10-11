package online.kakapapa.service;

import online.kakapapa.properties.IdProperties;
import online.kakapapa.util.SnowflakeIdWorker;

import java.util.Objects;
import java.util.UUID;

/**
 * @author Tien.Chang
 */
public class IdGenerateService {
    private IdProperties properties;

    public IdGenerateService(IdProperties properties) {
        this.properties = properties;
    }

    public Long getSnowflakeId() {
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

    public String getSnowflakeStr() {
        return this.getSnowflakeId().toString();
    }

    public String getSnowflakeBin() {
        return Long.toBinaryString(this.getSnowflakeId());
    }

    public String getUuid() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    public String getUuidChar() {
        return this.getUuid().replace("-", "");
    }
}