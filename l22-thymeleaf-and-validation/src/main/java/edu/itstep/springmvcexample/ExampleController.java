package edu.itstep.springmvcexample;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ExampleController {


    @GetMapping("/users/{userId}/cars")
    public String getUserCars() {
        return "";
    }


    @GetMapping("/users/{userId}/cars/{carId}")
    public String getUserCar() {
        return "";
    }


    @GetMapping("/greetings")
    public String greetings(Model model) {
        model.addAttribute("message", "Hello world!");
        return "index";
    }

//    @GetMapping("/login")
//    public String login(Model model) {
//        model.addAttribute("formData", new Student(1, "Sasha", "Sashasasadas"));
//        return "login";
//    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute("formData") @Valid Student student, Model model) {
        System.out.println(student);
        return "redirect:/greetings";
    }


    @GetMapping("/style")
    public String style(Model model) {
        return "with-style";
    }

    @GetMapping("/block")
    public String block(Model model) {
        model.addAttribute("message", "Hello world!");
        return "block-example";
    }

    @GetMapping("/conditions")
    public String condition(@RequestParam(required = false, defaultValue = "false", name = "is_admin") boolean isAdmin,
                            Model model) {
        model.addAttribute("isAdmin", isAdmin);
        return "condition";
    }

    @GetMapping("/conditions2")
    public String condition2(@RequestParam(required = false, defaultValue = "F", name = "gender") String gender, Model model) {
        model.addAttribute("gender", gender);
        model.addAttribute("name", "Masha");
        return "condition2";
    }

    @GetMapping("/conditions3")
    public String condition3(@RequestParam(required = false, defaultValue = "admin", name = "role") String role,
                             Model model) {
        model.addAttribute("role", role);
        return "condition3";
    }

/*
    @GetMapping("/loops")
    public String loops(Model model) {
        List<Student> students = List.of(new Student(1, "Sasha"), new Student(2, "Masha"), new Student(3, "Slava"));
        model.addAttribute("students", students);
        return "loop";
    }
*/
    @GetMapping("/loops2")
    public String loops2(Model model) {
        List<Student> students = List.of(new Student(1, "Sasha"), new Student(2, "Masha"), new Student(3, "Slava"));
        model.addAttribute("students", students);
        return "loop2";
    }
/*
    @GetMapping("/object")
    public String object(Model model) {
        List<Student> students = List.of(new Student(1, "Sasha"), new Student(2, "Masha"), new Student(3, "Slava"));
        model.addAttribute("students", students);
        return "object";
    }
*/

    @GetMapping("/fragments")
    public String fragments() {
        return "fragments";
    }

/*    @GetMapping("/fragments2")
    public String fragments2(Model model) {
        List<Student> students = List.of(new Student(1, "Sasha"), new Student(2, "Masha"), new Student(3, "Slava"));
        model.addAttribute("students", students);
        return "fragments-with-parameters";
    }*/


}
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//class Student {
//    @Null(groups = View.Public.class)
//    @NotNull(groups = Group.OnUpdate.class)
//    private int id;
//    @NotBlank(message = "Name cannot be blank")
//    private String name;
//    @NotBlank(message = "Last name cannot be blank")
//    @Email
//    private String lastName;
//
//    @Size(min = 18, max = 120, message = "Invalid age {min} {max}")
//    private int age;
//
//
//    public String getUser() {
//        return "Test User";
//    }
//}

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
class Student {
    private int id;
    private String name;
    //private String lastName;
}

final class Group {
    final static class OnUpdate {
    }
}

interface View {
    interface Public {
    }
}

interface OnCreate {
}

interface OnUpdate {
}