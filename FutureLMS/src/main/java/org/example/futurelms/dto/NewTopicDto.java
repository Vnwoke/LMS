package org.example.futurelms.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewTopicDto {
    private Long courseId;
    private String title;
    private String content;
    private String video;
}
