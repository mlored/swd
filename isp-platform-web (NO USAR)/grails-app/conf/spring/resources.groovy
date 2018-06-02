// Place your Spring DSL code here


import com.sd.isp.rest.buy.*
import com.sd.isp.rest.entry_details.EntryDetailsResourceImpl
import com.sd.isp.rest.service.ServiceResourceImpl
import com.sd.isp.rest.supplier.SupplierResourceImpl
import com.sd.isp.rest.support.SupportResourceImpl
import com.sd.isp.service.buy.*
import com.sd.isp.service.car.*
import com.sd.isp.service.employee.*
import com.sd.isp.service.entry.*
import com.sd.isp.rest.car.CarResourceImpl
import com.sd.isp.rest.client.ClientResourceImpl
import com.sd.isp.rest.employee.EmployeeResourceImpl
import com.sd.isp.rest.entry.EntryResourceImpl
import com.sd.isp.rest.part.PartResourceImpl
import com.sd.isp.rest.role.RoleResourceImpl
import com.sd.isp.service.client.*
import com.sd.isp.service.auth.*
import com.sd.isp.service.entry_details.EntryDetailsServiceImpl
import com.sd.isp.service.part.PartServiceImpl
import com.sd.isp.service.role.RoleServiceImpl
import com.sd.isp.service.service.ServiceServiceImpl
import com.sd.isp.service.supplier.SupplierServiceImpl
import com.sd.isp.service.support.SupportServiceImpl
import com.sd.isp.service.user.UserServiceImpl

beans = {
    clientService(ClientServiceImpl) {}
    _clientResource(ClientResourceImpl)
    authService(AuthServiceImpl)
    buyService(BuyServiceImpl)
    _buyResource(BuyResourceImpl)
    carService(CarServiceImpl)
    _carResource(CarResourceImpl)
    clientService(ClientServiceImpl)
    _clientResource(ClientResourceImpl)
    employeeService(EmployeeServiceImpl)
    _employeeResource(EmployeeResourceImpl)
    entryService(EntryServiceImpl)
    _entryResource(EntryResourceImpl)
    entryDetailsService(EntryDetailsServiceImpl)
    _entryDetailsResource(EntryDetailsResourceImpl)
    partService(PartServiceImpl)
    _partResource(PartResourceImpl)
    RoleService(RoleServiceImpl)
    _roleResource(RoleResourceImpl)
    ServiceService(ServiceServiceImpl)
    _serviceResource(ServiceResourceImpl)
    SupplierService(SupplierServiceImpl)
    _supplierResource(SupplierResourceImpl)
    SupportService(SupportServiceImpl)
    _supportResource(SupportResourceImpl)
}
