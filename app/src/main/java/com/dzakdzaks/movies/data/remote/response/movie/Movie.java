package com.dzakdzaks.movies.data.remote.response.movie;

import com.google.gson.annotations.SerializedName;

public class Movie {

	@SerializedName("overview")
	private String overview;

	@SerializedName("original_language")
	private String originalLanguage;

	@SerializedName("original_title")
	private String originalTitle;

	@SerializedName("title")
	private String title;

	@SerializedName("poster_path")
	private String posterPath;

	@SerializedName("backdrop_path")
	private String backdropPath;

	@SerializedName("release_date")
	private String releaseDate;

	@SerializedName("vote_average")
	private double voteAverage;

	@SerializedName("id")
	private int id;

	public Movie(int movieId, String movieTitle, String movieOriginalTitle, String movieCountry, String movieOverview, String movieReleaseDate, String movieImage, String movieBackground, double movieVote) {
		this.id = movieId;
		this.title = movieTitle;
		this.originalTitle = movieOriginalTitle;
		this.originalLanguage = movieCountry;
		this.overview = movieOverview;
		this.releaseDate = movieReleaseDate;
		this.posterPath = movieImage;
		this.backdropPath = movieBackground;
		this.voteAverage = movieVote;
	}

	public void setOverview(String overview){
		this.overview = overview;
	}

	public String getOverview(){
		return overview;
	}

	public void setOriginalLanguage(String originalLanguage){
		this.originalLanguage = originalLanguage;
	}

	public String getOriginalLanguage(){
		return originalLanguage;
	}

	public void setOriginalTitle(String originalTitle){
		this.originalTitle = originalTitle;
	}

	public String getOriginalTitle(){
		return originalTitle;
	}


	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}


	public void setPosterPath(String posterPath){
		this.posterPath = posterPath;
	}

	public String getPosterPath(){
		return posterPath;
	}

	public void setBackdropPath(String backdropPath){
		this.backdropPath = backdropPath;
	}

	public String getBackdropPath(){
		return backdropPath;
	}

	public void setReleaseDate(String releaseDate){
		this.releaseDate = releaseDate;
	}

	public String getReleaseDate(){
		return releaseDate;
	}

	public void setVoteAverage(double voteAverage){
		this.voteAverage = voteAverage;
	}

	public double getVoteAverage(){
		return voteAverage;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	}