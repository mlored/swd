import com.sd.isp.dto.client.ClientDTO;
import com.sd.isp.dto.location.city.CityDTO;
import com.sd.isp.dto.location.country.CountryDTO;
import com.sd.isp.dto.location.state.StateDTO;

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

		final CountryDTO countryDTO = new CountryDTO();
		countryDTO.setName("Paraguay");
		final CountryDTO country = client.resource(BASE_URL + "/country").entity(countryDTO).post(CountryDTO.class);

		final StateDTO stateDTO = new StateDTO();
		stateDTO.setCountryId(country.getId());
		stateDTO.setName("Itapua");
		final StateDTO state = client.resource(BASE_URL + "/state").entity(stateDTO).post(StateDTO.class);

		final CityDTO cityDTO = new CityDTO();
		cityDTO.setCountryId(country.getId());
		cityDTO.setStateId(state.getId());
		cityDTO.setName("Encarnacion");
		final CityDTO city = client.resource(BASE_URL + "/city").entity(cityDTO).post(CityDTO.class);

		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setDocument("4585dad2");
		clientDTO.setFirstName("juan3333");
		clientDTO.setLastName("pere3333z");
		clientDTO.setCityId(city.getId());

		client.resource(BASE_URL + "/client").entity(clientDTO).post(ClientDTO.class);

	}
}
