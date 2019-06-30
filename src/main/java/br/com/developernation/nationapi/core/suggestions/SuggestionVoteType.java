package br.com.developernation.nationapi.core.suggestions;

import lombok.Getter;

public enum  SuggestionVoteType {
    ACCEPT(0),
    DECLINE(1);

    @Getter
    private final int typeCode;
    SuggestionVoteType(int typeCode) {
        this.typeCode = typeCode;
    }
}
