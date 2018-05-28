package com.sd.isp.beans.entry_details;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.sd.isp.beans.entry.EntryB;
import com.sd.isp.beans.part.PartB;
import org.apache.commons.lang.StringUtils;
import com.sd.isp.beans.base.BaseBean;

public class EntryDetailsB extends BaseBean{

    private static final long serialVersionUID = 4680476902664047494L;

    private Date date;
    private PartB part;
    private EntryB entry;

    public EntryDetailsB(Map<String, String> params) {
        super(params);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date _date) {
        date = _date;
    }

    public PartB getPart() {
        return part;
    }
    public void setPart(PartB _part) {
        part = _part;
    }

    public EntryB getEntry() {
        return entry;
    }

    public void setEntry(EntryB _entry) {
        entry = _entry;
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


    }

}
