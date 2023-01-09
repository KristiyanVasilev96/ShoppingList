package com.example.listofshooping.web;

import com.example.listofshooping.model.entity.CategoryName;
import com.example.listofshooping.model.entity.User;
import com.example.listofshooping.security.CurrentUser;
import com.example.listofshooping.service.ProductService;
import com.example.listofshooping.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final CurrentUser currentUser;
    private final UserService userService;

    private final ProductService productService;

    public HomeController(CurrentUser currentUser, UserService userService, ProductService productService) {
        this.currentUser = currentUser;
        this.userService = userService;
        this.productService = productService;
    }

    @GetMapping("/")
    public String index(Model model) {
        if (currentUser.getId() == null) {

            return "index";
        }

        User user = userService.findById(currentUser.getId());
        model.addAttribute("totalSum",productService.totalSumOfProducts());
        model.addAttribute("drinks",productService.findAllProductsByCategoryName(CategoryName.DRINK));
        model.addAttribute("household",productService.findAllProductsByCategoryName(CategoryName.HOUSEHOLD));
        model.addAttribute("food",productService.findAllProductsByCategoryName(CategoryName.FOOD));
        model.addAttribute("other",productService.findAllProductsByCategoryName(CategoryName.OTHER));



        return "home";

    }
}
