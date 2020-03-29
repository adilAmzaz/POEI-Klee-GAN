package poeiklee.RestaurantAmbulantBack.Models;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
public class Actuality implements Comparable<Actuality> {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int ActualityId;
	@Column(length=200)
	private String title;
	@Column(length=50)
	private String autor;
	@Column(length=250)
	private String catchParagraph;
	@Column(length=100)
	private String imageRelativePath;
	@Column(length=10000)
	private String content;
	private LocalDateTime publicationDate;
	
	public Actuality() {}
	public Actuality(String title, String autor, String catchParagraph, String imageRelativePath,
			String content, LocalDateTime publicationDate) {
		this.title = title;
		this.autor = autor;
		this.catchParagraph = catchParagraph;
		this.imageRelativePath = imageRelativePath;
		this.content = content;
		this.publicationDate = publicationDate;
	}
	public int getActualityId() {
		return ActualityId;
	}
	public void setActualityId(int actualityId) {
		ActualityId = actualityId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getCatchParagraph() {
		return catchParagraph;
	}
	public void setCatchParagraph(String catchParagraph) {
		this.catchParagraph = catchParagraph;
	}
	public String getImageRelativePath() {
		return imageRelativePath;
	}
	public void setImageRelativePath(String imageRelativePath) {
		this.imageRelativePath = imageRelativePath;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public LocalDateTime getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(LocalDateTime publicationDate) {
		this.publicationDate = publicationDate;
	}
	@Override
	public String toString() {
		return "Actuality [ActualityId=" + ActualityId + ", title=" + title + ", autor=" + autor + ", catchParagraph="
				+ catchParagraph + ", imageRelativePath=" + imageRelativePath + ", content=" + content + ", publicationDate="
				+ publicationDate + "]";
	}
	@Override
	public int compareTo(Actuality o) {
		return o.getPublicationDate().compareTo(this.getPublicationDate());
	}
}
