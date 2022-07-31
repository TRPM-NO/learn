package web.noname.service.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import web.noname.service.domain.item.Item;
import web.noname.service.domain.item.ItemCode;
import web.noname.service.domain.item.ItemRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/item")
public class ItemController {
    private final ItemRepository itemRepository;

    @GetMapping
    public String items(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "item/items";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("item", new Item());
        return "item/addForm";
    }

    @GetMapping("/{itemId}")
    public String item(@PathVariable long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "item/item";
    }

    @PostMapping("/add")
    public String addItem(@ModelAttribute Item item, RedirectAttributes redirectAttributes, Model model) {
        Item savedItem = itemRepository.save(item);
        redirectAttributes.addAttribute("itemId", savedItem.getId());
        return "redirect:/item/{itemId}";
    }





    /**
     * SelectOptionValues
     */
    @ModelAttribute("itemStatusCodes")
    public List<ItemCode> itemStatusCodes() {
        List<ItemCode> itemStatusCodes = new ArrayList<>();
        itemStatusCodes.add(new ItemCode("new", "label.item.itemStatusSelect.new"));
        itemStatusCodes.add(new ItemCode("used", "label.item.itemStatusSelect.used"));
        return itemStatusCodes;
    }

    @ModelAttribute("deliveryMethodCodes")
    public List<ItemCode> deliveryMethodCodes() {
        List<ItemCode> deliveryMethodCodes = new ArrayList<>();
        deliveryMethodCodes.add(new ItemCode("fast", "label.item.deliveryMethodSelect.fast"));
        deliveryMethodCodes.add(new ItemCode("normal", "label.item.deliveryMethodSelect.normal"));
        deliveryMethodCodes.add(new ItemCode("slow", "label.item.deliveryMethodSelect.slow"));
        return deliveryMethodCodes;
    }
}
