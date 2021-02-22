package com.example.demo.controller.contents;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.BattleType;
import com.example.demo.service.BattleTypeService;

@Controller

public class ChooseBattleTypeController{

	@Autowired
	BattleTypeService battleTypeService;

	@Autowired
	public BattleType battleType2;

	@GetMapping("/findBattleType")
	public String getChooseBattleType(@ModelAttribute BattleType battleType ,Model model) {

		List<BattleType> getList = new ArrayList<>();

		getList = battleTypeService.selectMany();

		model.addAttribute("battleTypes", getList);

		System.out.println(getList);

		return "/contents/battleTypeChoose";

	}

	@PostMapping("/ChooseBattleType")
	public String postBattleType(@ModelAttribute BattleType battleType ,Model model) {

		System.out.println(battleType);

		battleType2.setName(battleType.getName());

		//ユーザーが選んだ戦型情報

		model.addAttribute("typeName",battleType.getName());

		return "redirect:/room";
	}
}
