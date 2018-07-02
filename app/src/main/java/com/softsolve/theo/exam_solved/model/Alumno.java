package com.softsolve.theo.exam_solved.model;

public class Alumno {

    private String nombre;
    private double matricula;
    private double turno;
    private double servicio;
    private double carrera;
    private double pagoTotal;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getMatricula() {
        return matricula;
    }

    public void setMatricula(double matricula) {
        this.matricula = matricula;
    }

    public double getTurno() {
        return turno;
    }

    public void setTurno(double turno) {
        this.turno = turno;
    }

    public double getServicio() {
        return servicio;
    }

    public void setServicio(double servicio) {
        this.servicio = servicio;
    }

    public double getCarrera() {
        return carrera;
    }

    public void setCarrera(double carrera) {
        this.carrera = carrera;
    }

    public double getPagoTotal() {
        return pagoTotal;
    }

    public void setPagoTotal(double pagoTotal) {
        this.pagoTotal = pagoTotal;
    }
}
