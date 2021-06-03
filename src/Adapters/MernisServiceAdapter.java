package Adapters;

import Abstract.CustomerCheckService;
import Entities.Customer;
import MernisService.NBBKPSPublicSoap;


public class MernisServiceAdapter implements CustomerCheckService {

    @Override
    public boolean CheckIfRealPerson(Customer customer) {
        NBBKPSPublicSoap client = new NBBKPSPublicSoap();
        try {
            return client.TCKimlikNoDogrula(Long.parseLong(customer.getNationalityId()), customer.getFirstName().toUpperCase(), customer.getLastName().toUpperCase(), customer.getDateOfBirth().getYear());
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
