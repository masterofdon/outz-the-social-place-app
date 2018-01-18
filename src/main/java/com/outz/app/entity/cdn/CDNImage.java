package com.outz.app.entity.cdn;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="outz_cdn_image")
public class CDNImage extends CDNItem {
	
	private int origwidth;
	
	private int origheight;
	
	private int currentwidth;
	
	private int currentheight;

	public int getOrigwidth() {
		return origwidth;
	}

	public void setOrigwidth(int origwidth) {
		this.origwidth = origwidth;
	}

	public int getOrigheight() {
		return origheight;
	}

	public void setOrigheight(int origheight) {
		this.origheight = origheight;
	}

	public int getCurrentwidth() {
		return currentwidth;
	}

	public void setCurrentwidth(int currentwidth) {
		this.currentwidth = currentwidth;
	}

	public int getCurrentheight() {
		return currentheight;
	}

	public void setCurrentheight(int currentheight) {
		this.currentheight = currentheight;
	}
}
