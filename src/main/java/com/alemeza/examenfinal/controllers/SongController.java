package com.alemeza.examenfinal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.alemeza.examenfinal.models.Song;
import com.alemeza.examenfinal.models.User;
import com.alemeza.examenfinal.services.SongServ;
import com.alemeza.examenfinal.services.UserServices;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class SongController {

	@Autowired
	private SongServ songServices;
	@Autowired
	private UserServices userService;

	// lista canciones
	@GetMapping("/home")
	public String Home(Model viewModel, HttpSession sesion) {
		// Validar si el usuario tiene la sesion activa
		Long userId = (Long) sesion.getAttribute("userID");
		if (userId == null) {
			return "redirect:/";
		}
		User usuarioLog = userService.findUserById(userId);

		viewModel.addAttribute("usuario", usuarioLog);

		List<Song> songs = songServices.allSongs();
		viewModel.addAttribute("songall", songs);

		return "home.jsp";
	}

	// abre crea canciones
	@GetMapping("/songs/new")
	public String formularioNuevoSong(@ModelAttribute("songnew") Song songnew, HttpSession sesion, Model viewModel) {
		Long userId = (Long) sesion.getAttribute("userID");
		if (userId == null) {
			return "redirect:/";
		}

		User usuarioLog = userService.findUserById(userId);

		viewModel.addAttribute("usuario", usuarioLog);
		return "newsongs.jsp";
	}

	@PostMapping("/songs/new")
	public String crearSong(@Valid @ModelAttribute("songnew") Song songnew, BindingResult resultado, HttpSession sesion,
			Model viewModel) {
		Long userId = (Long) sesion.getAttribute("userID");
		if (userId == null) {
			return "redirect:/";
		}
		User usuarioLog = userService.findUserById(userId);
		if (resultado.hasErrors()) {
			viewModel.addAttribute("usuario", usuarioLog);
			return "newsongs.jsp";
		}
		songServices.crearSongs(songnew);
		return "redirect:/home";
	}

	// mostrar por id
	@GetMapping("/songs/{idSong}")
	public String mostrarSongs(Model viewModel, HttpSession sesion, @PathVariable("idSong") Long idSong) {
		Long userId = (Long) sesion.getAttribute("userID");
		if (userId == null) {
			return "redirect:/";
		}
		Song song = songServices.findSongById(idSong);
		viewModel.addAttribute("songid", song);
		return "mostrarid.jsp";
	}

	// editar mostrar

	@GetMapping("/songs/{idSong}/editar")
	public String formularioEditSong(@ModelAttribute("song") Song song, HttpSession sesion, Model viewModel,
			@PathVariable("idSong") Long idSong) {
		Long userId = (Long) sesion.getAttribute("userID");
		if (userId == null) {
			return "redirect:/";
		}
		Song songEditar = songServices.findSongById(idSong);
		User usuarioLog = userService.findUserById(userId);

		viewModel.addAttribute("usuario", usuarioLog);
		viewModel.addAttribute("songs", songEditar);
		return "editar.jsp";
	}

	// editar
	@PutMapping("/songs/{idSong}/editar")
	public String guardarEdit(@Valid @ModelAttribute("songs") Song song, BindingResult result,
			@PathVariable("idSong") Long idSong, HttpSession sesion, Model viewModel) {
		Long userId = (Long) sesion.getAttribute("userID");
		if (userId == null) {
			return "redirect:/";
		}
		Song songs = songServices.findSongById(idSong);
		if (result.hasErrors()) {
			if (songs == null) {
				return "redirect:/home";
			}
			viewModel.addAttribute("usuario", userService.findUserById(userId));
			return "editar.jsp";
		}

		songs.setTitulo(song.getTitulo());
		songs.setGenero(song.getGenero());
		songs.setLetracancion(song.getLetracancion());
		// songs.setColaborador(song.getColaborador());

		songServices.updateSong(songs);

		return "redirect:/home";
	}

	// RUTA PARA BORRAR CANCIONES
	@GetMapping("/songs/{id}/delete")
	public String deleteSong(@PathVariable("id") Long id, HttpSession sesion) {
		Long userLog = (Long) sesion.getAttribute("userID");
		if (userLog == null) {
			return "redirect:/";
		}

		songServices.deleteSong(id);
		return "redirect:/home";

	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("userID", null);
		return "redirect:/";
	}
}
