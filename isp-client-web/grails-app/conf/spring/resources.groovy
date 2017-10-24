import com.sd.isp.rest.city.CityResourceImpl
import com.sd.isp.rest.client.ClientResourceImpl
import com.sd.isp.rest.country.CountryResourceImpl
import com.sd.isp.rest.state.StateResourceImpl
import com.sd.isp.service.city.CityServiceImpl
import com.sd.isp.service.client.ClientServiceImpl
import com.sd.isp.service.country.CountryServiceImpl
import com.sd.isp.service.state.StateServiceImpl


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
