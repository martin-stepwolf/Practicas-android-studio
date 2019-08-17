package com.example.practicas;

import java.util.Objects;

public class Casa {
    private String calle;
    private char seccion;
    private short numero;
    private int precio;
    private long fechaConstrucccion;
    private float impuesto;
    private double metrosCubicos;
    private boolean hipotecada;

    // la sobrecarga de metodos es la definicio de un mismo metodo pero con diferentes parametros recibidos

    public Casa() {
    }

    public Casa(String calle, char seccion, short numero) {
        this.calle = calle;
        this.seccion = seccion;
        this.numero = numero;
    }

    public Casa(String calle, char seccion, short numero, int precio, long fechaConstrucccion,
                float impuesto, double metrosCubicos, boolean hipotecada) {
        this.calle = calle;
        this.seccion = seccion;
        this.numero = numero;
        this.precio = precio;
        this.fechaConstrucccion = fechaConstrucccion;
        this.impuesto = impuesto;
        this.metrosCubicos = metrosCubicos;
        this.hipotecada = hipotecada;
    }

    // Get para obtener valores
    public String getCalle() {
        return calle;
    }

    public char getSeccion() {
        return seccion;
    }

    public short getNumero() {
        return numero;
    }

    public int getPrecio() {
        return precio;
    }

    public long getFechaConstrucccion() {
        return fechaConstrucccion;
    }

    public float getImpuesto() {
        return impuesto;
    }

    public double getMetrosCubicos() {
        return metrosCubicos;
    }

    public boolean isHipotecada() {
        return hipotecada;
    }

    //Set para definir valores


    public void setCalle(String calle) {
        this.calle = calle;
    }

    public void setSeccion(char seccion) {
        this.seccion = seccion;
    }

    public void setNumero(short numero) {
        this.numero = numero;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setFechaConstrucccion(long fechaConstrucccion) {
        this.fechaConstrucccion = fechaConstrucccion;
    }

    public void setImpuesto(float impuesto) {
        this.impuesto = impuesto;
    }

    public void setMetrosCubicos(double metrosCubicos) {
        this.metrosCubicos = metrosCubicos;
    }

    public void setHipotecada(boolean hipotecada) {
        this.hipotecada = hipotecada;
    }

    @Override
    public String toString() {
        return "Casa{" +
                "calle='" + calle + '\'' +
                ", seccion=" + seccion +
                ", numero=" + numero +
                ", precio=" + precio +
                ", fechaConstrucccion=" + fechaConstrucccion +
                ", impuesto=" + impuesto +
                ", metrosCubicos=" + metrosCubicos +
                ", hipotecada=" + hipotecada +
                '}';
    }


//    Los metodos equials i hashCode sirven para comparar dos objetos, ver si son identicos
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Casa casa = (Casa) o;
        return seccion == casa.seccion &&
                numero == casa.numero &&
                precio == casa.precio &&
                fechaConstrucccion == casa.fechaConstrucccion &&
                Float.compare(casa.impuesto, impuesto) == 0 &&
                Double.compare(casa.metrosCubicos, metrosCubicos) == 0 &&
                hipotecada == casa.hipotecada &&
                Objects.equals(calle, casa.calle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(calle, seccion, numero, precio, fechaConstrucccion, impuesto,
                metrosCubicos, hipotecada);
    }
}

// El contructor va a llevar el mismo nombre de la clase y puede recibir los parametros de iniciacion.
