package com.sd.isp.rest.entry;

import com.sd.isp.dto.entry.EntryDTO;
import com.sd.isp.dto.entry.EntryResult;
import com.sd.isp.rest.base.BaseResourceImpl;
import org.springframework.stereotype.Repository;

@Repository("entryResource")
public class EntryResourceImpl extends BaseResourceImpl<EntryDTO> implements IEntryResource {
    public EntryResourceImpl() {
        super(EntryDTO.class, "/entry");
    }

    @Override
    public EntryResult getAll() {
        final EntryResult result = getWebResource().get(EntryResult.class);
        return result;
    }
}
