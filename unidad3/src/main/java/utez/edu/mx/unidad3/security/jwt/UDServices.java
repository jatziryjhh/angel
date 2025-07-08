package utez.edu.mx.unidad3.security.jwt;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import utez.edu.mx.unidad3.modules.user.BeanUser;
import utez.edu.mx.unidad3.modules.user.UserRepository;

import java.util.Collection;
import java.util.Collections;

//PASO TRES: CREAR EL SERVICIO DE GESTION DE AUTORIDADES
@Service
public class UDServices implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Aqui lo que estamos haciendo es buscar primero al usuario
        BeanUser found = userRepository.findByUsername(username).orElse(null);
        if (found == null) throw new UsernameNotFoundException("Usuario no encontrado");

        //Generar las autoridades para el contexto de seguridad
        //authority= ROLE_ADMIN, ROLE_EMPLOYEE --> filterChain
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + found.getRol().getName());

        //Retornar al objeto de usaurio para registar en el contexto de seguridad
        return  new User(
                found.getUsername(),
                found.getPassword(),
                Collections.singleton(authority)
        );
    }
}
