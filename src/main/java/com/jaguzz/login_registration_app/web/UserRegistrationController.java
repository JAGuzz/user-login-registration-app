 package com.jaguzz.login_registration_app.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jaguzz.login_registration_app.service.UserService;
import com.jaguzz.login_registration_app.web.dto.UserRegistrationDto;


@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    private UserService userService;

    public UserRegistrationController(UserService userService) {

        super();
        this.userService = userService;
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto){
        userService.save(registrationDto);
        return "redirect:/registration?success";

    }

    
    //Creacion del objeto vacio (empty object)
    // @ModelAttribute("user")
    // public UserRegistrationDto userRegistrationDto(){          
    //     return new UserRegistrationDto();
    // }
    // es posible cambiar la anterior configuracion agregando ciertas configuraciones en el siguiente
    // handler method, se pasa por argumento un objeto model y despues llamamos al metodo addAtribute
    // de la interfaz model, tal como se muestra a continuacion:
    
    @GetMapping
    public String showRegistrationForm(Model model){
        model.addAttribute("user", new UserRegistrationDto());
        return "registration";
    }

}
