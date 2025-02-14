package br.edu.ifba.demo.frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/relatorios")
public class RelatorioController {

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("relatorios/index");
        mv.addObject("data", new double[] { 9.3, 8.2, 8.6, 10, 8.6, 8.7, 7.4, 10, 5.9, 6, 7.5, 10, 8.6, 9, 6.5 });
        return mv;
    }
}
