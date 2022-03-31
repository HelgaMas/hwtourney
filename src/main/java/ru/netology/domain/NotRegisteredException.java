package ru.netology.domain;

public class NotRegisteredException extends RuntimeException {

    public NotRegisteredException(String name) {
        super("Element with name '" + name + "' is not registered");
    }
}