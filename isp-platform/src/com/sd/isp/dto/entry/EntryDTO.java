package com.sd.isp.dto.entry;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.isp.domain.car.CarDomain;
import com.sd.isp.domain.client.ClientDomain;
import com.sd.isp.domain.entry_details.EntryDetailsDomain;
import com.sd.isp.dto.base.BaseDTO;
import com.sd.isp.dto.car.CarDTO;
import com.sd.isp.dto.client.ClientDTO;
import com.sd.isp.dto.entry_details.EntryDetailsDTO;

@XmlRootElement(name = "entry")
public class EntryDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	
	private Date 		_date;
	private String 		_number;
	private String	 	_diagnostic;
    private CarDTO 		_car;
    private ClientDTO 	_client;
    private Integer		_carId;
    private Integer 	_clientId;
	private List<EntryDetailsDTO> _entryDetails = new ArrayList<EntryDetailsDTO>();

	
	@XmlElement
	public Integer getCarId() {
		return _carId;
	}

	public void setCarId(Integer _carId) {
		this._carId = _carId;
	}
	
	@XmlElement
	public Integer getClientId() {
		return _clientId;
	}

	public void setClientId(Integer _clientId) {
		this._clientId = _clientId;
	}


    @XmlElement
	public CarDTO getCar() {
		return _car;
	}

	public void setCar(CarDTO car) {
		_car = car;
	}
	
	@XmlElement
	public ClientDTO getClient() {
		return _client;
	}

	public void setClient(ClientDTO client) {
		_client = client;
	}
	
	@XmlElement
	public List<EntryDetailsDTO> getEntryDetails() {
		return _entryDetails;
	}

	public void setEntryDetails(List<EntryDetailsDTO> entryDetails) {
		_entryDetails = entryDetails;
	}
	
    
	@XmlElement
	public Date getDate() {
		return _date;
	}

	public void setDate(Date date) {
		_date = date;
	}

	@XmlElement
	public String getNumber() {
		return _number;
	}

	public void setNumber(String number) {
		_number = number;
	}
	
	@XmlElement
	public String getDiagnostic() {
		return _diagnostic;
	}

	public void setDiagnostic(String diagnostic) {
		_diagnostic = diagnostic;
	}
}