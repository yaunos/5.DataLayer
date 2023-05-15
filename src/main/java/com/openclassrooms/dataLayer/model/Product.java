package com.openclassrooms.dataLayer.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "produit")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="produit_id")
    private int productId;

    @Column(name="nom")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="cout")
    private int cost;


    /*
    @OneToMany(

            mappedBy = "product",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )

    @ManyToMany(
            mappedBy = "products",
            cascade = CascadeType.ALL
    )
    */

    @OneToMany(
            mappedBy = "product",
            cascade = CascadeType.ALL,
            orphanRemoval = true
            //fetch = FetchType.EAGER
    )
    //@JoinColumn(name = "produit_id")
    List<Comment> comments = new ArrayList<>();

    // Liste des catégories associées aux products
    @ManyToMany(
            mappedBy = "products",
            cascade = CascadeType.ALL
    )
    List<Category> categories = new ArrayList<>();


    // Add getters and setters
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;

    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }


    // helpers methods
    public void addComment(Comment comment) {
        comments.add(comment);
        comment.setProduct(this);
    }

    public void removeComment(Comment comment) {
        comments.remove(comment);
        comment.setProduct(null);
    }


}
