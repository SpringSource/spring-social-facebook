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
package org.springframework.social.facebook.api.ads;


/**
 * The <code>AdGroupStats</code> extends the {@link Stats} class with a ad group
 * id field.
 * 
 * @author Karthick Sankarachary
 */
public class AdGroupStats extends Stats {
	private long adGroupId;

	public long getAdGroupId() {
		return adGroupId;
	}

	public void setAdGroupId(long adGroupId) {
		this.adGroupId = adGroupId;
	}
}
