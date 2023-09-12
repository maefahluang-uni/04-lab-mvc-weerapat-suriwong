package th.mfu;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.objenesis.instantiator.gcj.GCJInstantiator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ConcertController {
    // TODO: create hashmap of concerts for storing data
private int nextld = 1;
private HashMap<Integer,Concert>concertMap = new HashMap<Integer,Concert>();
    //TODO: add initbinder to convert date
    @InitBinder
public final void initbinderUsuariosFormValidator(final WebDataBinder binder, final Locale locale) {
 final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
 binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
}

   @GetMapping("/concerts")
    public String listConcerts(Model model) {
        // TODO: add concerts to model
    model.addAttribute("concerts",concertMap.values());
        // TODO: return a template to list concerts
        return "list-concert";
    }

    @GetMapping("/add-concert")
    public String addAConcertForm(Model model) {
        // TODO: pass blank concert to a form
     model.addAttribute("concert", new Concert());
        // TODO: return a template for concert form
        return "add-concert-form";
    }

    @PostMapping("/concerts")
    public String saveConcert(@ModelAttribute Concert concert) {
        // TODO: add concert to list of concerts
     concert.setld(nextld);
        // TODO: increment nextId
      concertMap.put(nextld,concert);
     nextld++;

        // TODO: redirect to list concerts
        return "redirect:/concerts";
    }

    @GetMapping("/delete-concert/{id}")
    public String deleteConcert(@PathVariable int id) {
        // TODO: remove concert from list of concerts
        concertMap.remove(id);
        // TODO: redirect to list concerts
        return "redirect:/concerts";
    }

    
    @GetMapping("/delete-concert")
    public String removeAllConcerts() {
        //TODO: clear all employees and reset id
        concertMap.clear();
        nextld = 1;
        // TODO: redirect to list concerts
        return "redirect:/concerts";
    }

}
