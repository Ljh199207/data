package com.data.lambda.LambdaTest;

import java.time.LocalDate;

/**
 * @Auther: ljh
 * @Date: 2018/9/17 09:29
 * @Description:
 */
public class Book {

    private Integer id;
    private String name;
    private  double price;
    private String type;
    private LocalDate publishDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", publishDate=" + publishDate +
                '}';
    }

    public Book(Integer id, String name, double price, String type, LocalDate publishDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
        this.publishDate = publishDate;
    }
}
