package br.com.developernation.nationapi.models;

import br.com.developernation.nationapi.core.suggestions.SuggestionStatus;
import br.com.developernation.nationapi.core.suggestions.SuggestionType;
import br.com.developernation.nationapi.core.suggestions.SuggestionVote;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

import java.util.List;

@Data
@NoArgsConstructor
@Document(collection = "suggestions")
public class Suggestion extends AbstractModel {

    @JsonProperty("title")
    @NonNull
    private String title;

    @JsonProperty("userId")
    @NonNull
    private String userId;

    @JsonProperty("content")
    @NonNull
    private String content;

    @JsonProperty("status")
    @NonNull
    private SuggestionStatus status;

    @JsonProperty("type")
    @NonNull
    private SuggestionType type;

    @JsonProperty("votes")
    private List<SuggestionVote> votes;

    public void addVote(SuggestionVote vote){
        this.votes.add(vote);
    }

    public void removeVote(User user){
        this.votes.remove(this.votes.stream().filter(vote -> vote.getUser().getDiscordId().equals(user.getDiscordId())).findFirst().orElseGet(null));
    }

}