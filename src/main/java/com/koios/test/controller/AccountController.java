package com.koios.test.controller;

import com.koios.test.model.Account;
import com.koios.test.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    //display list of accounts
    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listAccounts", accountService.getAllAccounts());
        return "index";
    }

    @GetMapping("/showNewAccountForm")
    public String showNewAccountForm(Model model){
        Account account = new Account();
        model.addAttribute("account", account);
        return "account_new";
    }

    @PostMapping("/saveAccount")
    public String saveAccount(@ModelAttribute("account") Account account){
        System.out.println(account.getDateOfBirth());
        accountService.saveAccount(account);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable (value = "id") long id, Model model){
        Account account = accountService.getAccountById(id);
        model.addAttribute("account", account);
        return "account_update";
    }

    @GetMapping("/deleteAccount/{id}")
    public String deleteAccount(@PathVariable (value="id") long id){
        this.accountService.deleteAccountById(id);
        return "redirect:/";
    }


}
