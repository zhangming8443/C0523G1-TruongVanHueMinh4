package com.example.music.repository;

import com.example.music.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMusicRepo extends JpaRepository<Music, Integer> {
}
