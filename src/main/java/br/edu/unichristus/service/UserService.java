package br.edu.unichristus.service;

import br.edu.unichristus.domain.dto.UserDTO;
import br.edu.unichristus.domain.dto.UserLowDTO;
import br.edu.unichristus.domain.model.User;
import br.edu.unichristus.exception.CommonsException;
import br.edu.unichristus.repository.UserRepository;
import br.edu.unichristus.utils.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public UserLowDTO save(UserDTO user){
        var userEntity = MapperUtil.parseObject(user, User.class);
        var savedUser = repository.save(userEntity);
        return MapperUtil.parseObject(savedUser, UserLowDTO.class);
    }

    public UserLowDTO updateUser(UserDTO user){
        var userEntity = MapperUtil.parseObject(user, User.class);
        var savedUser = repository.save(userEntity);
        return MapperUtil.parseObject(savedUser, UserLowDTO.class);
    }

    public List<UserLowDTO> findAll(){
        var listUsers = repository.findAll();
        return MapperUtil.parseListObjects(listUsers, UserLowDTO.class);
    }

    public User findById(Long id){
        var userEntity = repository.findById(id);
        if (userEntity.isPresent()){
            throw new CommonsException(HttpStatus.NOT_FOUND,
                    "unichristus.user.findById.notFound",
                    "Usuário não encontrado!");
        }
        return repository.findById(id).get();
    }

    public void deleteUser(Long id){
        repository.deleteById(id);
    }

//    public UserDTO getRolesByUserId(Long id){
//        var userEntity = repository.findById(id);
//        if (userEntity.isPresent()){
//            throw new CommonsException(HttpStatus.NOT_FOUND,
//                    "unichristus.user.findById.notFound",
//                    "Usuário não encontrado!");
//        }
//        var userRolesDTO = MapperUtil.parseObject(userEntity, UserDTO.class);
//        UserDTO.setRoles(new String[]{"MANAGER","ADMIN","COMMON"});
//        return userRolesDTO;
//    }

}
