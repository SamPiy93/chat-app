package dao;

import models.UserModel;

import java.util.List;

/**
 * Created by sameerap on 22/05/2017.
 */
public class UserDaoImpl implements UserDao {
    @Override
    public UserModel add(UserModel entity) {
        entity.save();
        return entity;
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
        return null;
    }

    @Override
    public UserModel getDetailsById(int id) {
        return null;
    }
}
