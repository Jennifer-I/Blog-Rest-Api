package com.jennifer.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.List;
@Getter@Setter@AllArgsConstructor@NoArgsConstructor

@Entity
public class Comment extends BaseEntity{

    @Column
    private String commentContent;

    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    private Post post;

    @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL)
    private List<Like> likes;
    @ManyToOne
    private User user;
}
