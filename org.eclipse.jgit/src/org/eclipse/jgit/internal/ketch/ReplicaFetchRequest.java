/*
 * Copyright (C) 2016, Google Inc.
 * and other copyright owners as documented in the project's IP log.
 *
 * This program and the accompanying materials are made available
 * under the terms of the Eclipse Distribution License v1.0 which
 * accompanies this distribution, is reproduced below, and is
 * available at http://www.eclipse.org/org/documents/edl-v10.php
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or
 * without modification, are permitted provided that the following
 * conditions are met:
 *
 * - Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 *
 * - Redistributions in binary form must reproduce the above
 *   copyright notice, this list of conditions and the following
 *   disclaimer in the documentation and/or other materials provided
 *   with the distribution.
 *
 * - Neither the name of the Eclipse Foundation, Inc. nor the
 *   names of its contributors may be used to endorse or promote
 *   products derived from this software without specific prior
 *   written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND
 * CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES,
 * INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.eclipse.jgit.internal.ketch;

import java.util.Map;
import java.util.Set;

import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Ref;

/**
 * A fetch request to obtain objects from a replica, and its result.
 */
public class ReplicaFetchRequest {
	private final Set<String> wantRefs;
	private final Set<ObjectId> wantObjects;
	private Map<String, Ref> refs;

	/**
	 * Construct a new fetch request for a replica.
	 *
	 * @param wantRefs
	 *            named references to be fetched.
	 * @param wantObjects
	 *            specific objects to be fetched.
	 */
	public ReplicaFetchRequest(Set<String> wantRefs,
			Set<ObjectId> wantObjects) {
		this.wantRefs = wantRefs;
		this.wantObjects = wantObjects;
	}

	/**
	 * Get references to be fetched.
	 *
	 * @return references to be fetched.
	 */
	public Set<String> getWantRefs() {
		return wantRefs;
	}

	/**
	 * Get objects to be fetched.
	 *
	 * @return objects to be fetched.
	 */
	public Set<ObjectId> getWantObjects() {
		return wantObjects;
	}

	/**
	 * Get remote references, usually from the advertisement.
	 *
	 * @return remote references, usually from the advertisement.
	 */
	@Nullable
	public Map<String, Ref> getRefs() {
		return refs;
	}

	/**
	 * Set references observed from the replica.
	 *
	 * @param refs
	 *            references observed from the replica.
	 */
	public void setRefs(Map<String, Ref> refs) {
		this.refs = refs;
	}
}
