import com.google.inject.AbstractModule;
import dao.UserDao;
import dao.UserDaoImpl;
import services.UserManagementService;
import services.UserManagementServiceImpl;

/**
 * Created by sameerap on 22/05/2017.
 */

public class Module extends AbstractModule {
    protected void configure() {

        bind(UserManagementService.class)
                .to(UserManagementServiceImpl.class)
                .asEagerSingleton();

        bind(UserDao.class)
                .to(UserDaoImpl.class)
                .asEagerSingleton();
    }
}
