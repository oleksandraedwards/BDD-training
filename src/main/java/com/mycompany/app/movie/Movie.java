package com.mycompany.app.movie;

import java.util.Date;
 
public class Movie {
	private final String title;
	private final String producer;
	private final Date releaseDate;

	public Movie(final String title, final String producer, final Date releaseDate) {
		this.title = title;
		this.producer = producer;
		this.releaseDate = releaseDate;
	}

	public String getTitle() {
		return title;
	}

	public String getProducer() {
		return producer;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Movie [title=").append(title).append(", producer=").append(producer).append(", published=").append(releaseDate).append("]");
		return builder.toString();
	}
}