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
package org.springframework.social.facebook.api.impl.json;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.social.facebook.api.Comment;
import org.springframework.social.facebook.api.Comments;

class CommentListDeserializer extends JsonDeserializer<Comments> {

	@SuppressWarnings("unchecked")
	@Override
	public Comments deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setDeserializationConfig(ctxt.getConfig());
		jp.setCodec(mapper);
		if(jp.hasCurrentToken()) {
			JsonNode commentsNode = jp.readValueAsTree();
			JsonNode dataNode = commentsNode.get("data");
			List<Comment> commentsList = dataNode != null ? 
					(List<Comment>) mapper.readValue(dataNode, new TypeReference<List<Comment>>() {}) : 
					Collections.<Comment>emptyList();
			JsonNode countNode = commentsNode.get("count");
			int commentCount = countNode != null ? countNode.getIntValue() : 0;
			return new Comments(commentsList, commentCount);
		}
		
		return null;
	}
}
