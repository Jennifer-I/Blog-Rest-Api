package com.jennifer.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


import java.util.List;

@Getter@Setter@AllArgsConstructor@NoArgsConstructor
@Entity
public class Post extends BaseEntity{

    private String title;

    private String postContent;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "post_id",referencedColumnName = "id")
    private Admin admin;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comment;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Like> likes;


}
