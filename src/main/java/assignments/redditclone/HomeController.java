package assignments.redditclone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    RedditcloneRepository redditcloneRepository;

    @RequestMapping("/index")
    public String listCourses(Model model){
        model.addAttribute("contents",redditcloneRepository.findAll());
        return "index";
    }

    @GetMapping("/addlink")
    public String courseForm(Model model){
        model.addAttribute("content",new Content());
        //model.addAttribute("user",new User());
        return "addlink";
    }

    @PostMapping("/process")
    public String processForm(@Valid Content content, BindingResult result){
        if(result.hasErrors()){
            return "addlink";
        }
        redditcloneRepository.save(content);
        return "redirect:/index";
    }



/*
    @GetMapping("/addlink")
    public String courseForm(Model model){
        model.addAttribute("content",new Content());
        return "addlink";
    }



    @RequestMapping("/detail/{id}")
    public String showCourse(@PathVariable("id") long id, Model model){
        model.addAttribute("content", redditcloneRepository.findOne(id));
        return "home";
    }
    */

}
