
import com.sd.isp.rest.client.ClientResourceImpl

import com.sd.isp.service.client.ClientServiceImpl



// Place your Spring DSL code here
beans = {
	//resources
	/*clientResource(ClientResourceImpl)
	countryResource(CountryResourceImpl)
	stateResource(StateResourceImpl)
	cityResource(CityResourceImpl)

	//services
	clientService(ClientServiceImpl, ref("clientResource"), ref("cityService"))
	countryService(CountryServiceImpl, ref("countryResource"))
	stateService(StateServiceImpl, ref("stateResource"), ref("countryService"))
	cityService(CityServiceImpl,ref("cityResource"), ref("stateService"),ref("countryService") )*/
}
