package com.micro.sample.project.service;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuesPoiDto {

    private String title;

    private Short type;

    private Short diff;

    private List<QuesOptionPoiDto> options = new ArrayList<>();

    private List<String> answers;

    private String resolve;

    @Getter
    @Setter
    public static class QuesOptionPoiDto {

        private String prefix;

        private String title;
    }

}
