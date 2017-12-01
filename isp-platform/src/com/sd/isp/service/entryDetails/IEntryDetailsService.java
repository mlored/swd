package com.sd.isp.service.entryDetails;

import com.sd.isp.dao.entry_details.EntryDetailsDaoImpl;
import com.sd.isp.domain.entry_details.EntryDetailsDomain;
import com.sd.isp.dto.entry_details.EntryDetailsDTO;
import com.sd.isp.dto.entry_details.EntryDetailsResult;
import com.sd.isp.service.base.IBaseService;

public interface IEntryDetailsService extends IBaseService<EntryDetailsDTO, EntryDetailsDomain, EntryDetailsDaoImpl, EntryDetailsResult> {

}