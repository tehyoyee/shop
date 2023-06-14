package tehyoyee.github.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import tehyoyee.github.shop.dto.ItemFormDto;

@Controller
public class ItemController {

	@GetMapping("/admin/item/new")
	public String itemForm(Model model) {
		model.addAttribute("itemFormDto", new ItemFormDto());
		return "/item/itemForm";
	}
}
