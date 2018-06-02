package com.sd.isp.beans.entry;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
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
    private String date;
    private Integer number;
    private String diagnostic;
    private ClientB cliente;
    private CarB car;
    private Integer carId;
    private Integer clientId;
    private List<EntryDetailsB> entryDetails;

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

    public String getDate() {
        return date;
    }

    public void setDate(String _date) {
        date = _date;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer _number) {
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
        if (!StringUtils.isBlank(params.get("id"))) {
            setId(Integer.valueOf(params.get("id")));
        }
        setDate(params.get("date"));
        setNumber(Integer.valueOf(params.get("number")));
        setCarId(Integer.valueOf(params.get("carId")));
        setClientId(Integer.valueOf(params.get("clientId")));
        setDiagnostic(params.get("diagnostic"));
    }

}
