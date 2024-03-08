package com.time_sheeet.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message="name should contains min 3 chars")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Name must contain only alphabets")
    @Size(min= 3 , message ="Name should contains min 3 chars" )

    private String name;

    @NotNull(message = "description should not be empty")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Name must contain only alphabets")
    @Size(min= 5)
    private String description;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-mm-dd")
    private String dueDate;

    @NotNull(message="priority cannot be empty")
    private String priority;

    @NotNull(message="assignee cannot be empty")
    @JoinColumn(name="assignee_id")
    private long assignee;

}
