package com.sd.isp.rest.entry_details;

import java.util.Map;

import com.sd.isp.dto.entry_details.EntryDetailsDTO;
import com.sd.isp.dto.entry_details.EntryDetailsResult;
import com.sd.isp.rest.base.IBaseResource;

public interface IEntryDetailsResource extends IBaseResource<EntryDetailsDTO, EntryDetailsResult> {

    public EntryDetailsResult getAll();

    public EntryDetailsResult getAllBy(Map<String,String> args);
}


