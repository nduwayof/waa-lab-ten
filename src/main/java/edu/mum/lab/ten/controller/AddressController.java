package edu.mum.lab.ten.controller;

import edu.mum.lab.ten.domain.Address;
import edu.mum.lab.ten.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/address")
public class AddressController {

    private IAddressService addressService;

    @Autowired
    public AddressController(IAddressService addressService){
        this.addressService = addressService;
    }

    @GetMapping("/list")
    public String addressesList(Model model){
        List<Address> addressList = addressService.findAll();
        model.addAttribute("addressList", addressList);
        return "addressList";
    }

    @GetMapping("/new")
    public String addressForm(@ModelAttribute("address") Address address){
        return "address";
    }

    @PostMapping("/save")
    public String saveAddress(@Valid Address address, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("address", address);
            return "address";
        }
        this.addressService.save(address);
        return "redirect:/address/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteAddress(@PathVariable Long id){
        this.addressService.delete(id);
        return "redirect:/address/list";
    }

    @GetMapping("/update/{id}")
    public String updateAddressForm(@PathVariable Long id, Model model){
        Address address = this.addressService.findById(id);
        model.addAttribute("address", address);
        return "address";
    }

}
