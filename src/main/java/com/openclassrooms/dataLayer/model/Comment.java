package com.openclassrooms.dataLayer.model;

import javax.persistence.*;

@Entity
@Table(name = "commentaire")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="commentaire_id")
    private int commentId;

    @Column(name="contenu")
    private String content;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name="produit_id'")
    private Product product;

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}