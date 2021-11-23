package com.jfinch.mostcommonwords.dto;

import javax.validation.constraints.NotNull;

public class TextRequestDto {
    @NotNull(message = "Text cannot be empty")
    public String text;
}
