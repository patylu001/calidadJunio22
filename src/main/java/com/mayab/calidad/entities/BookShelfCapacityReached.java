package com.anahuac.calidad.libros.entities;

public class BookShelfCapacityReached extends RuntimeException {
    public BookShelfCapacityReached(String message) {
        super(message);
    }
}
