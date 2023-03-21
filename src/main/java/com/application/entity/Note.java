package com.application.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Note {

    private long id;

    private String title;

    private String content;
}
