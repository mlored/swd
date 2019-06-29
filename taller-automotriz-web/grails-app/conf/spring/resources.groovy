import com.google.code.ssm.CacheFactory
import com.google.code.ssm.config.DefaultAddressProvider
import com.google.code.ssm.providers.CacheConfiguration
import com.google.code.ssm.providers.xmemcached.MemcacheClientFactoryImpl
import com.sd.isp.rest.role.RoleResourceImpl
import com.sd.isp.rest.support.SupportResourceImpl
import com.sd.isp.rest.user.UserResourceImpl
import com.sd.isp.service.auth.AuthServiceImpl
import com.sd.isp.service.role.RoleServiceImpl
import com.sd.isp.service.user.UserServiceImpl

//import com.google.code.ssm.spring.SSMCache
//import com.google.code.ssm.spring.SSMCacheManager
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

    //resources
    //userResource(UserResourceImpl)
    //roleResource(RoleResourceImpl)

    //services
    //authService(AuthServiceImpl)
    //userService(UserServiceImpl)
    //roleService(RoleServiceImpl)

//
//    cacheConfiguration(CacheConfiguration){ consistentHashing=true }
//
//    addressProvider(DefaultAddressProvider){ address= "127.0.0.1:11211" }
//
//    memcachedClientFactory(MemcacheClientFactoryImpl)
//
//    cacheFactory(CacheFactory){
//        cacheClientFactory=ref("memcachedClientFactory")
//        addressProvider=ref("addressProvider")
//        configuration=ref("cacheConfiguration")
//        cacheName = "isp-client-web-cache"
//    }
//
//    ssmCache(SSMCache,
//            ref("cacheFactory"),
//            300,
//            false)
//
//    sdCacheManager(SSMCacheManager){
//        caches=[ref("ssmCache")]
//    }

}

