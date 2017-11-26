package com.sd.isp.rest.entry;

import com.sd.isp.dto.entry.EntryDTO;
import com.sd.isp.dto.entry.EntryResult;
import com.sd.isp.rest.base.IBaseResource;

public interface IEntryResource extends IBaseResource<EntryDTO>{
    public EntryResult getAll();
}
