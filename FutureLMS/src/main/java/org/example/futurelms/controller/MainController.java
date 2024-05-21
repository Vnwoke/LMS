package org.example.futurelms.controller;

import org.example.futurelms.dto.NewCourseDto;
import org.example.futurelms.dto.NewTopicDto;
import org.example.futurelms.dto.RegisterUserDto;
import org.example.futurelms.model.Course;
import org.example.futurelms.model.Topic;
import org.example.futurelms.model.User;
import org.example.futurelms.repository.CourseRepository;
import org.example.futurelms.repository.TopicRepository;
import org.example.futurelms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        RegisterUserDto userDto = new RegisterUserDto();
        model.addAttribute("userDto", userDto);
        return "register";
    }

    @PostMapping("/register")
    public String doRegister(@ModelAttribute RegisterUserDto userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setRole("ROLE_STUDENT");
        user.setFullName(userDto.getFullName());
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepository.save(user);
        return "redirect:/login";
    }

    @GetMapping("/courses")
    public String courses(Model model) {
        List<Course> courses = courseRepository.findAll();
        model.addAttribute("courses", courses);
        return "courses";
    }

    @GetMapping("/course/{slug}")
    public String course(@PathVariable String slug, Model model) {
        Course course = courseRepository.findBySlug(slug);
        model.addAttribute("course", course);
        return "course";
    }

    @GetMapping("/tutor/teaching")
    public String teaching(Model model) {
        User user = getCurrentUser();
        NewCourseDto courseDto = new NewCourseDto();
        NewTopicDto topicDto = new NewTopicDto();
        List<Course> courses = courseRepository.findAllByTutorId(user.getId());
        model.addAttribute("courses", courses);
        model.addAttribute("courseDto", courseDto);
        model.addAttribute("topicDto", topicDto);
        return "teaching";
    }

    @PostMapping("/tutor/new/course")
    public String addNewCourse(@ModelAttribute NewCourseDto courseDto) {
        User user = getCurrentUser();
        Course course = new Course();
        course.setTitle(courseDto.getTitle());
        course.setCategory(courseDto.getCategory());
        course.setTutor(user);

        String filename = convertImageFilename(courseDto.getTitle());
        course.setSlug(filename);

        Path resourceDirectory = Paths.get("src","main","resources", "static", "courses");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
        try {
            byte[] bytes = courseDto.getImage().getBytes();
            Path path = Paths.get(absolutePath + "/" + filename + ".jpg");
            System.out.println(path);
            Files.write(path, bytes);
            courseRepository.save(course);
        } catch (IOException e) {
            System.out.println("Could not upload image");
            System.out.println("Course not saved");
        }
        return "redirect:/tutor/teaching";
    }

    @PostMapping("/tutor/new/topic")
    public String addNewTopic(@ModelAttribute NewTopicDto topicDto) {
        Optional<Course> courseOptional = courseRepository.findById(topicDto.getCourseId());
        Course course = courseOptional.get();
        Topic topic = new Topic();
        topic.setTitle(topicDto.getTitle());
        topic.setOrderNo(1L);
        topic.setCourse(course);
        topic.setVideoUrl("https://www.youtube.com/embed/" + topicDto.getVideo());
        topic.setContent(topicDto.getContent());
        topicRepository.save(topic);
        return "redirect:/tutor/teaching";
    }

    @GetMapping("/admin/users")
    public String users(Model model) {
        List<User> tutors = userRepository.findAllByRole("ROLE_TUTOR");
        List<User> students = userRepository.findAllByRole("ROLE_STUDENT");

        model.addAttribute("tutors", tutors);
        model.addAttribute("students", students);

        return "users";
    }

    public User getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUsername(auth.getName());
        return user;
    }

    public String convertImageFilename(String str)
    {
        int n = str.length();
        String fileName = "";

        for (int i = 0; i < n; i++)
        {
            if (str.charAt(i) == ' ' || str.charAt(i) == '_')
                fileName = fileName + '-';
            else
                fileName = fileName +
                        Character.toLowerCase(str.charAt(i));
        }

        return fileName;
    }
}
