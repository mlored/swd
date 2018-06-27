package com.sd.isp.beans.entry;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sd.isp.beans.car.CarB;
import com.sd.isp.beans.client.ClientB;
import com.sd.isp.beans.entry_details.EntryDetailsB;
import org.apache.commons.lang.StringUtils;
import com.sd.isp.beans.base.BaseBean;

public class EntryB extends BaseBean{

    private static final long serialVersionUID = 4680476902664047494L;
    private Date date;
    private String number;
    private String diagnostic;
    private ClientB cliente;
    private CarB car;
    private Integer carId;
    private Integer clientId;
    private List<EntryDetailsB> entryDetails;

    public List<EntryDetailsB> getEntryDetails() {
        return entryDetails;
    }

    public void addDetail(EntryDetailsB e){
        entryDetails.add(e);
    }

    public void setEntryDetails(List<EntryDetailsB> entryDetails) {
        this.entryDetails = entryDetails;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public EntryB(Map<String, String> params) {
        super(params);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date _date) {
        date = _date;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String _number) {
        number = _number;
    }

    public String getDiagnostic(){
        return diagnostic;
    }

    public void setDiagnostic(String _diagnostic){
        diagnostic = _diagnostic;
    }

    public ClientB getCliente() {
        return cliente;
    }

    public void setCliente(ClientB _cliente) {
        cliente = _cliente;
    }

    public CarB getCar() {
        return car;
    }

    public void setCar(CarB _car) {
        car = _car;
    }



    @Override
    protected void create(Map<String, String> params) {
        entryDetails = new ArrayList<EntryDetailsB>();
        if (!StringUtils.isBlank(params.get("id"))) {
            setId(Integer.valueOf(params.get("id")));
        }
        if (!StringUtils.isBlank(params.get("date")))
            try {
                setDate(new SimpleDateFormat("dd/MM/yyyy").parse(params.get("date")));
            } catch (ParseException e) {
                e.printStackTrace(); }

        if (!StringUtils.isBlank(params.get("number")))
            setNumber(params.get("number"));
        if (!StringUtils.isBlank(params.get("carId")))
            setCarId(Integer.valueOf(params.get("carId")));
        if (!StringUtils.isBlank(params.get("clientId")))
            setClientId(Integer.valueOf(params.get("clientId")));
        setDiagnostic(params.get("diagnostic"));

        if (!StringUtils.isBlank(params.get("entry.entryDetails[0].itemId"))){
            EntryDetailsB e1 = new EntryDetailsB(params);
            e1.setItemId(Integer.valueOf(params.get("entry.entryDetails[0].itemId")));
            try {
                e1.setDate(new SimpleDateFormat("dd/MM/yyyy").parse(params.get("entry.entryDetails[0].date")));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            addDetail(e1);
        }
    }

}
