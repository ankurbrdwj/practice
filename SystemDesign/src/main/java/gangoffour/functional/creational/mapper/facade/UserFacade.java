package gangoffour.functional.creational.mapper.facade;

import gangoffour.functional.creational.mapper.UserDTO;
import gangoffour.functional.creational.mapper.repo.UserRepo;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class UserFacade {
        private UserRepo userRepo;
        public List<UserDTO> getAllUsers() {
            return userRepo.findAll().stream().map(UserDTO::new).collect(toList());
        }
}
