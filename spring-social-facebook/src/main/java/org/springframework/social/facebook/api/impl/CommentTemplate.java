/*
 * Copyright 2013 the original author or authors.
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
package org.springframework.social.facebook.api.impl;

import static org.springframework.social.facebook.api.impl.PagedListUtils.*;

import org.springframework.social.facebook.api.Comment;
import org.springframework.social.facebook.api.CommentOperations;
import org.springframework.social.facebook.api.GraphApi;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.PagedListParameters;
import org.springframework.social.facebook.api.Reference;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

class CommentTemplate extends AbstractFacebookOperations implements CommentOperations {

	private final GraphApi graphApi;

	public CommentTemplate(GraphApi graphApi, boolean isAuthorizedForUser) {
		super(isAuthorizedForUser);
		this.graphApi = graphApi;
	}

	public PagedList<Comment> getComments(String objectId) {
		return getComments(objectId, 0, 25);
	}

	public PagedList<Comment> getComments(String objectId, int offset, int limit) {
		return getComments(objectId, new PagedListParameters(limit, offset, null, null));
	}

	public PagedList<Comment> getComments(String objectId, PagedListParameters pagedListParameters) {
		return graphApi.fetchConnections(objectId, "comments", Comment.class, getPagingParameters(pagedListParameters));
	}

	public Comment getComment(String commentId) {
		return graphApi.fetchObject(commentId, Comment.class);
	}

	public String addComment(String objectId, String message) {
		requireAuthorization();
		MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
		map.set("message", message);
		return graphApi.publish(objectId, "comments", map);
	}

	public void deleteComment(String objectId) {
		requireAuthorization();
		graphApi.delete(objectId);
	}

	public PagedList<Reference> getLikes(String objectId) {
		return graphApi.fetchConnections(objectId, "likes", Reference.class);
	}

}
