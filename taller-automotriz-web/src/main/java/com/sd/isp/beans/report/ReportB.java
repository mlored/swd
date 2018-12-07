package com.sd.isp.beans.report;

import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.sd.isp.beans.base.BaseBean;
import com.sd.isp.beans.entry.EntryB;
import com.sd.isp.beans.entry_details.EntryDetailsB;
import com.sd.isp.beans.item.ItemB;
import com.sd.isp.beans.report.ReportB;

public class ReportB extends BaseBean {
    private static final long serialVersionUID = 1L;
    private Date 		  _date;
    private EntryB	      _entry;
    private EntryDetailsB _entryDetails;
    private ItemB	      _item;
    private Boolean 	  _isActived;

    public ReportB(Map<String, String> params) {
        super(params);
    }

    @Override
    protected void create(Map<String, String> params) {
        if (!StringUtils.isBlank(params.get("id"))) {
            setId(Integer.valueOf(params.get("id")));
        }
    }

    public Date getDate() {
        return _date;
    }

    public void setDate(Date date) {
        _date = date;
    }

    public EntryB getEntry() {
        return _entry;
    }

    public void setEntry(EntryB entry) {
        _entry = entry;
    }


    public EntryDetailsB getEntryDetails() {
        return _entryDetails;
    }

    public ItemB getItem() {
        return _item;
    }

    public void setItem(ItemB item) {
        _item = item;
    }

    public void setEntryDetails(EntryDetailsB entryDetails) {
        _entryDetails = entryDetails;
    }

    public Boolean getIsActived() {
        return _isActived;
    }

    public void setIsActived(Boolean isActived) {
        _isActived = isActived;
    }


}
