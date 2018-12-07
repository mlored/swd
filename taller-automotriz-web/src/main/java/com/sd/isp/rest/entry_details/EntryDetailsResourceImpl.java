package com.sd.isp.rest.entry_details;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.sd.isp.dto.entry_details.EntryDetailsDTO;
import com.sd.isp.dto.entry_details.EntryDetailsResult;
import com.sd.isp.rest.base.BaseResourceImpl;

@Repository("entryDetailsResource")
public class EntryDetailsResourceImpl extends BaseResourceImpl<EntryDetailsDTO, EntryDetailsResult> implements IEntryDetailsResource {

    public EntryDetailsResourceImpl() {
        super(EntryDetailsDTO.class, "/entry_details", EntryDetailsResult.class);
    }

    @Override
    public EntryDetailsResult getAll() {
        //setWebResourceBasicAuthFilter();
        EntryDetailsResult entryDetails = getWebResource().get(EntryDetailsResult.class);
        //return getWebResource().get(EntryDetailsResult.class);
        return entryDetails;
    }

    @Override
    public EntryDetailsResult getAllBy(Map<String, String> args) {
        //setWebResourceBasicAuthFilter();
        return getWebResource().path("/partId/" + args.get("partId")).get(EntryDetailsResult.class);
    }
    @Override
    public EntryDetailsDTO save(EntryDetailsDTO entryDetails) {
        return super.save(entryDetails);
    }

    @Override
    public EntryDetailsDTO getById(Integer id) {
        return super.getById(id);
    }

}

