/*
 * Copyright 2010 the original author or authors.
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
package org.springframework.social.facebook.api.ads.impl.json;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @author Karthick Sankarachary
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class AdCreativeMixin {

	@JsonCreator
	AdCreativeMixin() {
	}

	@JsonProperty("object_id")
	int objectId;

	@JsonProperty("image_hash")
	String imageHash;

	@JsonProperty("image_url")
	String imageUrl;

	@JsonProperty("creative_id")
	int creativeId;

	@JsonProperty("count_current_adgroups")
	String countCurrentAdGroups;

	@JsonProperty("run_status")
	String runStatus;

	@JsonProperty("link_url")
	String linkUrl;

	@JsonProperty("preview_url")
	String previewUrl;

	@JsonProperty("related_fan_page")
	String relatedFanPage;

}
