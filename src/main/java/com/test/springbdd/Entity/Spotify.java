package com.test.springbdd.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name="spotifysongs")
public class Spotify {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)		
	@Column(name="id")
	private int id;
	
	@Column(name="song")
	private String song;
	
	@Column(name="music")
	private String music;
	
	@Column(name="verdict")
	private String verdict;

	public Spotify() {
		super();
	
	}

	public Spotify(String song, String music, String verdict) {
		super();
		this.song = song;
		this.music = music;
		this.verdict = verdict;
	}

	public int getId() {
		return id;
	}

	public String getsong() {
		return song;
	}

	public String getmusic() {
		return music;
	}

	public String getVerdict() {
		return verdict;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setsong(String song) {
		this.song = song;
	}

	public void setmusic(String music) {
		this.music = music;
	}

	public void setVerdict(String verdict) {
		this.verdict = verdict;
	}

	@Override
	public String toString() {
		return "Spotify [id=" + id + ", song=" + song + ", music=" + music + ", verdict="
				+ verdict + "]";
	}
	
	
	
	
}
