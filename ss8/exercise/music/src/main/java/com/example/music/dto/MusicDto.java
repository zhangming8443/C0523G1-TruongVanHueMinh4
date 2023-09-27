package com.example.music.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class MusicDto {
    private int idSong;
    @NotEmpty(message = "Please do not leave it blank")
    @Size(max = 800, message = "Song name must not exceed 800 characters")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Song name cannot contain special characters")
    private String nameSong;
    @NotEmpty
    @Size(max = 300, message = "Performer name must not exceed 300 characters")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Performer name cannot contain special characters")
    private String performer;
    @NotEmpty
    @Size(max = 1000, message =  "Type music must not exceed 1000 characters")
    @Pattern(regexp = "^[\\w+[\\s\\,]*]+$", message = "Invalid type music")
    private String typeMusic;

    public MusicDto() {
    }

    public MusicDto(int idSong, String nameSong, String performer, String typeMusic) {
        this.idSong = idSong;
        this.nameSong = nameSong;
        this.performer = performer;
        this.typeMusic = typeMusic;
    }

    public int getIdSong() {
        return idSong;
    }

    public void setIdSong(int idSong) {
        this.idSong = idSong;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public String getTypeMusic() {
        return typeMusic;
    }

    public void setTypeMusic(String typeMusic) {
        this.typeMusic = typeMusic;
    }
}
