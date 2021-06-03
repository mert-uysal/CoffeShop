import Abstract.BaseCustomerManager;
import Abstract.CustomerCheckService;
import Adapters.MernisServiceAdapter;
import Concrete.CustomerCheckManager;
import Concrete.NeroCustomerManager;
import Concrete.StarbucksCustomerManager;
import Entities.Customer;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(1,"Engin","Demiroğ", LocalDate.of(1985,1,6),"28861499108");

        BaseCustomerManager customerManager = new NeroCustomerManager();
        customerManager.save(customer);

        CustomerCheckService mernisControl = new MernisServiceAdapter();
        CustomerCheckService fakeControl = new CustomerCheckManager();

        BaseCustomerManager fakeCustomerManager = new StarbucksCustomerManager(fakeControl);
        fakeCustomerManager.save(customer); //prints saved db

        BaseCustomerManager mernisCustomerManager = new StarbucksCustomerManager(mernisControl);
        mernisCustomerManager.save(customer); //depends on person verification
    }
}
