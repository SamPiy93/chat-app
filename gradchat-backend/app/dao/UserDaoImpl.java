package dao;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Finder;
import dto.UserDto;
import models.UserModel;

import javax.persistence.PersistenceException;
import java.util.List;

/**
 * Created by sameerap on 22/05/2017.
 */
public class UserDaoImpl implements UserDao {

//    List<UserModel> customers =
//            UserModel.find
//                    .findList();

    @Override
    public UserModel add(UserModel entity) {
        try {
            entity.save();
            System.out.println(entity);
            return entity;
        } catch(PersistenceException e) {
            System.out.println(e.getLocalizedMessage());
            return entity;
        }
    }

    @Override
    public UserModel update(UserModel updateEntity) {
        return null;
    }

    @Override
    public boolean delete(UserModel id) {
        return false;
    }

    @Override
    public List<UserModel> getAllRecords() {
        UserModel.find.findList().forEach(x->System.out.println(x.toString()));
        return UserModel.find.findList();
    }

    @Override
    public UserModel getDetailsById(Long id) {
        return UserModel.find.byId(id);
    }

    @Override
    public UserModel getLoggedInUser(UserDto userDto) {
        return UserModel.find
                .where()
                .eq("USER_EMAIL", userDto.getUserEmail())
                .eq("USER_PASSWORD", userDto.getUserPassword())
                .findUnique();
    }
}
