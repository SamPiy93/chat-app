import com.google.inject.AbstractModule;
import dao.MessageDao;
import dao.MessageDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;
import services.MessageService;
import services.MessageServiceImpl;
import services.UserManagementService;
import services.UserManagementServiceImpl;

public class Module extends AbstractModule {
    protected void configure() {

        bind(UserManagementService.class)
                .to(UserManagementServiceImpl.class)
                .asEagerSingleton();

        bind(UserDao.class)
                .to(UserDaoImpl.class)
                .asEagerSingleton();

        bind(MessageService.class)
                .to(MessageServiceImpl.class)
                .asEagerSingleton();

        bind(MessageDao.class)
                .to(MessageDaoImpl.class)
                .asEagerSingleton();
    }
}
