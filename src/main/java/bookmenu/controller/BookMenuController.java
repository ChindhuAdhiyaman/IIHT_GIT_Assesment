/**
 * 
 */
package bookmenu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 
 *
 */
@Controller
public class BookMenuController {
    @RequestMapping("/menu")
    public ModelAndView loadMenuConsole() {
        return new ModelAndView("BookMenu");
    }
}
