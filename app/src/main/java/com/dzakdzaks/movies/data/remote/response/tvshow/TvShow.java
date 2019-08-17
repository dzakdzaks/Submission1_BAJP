package com.dzakdzaks.movies.data.remote.response.tvshow;

import com.google.gson.annotations.SerializedName;

public class TvShow {

	@SerializedName("id")
	private int id;

	@SerializedName("name")
	private String name;

	@SerializedName("original_name")
	private String originalName;

	@SerializedName("original_language")
	private String originalLanguage;

	@SerializedName("overview")
	private String overview;

	@SerializedName("first_air_date")
	private String firstAirDate;

	@SerializedName("poster_path")
	private String posterPath;

	@SerializedName("backdrop_path")
	private String backdropPath;

	@SerializedName("vote_average")
	private double voteAverage;


	public TvShow(int id, String name, String originalName, String originalLanguage, String overview, String firstAirDate, String posterPath, String backdropPath, double voteAverage) {
		this.id = id;
		this.name = name;
		this.originalName = originalName;
		this.originalLanguage = originalLanguage;
		this.overview = overview;
		this.firstAirDate = firstAirDate;
		this.posterPath = posterPath;
		this.backdropPath = backdropPath;
		this.voteAverage = voteAverage;
	}

	public void setFirstAirDate(String firstAirDate){
		this.firstAirDate = firstAirDate;
	}

	public String getFirstAirDate(){
		return firstAirDate;
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

	public void setOriginalName(String originalName){
		this.originalName = originalName;
	}

	public String getOriginalName(){
		return originalName;
	}


	public void setVoteAverage(double voteAverage){
		this.voteAverage = voteAverage;
	}

	public double getVoteAverage(){
		return voteAverage;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

}