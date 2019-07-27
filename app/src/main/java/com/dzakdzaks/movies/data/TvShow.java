package com.dzakdzaks.movies.data;

public class TvShow {
    private String tvShowId;
    private String tvShowTitle;
    private String tvShowOriginalTitle;
    private String tvShowCountry;
    private String tvShowOverview;
    private String tvShowReleaseDate;
    private String tvShowImage;
    private double tvShowVote;

    public TvShow(String tvShowId, String tvShowTitle, String tvShowOriginalTitle, String tvShowCountry, String tvShowOverview, String tvShowReleaseDate, String tvShowImage, double tvShowVote) {
        this.tvShowId = tvShowId;
        this.tvShowTitle = tvShowTitle;
        this.tvShowOriginalTitle = tvShowOriginalTitle;
        this.tvShowCountry = tvShowCountry;
        this.tvShowOverview = tvShowOverview;
        this.tvShowReleaseDate = tvShowReleaseDate;
        this.tvShowImage = tvShowImage;
        this.tvShowVote = tvShowVote;
    }

    public String getTvShowId() {
        return tvShowId;
    }

    public void setTvShowId(String tvShowId) {
        this.tvShowId = tvShowId;
    }

    public String getTvShowTitle() {
        return tvShowTitle;
    }

    public void setTvShowTitle(String tvShowTitle) {
        this.tvShowTitle = tvShowTitle;
    }

    public String getTvShowOriginalTitle() {
        return tvShowOriginalTitle;
    }

    public void setTvShowOriginalTitle(String tvShowOriginalTitle) {
        this.tvShowOriginalTitle = tvShowOriginalTitle;
    }

    public String getTvShowCountry() {
        return tvShowCountry;
    }

    public void setTvShowCountry(String tvShowCountry) {
        this.tvShowCountry = tvShowCountry;
    }

    public String getTvShowOverview() {
        return tvShowOverview;
    }

    public void setTvShowOverview(String tvShowOverview) {
        this.tvShowOverview = tvShowOverview;
    }

    public String getTvShowReleaseDate() {
        return tvShowReleaseDate;
    }

    public void setTvShowReleaseDate(String tvShowReleaseDate) {
        this.tvShowReleaseDate = tvShowReleaseDate;
    }

    public String getTvShowImage() {
        return tvShowImage;
    }

    public void setTvShowImage(String tvShowImage) {
        this.tvShowImage = tvShowImage;
    }

    public double getTvShowVote() {
        return tvShowVote;
    }

    public void setTvShowVote(double tvShowVote) {
        this.tvShowVote = tvShowVote;
    }
}
