package com.dzakdzaks.movies.data.remote.response.tvshow.detail;

import com.google.gson.annotations.SerializedName;

public class ProductionCompaniesItem{

	@SerializedName("logo_path")
	private Object logoPath;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	@SerializedName("origin_country")
	private String originCountry;

	public void setLogoPath(Object logoPath){
		this.logoPath = logoPath;
	}

	public Object getLogoPath(){
		return logoPath;
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

	public void setOriginCountry(String originCountry){
		this.originCountry = originCountry;
	}

	public String getOriginCountry(){
		return originCountry;
	}
}