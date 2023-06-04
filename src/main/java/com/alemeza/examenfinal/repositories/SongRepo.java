package com.alemeza.examenfinal.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.alemeza.examenfinal.models.Song;

public interface SongRepo extends CrudRepository<Song, Long> {
	//Este método recupera todos los song de la base de datos
	List<Song> findAll();
}
