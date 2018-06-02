package com.sd.isp.rest.entry;

import com.sd.isp.dto.entry.EntryDTO;
import com.sd.isp.dto.entry.EntryResult;
import com.sd.isp.rest.base.BaseResourceImpl;
import org.springframework.stereotype.Repository;

@Repository("entryResource")
public class EntryResourceImpl extends BaseResourceImpl<EntryDTO, EntryResult> implements IEntryResource {
    public EntryResourceImpl() {
        super(EntryDTO.class, "/entry", EntryResult.class);
    }
    @Override
    public EntryDTO save(EntryDTO entry) {
        return super.save(entry);
    }


    @Override
    public EntryDTO getById(Integer id) {
        return super.getById(id);
    }

    @Override
    public EntryResult getAll() {
        final EntryResult result = getWebResource().get(EntryResult.class);
        return result;
    }
}
