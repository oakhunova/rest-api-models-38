package models;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data

public class UpdateUserResponse {
    String name, job;
}
