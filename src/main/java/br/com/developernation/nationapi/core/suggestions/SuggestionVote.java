package br.com.developernation.nationapi.core.suggestions;

import br.com.developernation.nationapi.models.User;
import lombok.Data;

@Data
public class SuggestionVote {

    public SuggestionVote(User user, SuggestionVoteType voteType) {
        this.user = user;
        this.voteType = voteType;
    }

    private User user;
    private SuggestionVoteType voteType;

}
