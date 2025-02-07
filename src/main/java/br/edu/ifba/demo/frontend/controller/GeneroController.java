package br.edu.ifba.demo.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifba.demo.frontend.dto.GeneroDTO;
import br.edu.ifba.demo.frontend.service.GeneroService;

@Controller
@RequestMapping("/generos")
public class GeneroController {

    @Autowired
    private GeneroService generoService;

    @GetMapping("/")
    public ModelAndView TodosGeneros() {
        var obj = generoService.listAllGeneros();
        ModelAndView mv = new ModelAndView();
        mv.addObject("generos", obj);
        mv.setViewName("generos/indexGenero");
        return mv;
    }

    @PostMapping("/")
    public ModelAndView salvarGenero(@ModelAttribute("genero") GeneroDTO generoDTO) {
        System.out.println(generoDTO);
        generoService.salvarOuAtualizar(generoDTO);
        ModelAndView mv = new ModelAndView("redirect:/generos/");
        return mv;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
        generoService.delete(id);
        ModelAndView mv = new ModelAndView("redirect:/generos/");
        return mv;
    }

    @GetMapping("/novo")
    public ModelAndView novoGenero() {
        ModelAndView mv = new ModelAndView("generos/form");
        mv.addObject("genero", new GeneroDTO());
        return mv;
    }

    @GetMapping("/view/{id}")
    public ModelAndView exibirGenero(@PathVariable("id") Long id) {
        GeneroDTO genero = generoService.getById(id);
        ModelAndView mv = new ModelAndView("generos/form");
        mv.addObject("genero", genero);
        mv.addObject("view", true);
        return mv;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editarGenero(@PathVariable("id") Long id) {
        GeneroDTO genero = generoService.getById(id);
        ModelAndView mv = new ModelAndView("generos/form");
        mv.addObject("genero", genero);
        mv.addObject("view", false);
        return mv;
    }
}
