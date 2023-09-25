package com.example.music.controller;

import com.example.music.dto.MusicDto;
import com.example.music.model.Music;
import com.example.music.service.IMusicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/music")
public class MusicController {
    @Autowired
    private IMusicService musicService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String showList(Model model) {
        List<Music> musicList = musicService.findAll();
        model.addAttribute("music", musicList);
        return "list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showFormCreate(Model model) {
        model.addAttribute("musicDto", new MusicDto());
        return "create";
    }

    @RequestMapping(value = "/confirm-create", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute MusicDto musicDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "create";
        }
        Music music = new Music();
        BeanUtils.copyProperties(musicDto, music);
        musicService.add(music);
        redirectAttributes.addFlashAttribute("message", "Created successfully !");
        return "redirect:/music";
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
    public String showFormUpdate(@PathVariable int id, Model model) {
        MusicDto musicDto = new MusicDto();
        Music music = musicService.findById(id);
        BeanUtils.copyProperties(music, musicDto);
        model.addAttribute("musicDto", musicDto);
        return "update";
    }

    @RequestMapping(value = "/confirm-update", method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute MusicDto musicDto, BindingResult bindingResult
            , RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "update";
        }
        Music music = new Music();
        BeanUtils.copyProperties(musicDto, music);
        musicService.update(music);
        redirectAttributes.addFlashAttribute("message", "Updated successfully !");
        return "redirect:/music";
    }
}
