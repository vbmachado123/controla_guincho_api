package br.com.tevitto.controla_guincho.service;

import br.com.tevitto.controla_guincho.data.dto.UserSystemDto;
import br.com.tevitto.controla_guincho.data.model.Permission;
import br.com.tevitto.controla_guincho.data.model.UserSystem;
import br.com.tevitto.controla_guincho.repository.PermissionRepository;
import br.com.tevitto.controla_guincho.repository.UserSystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserSystemService implements UserDetailsService {

    @Autowired
    private UserSystemRepository userSystemRepository;
    private UserSystem userSystem = new UserSystem();

    @Autowired
    private PermissionRepository permissionRepository;
    private Permission permission = new Permission();

    public UserSystemDto createUser(UserSystemDto dto) {

        // Definindo Permissões Para o Usuário
        List<Permission> permissions = new ArrayList<>();
        permissions.add(permissionRepository.getOne(1L));

        userSystem.setAccountNonExpired(true);
        userSystem.setAccountNonLocked(true);
        userSystem.setCredentialsNonExpired(true);
        userSystem.setEnabled(true);
        userSystem.setPermissions(permissions);

        userSystem.setUserName(dto.getEmail());
        userSystem.setFullName(dto.getNome());
        userSystem.setPassword(passwordEncoder(dto.getSenha()));

        UserSystem idSalvo = userSystemRepository.save(userSystem);

        dto.setId(idSalvo.getId());

        return dto;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        var user = userSystemRepository.findByUsername(userName);
        if (user != null)
            return (UserDetails) user;
        else
            throw new UsernameNotFoundException("Usuário " + userName + " Não Encontrado");
    }

    private String passwordEncoder(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        String result = encoder.encode(password);
        return result;
    }

    private boolean passwordDecoder(String dto, String model) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        boolean matches = encoder.matches(dto, model);
        return matches;
    }

    public UserSystemDto convertUserSystem(UserSystem user) {

        UserSystemDto dto = new UserSystemDto();

        dto.setId(user.getId());
        dto.setEmail(user.getUserName());
        dto.setNome(user.getFullName());
        dto.setSenha(user.getPassword());

        return dto;
    }
}
