package com.alemeza.examenfinal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alemeza.examenfinal.models.Song;
import com.alemeza.examenfinal.repositories.SongRepo;

@Service
public class SongServ {

	@Autowired
	private SongRepo songrepo;

	// lee todas las canciones

	public List<Song> allSongs() {
		return songrepo.findAll();
	}
	// crea song

	public Song crearSongs(Song song) {
		return songrepo.save(song);
	}

	public Song findSongById(Long idSong) {
		return songrepo.findById(idSong).orElse(null);

	}

	public void updateSong(Song song) {

		Song cancionExistente = songrepo.findById(song.getId()).orElse(null);
		System.out.println(cancionExistente);

		if (cancionExistente != null) {
			// Incrementar el campo 'colaborador' en 1
			int nuevoColaborador = cancionExistente.getColaborador() + 1;
			cancionExistente.setColaborador(nuevoColaborador);

			songrepo.save(cancionExistente);

		}
	}

	public void deleteSong(Long id) {
		songrepo.deleteById(id);

	}

}
