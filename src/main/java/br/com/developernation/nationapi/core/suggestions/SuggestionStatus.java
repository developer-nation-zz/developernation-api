package br.com.developernation.nationapi.core.suggestions;

import lombok.Getter;

public enum SuggestionStatus {

    REVISION(0),
    ACCEPTED(1),
    DECLINED(2);

    @Getter
    private final int statusCode;

    SuggestionStatus(int status) {
        this.statusCode = status;
    }

}
