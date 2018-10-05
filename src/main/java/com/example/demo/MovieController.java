package com.example.demo;


import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Repository;


import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

@Controller
public class MovieController implements Serializable{

    private final Logger log = Logger.getLogger(MovieController.class.getName());
    private boolean dontLoadTooMany = true ;





    @Autowired
    private UserService userService;



    @GetMapping("")
    public String home()throws IOException, ClassNotFoundException{

        log.info("Index called");
        if (dontLoadTooMany){
            userService.getData();
            dontLoadTooMany = false;
        }




        return "index";
    }


    @GetMapping("/aboutUs")
    public String aboutUS(){

        log.info("about us called");

        return "aboutUs";
    }

    @GetMapping("/contact")
    public String contact(){

        log.info("contact called");

        return "contact";
    }

    @GetMapping("/create")
    public String create(Model model){

        log.info("create called");
        model.addAttribute("movie", new Movie());
        // "movie" er nøglen der defineres i create.html på linie 12
        // og bruges til at optage/modtage data ved submit på L. 15, 17 & 19


        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Movie movie)throws IOException, ClassNotFoundException {


        log.info("some monkey is trying to create some shitty movie");

        userService.create(movie);
        userService.saveData();


        return "redirect:/movie";
    }

    @PostMapping ("/search")
    public String search(@ModelAttribute String title){

        //userService.searchByTitle(movie);
        log.info("some monkey managed to search something");
        userService.clearSearch();
        userService.searchByTitle(title);

        return "redirect:/search";
    }

    @GetMapping("/search")
    public String search(Model model){

        log.info("some monkey called search");
        List<Movie> movieList = userService.getSearched();
        model.addAttribute("Movies", movieList);

        return "search";
    }

    @GetMapping("/movie")
    public String movie(Model model)throws IOException, ClassNotFoundException{
        List<Movie> movieList = userService.getMovies();
        model.addAttribute("Movies", movieList);
        //Movies er nøglen
        // inde i movie.html 129 er Movies nøglen til at få det ind
        // og "movie" er til for each loopet

        log.info("movie called");

        return "movie";
    }



}
