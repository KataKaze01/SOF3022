package poly.com.controller.PS34126_Lab2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product")
public class B4ProductController {

    private List<Product> list = new ArrayList<>();

    @ModelAttribute("products")
    public List<Product> getProduct(){
        return list;
    }

    @GetMapping("/form4")
    public String form(Model model){
        Product product = new Product();
        product.setName("iPhone 30");
        product.setPrice(20.0);
        model.addAttribute("product", product);
        return "Product4";
    }

    @PostMapping("/check4")
    public String check(@ModelAttribute Product product, Model model){
        list.add(product);
        model.addAttribute("product2",product);
        return "Product4";
    }
}

