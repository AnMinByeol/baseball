package com.baseballproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.baseballproject.Service.cheerService;
import com.baseballproject.entity.LcheerBoard;



@Controller
public class cheerController {

  @Autowired
  private cheerService lcheerService;

  @GetMapping("/twins/cheer/write")
  public String LcheerWriteForm(){
    return "./twins/cheer_twins_write";
  }
  @PostMapping("/twins/cheer/write")
  public String LcheerWritePost(LcheerBoard lcheerBoard){
    lcheerService.Lcheerwrite(lcheerBoard);
    return "redirect:/twins/cheer/list";
  }

  @GetMapping("/twins/cheer/list")
  public String lcheerboardlist(Model model){
    model.addAttribute("list",lcheerService.lcheerboardlist());
    return "./twins/cheer_twins";
  }

  @GetMapping("/twins/cheer/view")
  public String lcheerboardview(Model model, Integer id){
    model.addAttribute("view", lcheerService.lcheerboardview(id));
    return "./twins/cheer_twins_view";
  }

  @GetMapping("/twins/cheer/delete")
  public String lcheerboarddel(Integer id){
    lcheerService.lcheerboardDel(id);
    return "redirect:/twins/cheer/list";
  }

}