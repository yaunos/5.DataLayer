package com.openclassrooms.dataLayer.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categorie")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="categorie_id")
    private int categoryId;

    @Column(name="nom")
    private String name;

    @ManyToMany(
            // LAZY : à la récupération de la catégorie, les produits ne sont pas récupérés
            fetch = FetchType.LAZY,
            cascade = {
                    // ici la cascade ne se fait pas en cas de suppression
                    // Elle s'applique seulement en création ou modification
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
            @JoinTable(
                    name = "categorie_produit",
                    joinColumns = @JoinColumn(name = "categorie_id"),
                    inverseJoinColumns = @JoinColumn(name = "produit_id")
    )
    private List<Product> products = new ArrayList<>();

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        products.add(product);
        product.getCategories().add(this);
    }

    public void removeProduct(Product product) {
        products.remove(product);
        product.getCategories().remove(this);
    }


}
