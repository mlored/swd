import com.sd.isp.rest.car.CarResourceImpl
import com.sd.isp.service.car.CarServiceImpl
import com.sd.isp.rest.client.ClientResourceImpl
import com.sd.isp.service.client.ClientServiceImpl
import com.sd.isp.rest.employee.EmployeeResourceImpl
import com.sd.isp.service.employee.EmployeeServiceImpl
import com.sd.isp.rest.part.PartResourceImpl
import com.sd.isp.service.part.PartServiceImpl
import com.sd.isp.rest.service.ServiceResourceImpl
import com.sd.isp.service.service.ServiceServiceImpl

// Place your Spring DSL code here
beans = {
    //resources
    carResource(CarResourceImpl)
    clientResource(ClientResourceImpl)
    employeeResource(EmployeeResourceImpl)
    partResource(PartResourceImpl)
    serviceResource(ServiceResourceImpl)

    //services
    carService(CarServiceImpl)
    clientService(ClientServiceImpl)
    employeeService(EmployeeServiceImpl)
    partService(PartServiceImpl)
    serviceResource(ServiceServiceImpl)


}