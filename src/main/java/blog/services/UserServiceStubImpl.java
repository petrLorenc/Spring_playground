package blog.services;

import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Created by United121 on 1/25/2017.
 */
@Service
public class UserServiceStubImpl implements UserService {
    @Override
    public boolean authenticate(String username, String password) {
        return Objects.equals(username,password);
    }
}
