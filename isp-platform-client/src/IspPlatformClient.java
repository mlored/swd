import com.sd.isp.dto.car.CarDTO;
import com.sd.isp.dto.car.CarResult;
import com.sd.isp.dto.client.ClientDTO;
import com.sd.isp.dto.client.ClientResult;


public class IspPlatformClient {

	public static void main(String[] args) {

		final String BASE_URL = "http://localhost:8080/isp-platform/rest";

		com.sun.jersey.api.client.Client client = com.sun.jersey.api.client.Client.create();

		// ClientDTO dto =
		// client.resource("http://localhost:28080/isp-platform/rest/client/1891214877").get(ClientDTO.class);

		// System.out.println(dto.getDocument());

		/*
		 * ClientDTO clientDTO = new ClientDTO();
		 * clientDTO.setDocument("4585dad2");
		 * clientDTO.setFirstName("juan3333");
		 * clientDTO.setLastName("pere3333z");
		 * 
		 * client.resource(BASE_URL +
		 * "/client").entity(clientDTO).post(ClientDTO.class);
		 */

		/*
		 * ClientResult clientResult =
		 * client.resource("http://localhost:28080/isp-platform/rest/client"
		 * ).get(ClientResult.class); for (ClientDTO c :
		 * clientResult.getClients()) { System.out.println(c.getFirstName()); }
		 */
		
		CarResult carResult = client.resource("http://localhost:8080/isp-platform/rest/car").get(CarResult.class);
		for (CarDTO c :carResult.getCars()) { System.out.println(c.getMark()); }
		
		CarDTO dto = new CarDTO();
		dto.setMark("Porsche");
		CarDTO newCar = client.resource("http://localhost:8080/isp-platform/rest/car").entity(dto).post(CarDTO.class);
		System.out.println(newCar.getMark());
	}
}
