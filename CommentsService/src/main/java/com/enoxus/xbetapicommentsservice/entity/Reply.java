package com.enoxus.xbetapicommentsservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name = "parent_id")
    @ManyToOne
    private Comment parent;
    @JoinColumn(name = "owner_id")
    @ManyToOne
    private User owner;
    private String text;
}