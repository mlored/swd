package com.sd.isp.service.entry;

import com.sd.isp.dao.entry.EntryDaoImpl;
import com.sd.isp.domain.entry.EntryDomain;
import com.sd.isp.dto.entry.EntryDTO;
import com.sd.isp.dto.entry.EntryResult;
import com.sd.isp.service.base.IBaseService;

public interface IEntryService extends IBaseService<EntryDTO, EntryDomain, EntryDaoImpl, EntryResult> {

}
