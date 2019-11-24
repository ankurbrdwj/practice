package gangoffour.functional.creational.mapper;

import gangoffour.functional.creational.mapper.domain.User;

public class UserDTO {
    private String username;
    private String fullName;
    private boolean active;
    public UserDTO(User user) {
        username = user.getUsername();
        fullName = user.getFirstName() + " " + user.getLastName().toUpperCase();
        active = user.getDeactivationDate() == null;
    }
}
