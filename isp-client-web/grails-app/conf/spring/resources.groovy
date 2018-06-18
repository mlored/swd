import com.google.code.ssm.CacheFactory
import com.google.code.ssm.config.DefaultAddressProvider
import com.google.code.ssm.providers.CacheConfiguration
import com.google.code.ssm.providers.xmemcached.MemcacheClientFactoryImpl
import com.google.code.ssm.spring.SSMCache
import com.google.code.ssm.spring.SSMCacheManager
import login.MyAuthenticationProvider
import login.MyBean;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

// Place your Spring DSL code here
beans = {
	myAuthenticationProvider(MyAuthenticationProvider) {
	}

	myBean(MyBean) {}

	localeResolver(SessionLocaleResolver) {
		defaultLocale= new java.util.Locale('es');
	}

	cacheConfiguration(CacheConfiguration){ consistentHashing=true }

	addressProvider(DefaultAddressProvider){ address=grailsApplication.config.cache.address }

	memcachedClientFactory(MemcacheClientFactoryImpl)

	cacheFactory(CacheFactory){
		cacheClientFactory=ref("memcachedClientFactory")
		addressProvider=ref("addressProvider")
		configuration=ref("cacheConfiguration")
		cacheName = grailsApplication.config.cache.name
	}

	ssmCache(SSMCache,
			ref("cacheFactory"),
			300,
			false)

	sdCacheManager(SSMCacheManager){
		caches=[ref("ssmCache")]
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
