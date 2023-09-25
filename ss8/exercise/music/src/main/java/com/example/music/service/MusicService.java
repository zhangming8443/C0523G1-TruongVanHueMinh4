package com.example.music.service;

import com.example.music.model.Music;
import com.example.music.repository.IMusicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService implements IMusicService{
    @Autowired
    private IMusicRepo musicRepo;

    @Override
    public List<Music> findAll() {
        return musicRepo.findAll();
    }

    @Override
    public boolean add(Music music) {
        Music newMusic = musicRepo.save(music);
        return newMusic != null;
    }

    @Override
    public boolean update(Music music) {
        Music updateMusic = musicRepo.save(music);
        return updateMusic != null;
    }

    @Override
    public Music findById(int id) {
        Music music = musicRepo.findById(id).get();
        return music;
    }
}
