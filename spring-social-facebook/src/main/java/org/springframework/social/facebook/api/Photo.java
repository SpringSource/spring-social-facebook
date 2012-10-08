/*
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.facebook.api;

import java.util.Date;
import java.util.List;


/**
 * Model class representing a photo.
 * @author Craig Walls
 */
public class Photo {
	private String id;
	
	private String name;
	
	private Reference from;
	
	private String link;
	
	private String icon;
	
	private int position;
	
	private Date createdTime;
	
	private Date updatedTime;
	
	private List<Tag> tags;
	
	private List<Image> images;
	
	private Image oversizedImage;
	
	private Photo(String id, Reference from, String link, String icon, Date createdTime, List<Image> images) {
		this.id = id;
		this.from = from;
		this.link = link;
		this.icon = icon;
		this.createdTime = createdTime;
		this.images = images;
		
		int i=0;
		if(images.size() == 5) {
			this.oversizedImage = images.get(i++);
		}
		this.sourceImage = images.get(i++);
		this.albumImage = images.get(i++);
		this.smallImage = images.get(i++);
		this.tinyImage = images.get(i++);
	}
	
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Reference getFrom() {
		return from;
	}

	public String getLink() {
		return link;
	}

	public String getIcon() {
		return icon;
	}

	/**
	 * The position of the photo in a list of photos.
	 * @deprecated On September 5, 2012, Facebook will either stop returning a position property on Photo objects or will only return 0. This method will be removed in Spring Social Facebook 1.1.0.
	 */
	@Deprecated
	public Integer getPosition() {
		return position;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}
	
	public List<Image> getImages() {
		return images;
	}

	public Image getOversizedImage() {
		return images.get(0);
	}
	
	public Image getSourceImage() {
		return images.get(1);
	}
	
	public Image getSmallImage() {
		return images.get(6);
	}
	
	public Image getAlbumImage() {
		return images.get(5);
	}
	
	public Image getTinyImage() {
		return images.get(7);
	}
	
	public List<Tag> getTags() {
		return tags;
	}
	
	public static class Image {
		
		private final int width;
		
		private final int height;
		
		private final String source;
		
		public Image(String source, int width, int height) {
			this.source = source;
			this.width = width;
			this.height = height;
			
		}

		public int getWidth() {
			return width;
		}

		public int getHeight() {
			return height;
		}

		public String getSource() {
			return source;
		}
	}

}
