package com.example.app1ux1;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonProperty;




public class App1UX1Address {
    @JsonProperty("idAddress")
    private String idAddress;
    
    @JsonProperty("descripcion")
    private String descripcion;
    
    @JsonProperty("distrito")
    private String distrito;
    //@ManyToOne
    //@JoinColumn(name = "id", nullable = false, updatable = false)
    //el nombre de esta propiedad tiene que conincidir con el mappedBy del OneToMany de App1UX1Person
    @JsonProperty("idPerson")
    private String idPerson;
/* 
    public App1UX1Address(String idAddress, String descripcion, String distrito, String idPerson) {
        
        this.idAddress = idAddress;

        this.descripcion = descripcion;
        this.distrito = distrito;
        this.idPerson = idPerson;
       
    }
*/
    public static List<App1UX1Address> getByPersonId(String id) {
        System.out.println("***************String recibido: " + id + "*******************");
        
        return null;
    }

    public String getIdAddress() {
        return idAddress;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public String getDistrito() {
        return distrito;
    }

    public String getIdPerson() {
        return idPerson;
    }

    public void setIdAddress(String idAddress) {
        this.idAddress= idAddress;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setDistrito(String distrito) {
        this.distrito= distrito;
    }
}

