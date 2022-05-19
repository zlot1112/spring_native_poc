package com.fss.board.entity;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@ToString
@Builder
@AllArgsConstructor
@Document(value = "boards")
public class Boards {
    @Id
    private ObjectId id;
    private String title;
    private String content;

}