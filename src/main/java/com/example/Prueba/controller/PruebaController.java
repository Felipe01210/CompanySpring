package com.example.Prueba.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Prueba.model.Calculator;

@Controller
public class PruebaController {
	
	@GetMapping("/")
	public String holaMundo(Model model, @RequestParam("name") Optional<String> name) {
		model.addAttribute("name", name.orElse("Desconocido"));
		return "index";
	}
	
	@GetMapping("/addUser")
	public String addUser() {
		return "user/addUser";
	}
	
	@GetMapping("/calculator")
	public String calculator(Model model) {
		Calculator calculator = new Calculator();
		
		model.addAttribute("calc", calculator);
		return "functional/calculator";
	}
	
	@GetMapping("/resolver")
	public String resolver(Model model,@Validated @ModelAttribute("calc") Calculator calculator, BindingResult bindingResult) {
		Calculator newCalculator = new Calculator();
		
		model.addAttribute("calc", newCalculator);
		String resultado = "";
		
		if(bindingResult.hasErrors()) {
			resultado = "Los campos no pueden ser nulos o estar vacios";
		}else {
			if(calculator.getOperator().equals("+") || calculator.getOperator().equals("-") || calculator.getOperator().equals("x") || calculator.getOperator().equals("/")) {
				resultado = "Operacion: "+ calculator.getNum1() + calculator.getOperator() + calculator.getNum2() + " | Resultado: " + calculator.getResult();
			}else {
				resultado = "Operador no reconocido: introduzca uno de estos +, -, x, /.";
			}
		}
		model.addAttribute("result", resultado);
		return "functional/calculator";
	}

}
