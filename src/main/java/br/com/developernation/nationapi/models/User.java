package br.com.developernation.nationapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

@Data
@NoArgsConstructor
@Document(collection = "users")
public class User extends AbstractModel{

    @JsonProperty("username")
    @NonNull
    private String username;

    @JsonProperty("email")
    @NonNull
    private String email;

    @JsonProperty("discordId")
    private String discordId;

    @JsonProperty(value = "password", access = JsonProperty.Access.WRITE_ONLY)
    @NonNull
    private String password;

}