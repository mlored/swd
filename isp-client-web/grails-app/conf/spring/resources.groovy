import login.MyAuthenticationProvider;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

// Place your Spring DSL code here
beans = {
	myAuthenticationProvider(MyAuthenticationProvider) {
	}
	
	localeResolver(SessionLocaleResolver) {
		defaultLocale= new java.util.Locale('es');
	}
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
