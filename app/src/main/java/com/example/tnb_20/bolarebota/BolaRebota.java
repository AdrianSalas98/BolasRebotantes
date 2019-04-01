package com.example.tnb_20.bolarebota;

import android.widget.ImageView;

public class BolaRebota {

    // Atributos de la clase BolaRebota (Posiciones, Velocidades, Direcciones, Imagen, Tamaños)
    private int x;
    private int y;
    private float velocidadX;
    private float velocidadY;
    private ImageView imagen;
    private int height;
    private int width;

    // Getters y Setters de los Atributos de la clase BolaRebota
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public float getVelocidadX() {
        return velocidadX;
    }

    public void setVelocidadX(float velocidadX) {
        this.velocidadX = velocidadX;
    }

    public float getVelocidadY() {
        return velocidadY;
    }

    public void setVelocidadY(float velocidadY) {
        this.velocidadY = velocidadY;
    }

    public ImageView getImagen() {
        return imagen;
    }

    public void setImagen(ImageView imagen) {
        this.imagen = imagen;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    // Constructor de la clase BolaRebota pasandole por parametro todos los atributos e inicializandolos
    public BolaRebota(int x, int y, float velocidadX, float velocidadY, ImageView imagen, int height, int width) {
        this.x = x;
        this.y = y;
        this.velocidadX = velocidadX;
        this.velocidadY = velocidadY;
        this.imagen = imagen;
        this.height = height;
        this.width = width;
    }

    // Metodo para mover la bola, obteniendo las velocidades y posiciones actuales y cambiandolas a nuevos valores en la imagen
    public void moverBolaRebota(){
        if(imagen.getX() < 0){
            velocidadX = velocidadX *- 1;
        }

        if((imagen.getX() + imagen.getWidth()) > width){
            velocidadX = velocidadX *- 1;
        }

        if(imagen.getY() < 0){
            velocidadY = velocidadY *- 1;
        }

        if((imagen.getY() + imagen.getHeight()) > height){
            velocidadY = velocidadY *- 1;
        }

        float nPosX = imagen.getX() + velocidadX;
        float nPosY = imagen.getY() + velocidadY;

        imagen.setX(nPosX);
        imagen.setY(nPosY);
    }
}
