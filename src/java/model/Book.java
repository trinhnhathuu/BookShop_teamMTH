/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author pc asus
 */
public class Book {
    private int id;
    private String title;
    private String author;
    private LocalDate publisherDate;
    private String category;
    private double price;
    private String description;
    private String image;

    public Book() {
    }

    public Book(String title, String author, LocalDate publisherDate, String category, double price, String description, String image) {
        this.title = title;
        this.author = author;
        this.publisherDate = publisherDate;
        this.category = category;
        this.price = price;
        this.description = description;
        this.image = image;
    }

    public Book(int id, String title, String author, LocalDate publisherDate, String category, double price, String description, String image) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisherDate = publisherDate;
        this.category = category;
        this.price = price;
        this.description = description;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getPublisherDate() {
        return publisherDate;
    }

    public void setPublisherDate(LocalDate publisherDate) {
        this.publisherDate = publisherDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", title=" + title + ", author=" + author + ", publisherDate=" + publisherDate + ", category=" + category + ", price=" + price + ", description=" + description + ", image=" + image + '}';
    }
    
}
