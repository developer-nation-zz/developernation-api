package br.com.developernation.nationapi.core.suggestions;

import lombok.Getter;

public enum SuggestionType {

    PRIVATE(0),
    PUBLIC(1);

    @Getter
    private final int typeCode;
    SuggestionType(int typeCode) {
        this.typeCode = typeCode;
    }
}
