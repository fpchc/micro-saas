package com.micro.sample.project.service;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuesDO {

    private Long id;

    private String title;

    private List<QuesOption> quesOptions = new ArrayList<>();

    private String diff;

    private Short type;

    private String resolve;

}
