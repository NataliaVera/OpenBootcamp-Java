package com.example.obJavaSpring.service;

import com.example.obJavaSpring.entity.Book;

public class BookPriceCalculator {

    public Double calculatePrice(Book book){
        double price =book.getPrice();

        if(book.getPages() > 300){
            price += 5;
        }
        //envio
        price += 2.99;
        return price;
    }
}
