package com.codegym.cms.model;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "phones")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private Date dateOfPurchase;
    private long price;
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Phone() {
    }

    public Phone(String name, Date dateOfPurchase, long price, String description) {
        this.name = name;
        this.dateOfPurchase = dateOfPurchase;
        this.price = price;
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("Phone[id=%d, name='%s', dateOfPurchase='%s', price='%s', description='%s'", id, name, dateOfPurchase, price, description);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
