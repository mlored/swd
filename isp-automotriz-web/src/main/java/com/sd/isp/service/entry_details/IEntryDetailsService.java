package com.sd.isp.service.entry_details;

import java.util.List;
import java.util.Map;

import com.sd.isp.beans.entry_details.EntryDetailsB;
import com.sd.isp.dto.entry_details.EntryDetailsDTO;
import com.sd.isp.service.base.IBaseService;

public interface IEntryDetailsService extends IBaseService<EntryDetailsB, EntryDetailsDTO> {

    List<EntryDetailsB> getAllBy(Map<String, String> args);

}



