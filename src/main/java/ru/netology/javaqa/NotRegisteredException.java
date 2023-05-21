package ru.netology.javaqa;

public class NotRegisteredException extends RuntimeException {

    public NotRegisteredException(String playerName) {

        super(" Игрок под именем " + playerName + "не обнаружен");
    }

}
