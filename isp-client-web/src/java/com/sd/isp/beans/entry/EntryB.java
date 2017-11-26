package com.sd.isp.beans.entry;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.sd.isp.beans.car.CarB;
import com.sd.isp.beans.client.ClientB;
import org.apache.commons.lang.StringUtils;
import com.sd.isp.beans.base.BaseBean;

public class EntryB extends BaseBean{

    private static final long serialVersionUID = 4680476902664047494L;
    private Date date;
    private Integer number;
    private String diagnostic;
    private ClientB cliente;
    private CarB car;


    public EntryB(Map<String, String> params) {
        super(params);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date _date) {
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
        diagnostic=_diagnostic;
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
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        String dateInString = params.get("date");
        try {

            Date aux = formatter.parse(dateInString);
            setDate(aux);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        setNumber(Integer.valueOf(params.get("number")));
        setDiagnostic(params.get("diagnostic"));

    }

}
