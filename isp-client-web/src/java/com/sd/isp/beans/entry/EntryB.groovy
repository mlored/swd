package com.sd.isp.beans.entry

import com.sd.isp.beans.base.BaseBean
import com.sd.isp.beans.car.CarB
import com.sd.isp.beans.client.ClientB
import org.apache.commons.lang.StringUtils

import java.text.DateFormat
import java.text.SimpleDateFormat

class EntryB extends BaseBean {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private Date date;
    private String diagnostic;
    private Integer number;
    private CarB carB;
    private ClientB clientB;
    //private List<EntryDetailsB> entryDetailsB;

    public EntryB(Map<String, String> params) {
        super(params);
    }

    static long getSerialVersionUID() {
        return serialVersionUID
    }

    Integer getId() {
        return id
    }

    Date getDate() {
        return date
    }

    String getDiagnostic() {
        return diagnostic
    }

    Integer getNumber() {
        return number
    }

    CarB getCarB() {
        return carB
    }

    ClientB getClientB() {
        return clientB
    }

    //List<EntryDetailsB> getEntryDetailsB() {
    //    return entryDetailsB
    //}

    void setId(Integer id) {
        this.id = id
    }

    void setDate(Date date) {
        this.date = date
    }

    void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic
    }

    void setNumber(Integer number) {
        this.number = number
    }

    void setCarB(CarB carB) {
        this.carB = carB
    }

    void setClientB(ClientB clientB) {
        this.clientB = clientB
    }

    //void setEntryDetailsB(List<EntryDetailsB> entryDetailsB) {
    //    this.entryDetailsB = entryDetailsB
    //}

    @Override
    protected void create(Map<String, String> params) {
        if (!StringUtils.isBlank(params.get("id"))) {
            setId(Integer.valueOf(params.get("id")));
        }
        if (!StringUtils.isEmpty(params.get("date"))) {
            DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
            Date date = format.parse(params.get("date"));
            setDate(date);
        }
        setDiagnostic(params.get("diagnostic"));
        //setCarB(params.get("carB"));
        //setClientB(params.get("clientB"))
    }
}
