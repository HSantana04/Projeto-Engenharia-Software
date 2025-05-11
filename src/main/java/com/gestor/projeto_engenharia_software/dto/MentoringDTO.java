package com.gestor.projeto_engenharia_software.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MentoringDTO {
    private Long id;
    private String name;
    private Integer mentorID;
    private Integer mentoredID;
    private Integer topicID;
    private Boolean concluded;
    @JsonFormat(pattern = "dd-MM-yyyy'T'HH:mmXXX")
    private ZonedDateTime scheduledDate;
    private Instant createdAt;
    private Instant updatedAt;
    private Integer rating;
}
