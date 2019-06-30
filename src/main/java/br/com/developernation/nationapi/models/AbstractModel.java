package br.com.developernation.nationapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import java.sql.Date;

@Data
public class AbstractModel {

    @Id
    @JsonProperty("id")
    private String id;

    @LastModifiedDate
    @JsonProperty("lastModified")
    private Date lastModified;

    @CreatedDate
    @JsonProperty("createdAt")
    private Date createdAt;
}
