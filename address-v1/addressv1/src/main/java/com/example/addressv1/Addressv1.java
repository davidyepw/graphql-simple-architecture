package com.example.addressv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Addressv1 {
     
    private String idAddress;
    private String descripcion;
    private String distrito;
    private String idPerson;

    public Addressv1(String idAddress, String descripcion, String distrito, String idPerson) {
        this.idAddress = idAddress;
        this.descripcion = descripcion;
        this.distrito = distrito;
        this.idPerson = idPerson;
       
    }

    private static List<Addressv1> addressList = Arrays.asList(
        new Addressv1("address-0", "Calle ABC 123", "Distrito 1","00000000"),
        new Addressv1("address-1", "Avenida XYZ 456", "Distrito 2","11111111"),
        new Addressv1("address-2", "Calle MNO 123", "Distrito 3","11111111"),
        new Addressv1("address-3", "Jiron JKL 789", "Distrito 4","22222222"),
        new Addressv1("address-4", "Calle FGH 753", "Distrito 5","11111111")
    );
    
    public static List<Addressv1> getByPersonId(String id) {
        //System.out.println("***************String recibido: " + id + "*******************");
        List<Addressv1> dataIterate = addressList;
        List<Addressv1> personAddressList = new ArrayList<>();
        Iterator<Addressv1> iterator = dataIterate.iterator();
        while(iterator.hasNext()){
            Addressv1 dataIterated = iterator.next();
            //System.out.println("Iterando Address: " + dataIterated.idAddress.toString());
            if (dataIterated.getIdPerson().equals(id)) {
                //System.out.println("Match Address con idPerson");
                personAddressList.add(dataIterated);
            }
            
        }
        return personAddressList;
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
}
