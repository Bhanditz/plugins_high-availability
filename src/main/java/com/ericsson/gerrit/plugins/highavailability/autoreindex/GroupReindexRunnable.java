// Copyright (C) 2018 The Android Open Source Project
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.ericsson.gerrit.plugins.highavailability.autoreindex;

import com.ericsson.gerrit.plugins.highavailability.forwarder.rest.AbstractIndexRestApiServlet;
import com.google.gerrit.common.data.GroupReference;
import com.google.gerrit.server.group.db.Groups;
import com.google.gerrit.server.util.OneOffRequestContext;
import com.google.inject.Inject;
import java.sql.Timestamp;
import java.util.Optional;

public class GroupReindexRunnable extends ReindexRunnable<GroupReference> {

  private final Groups groups;

  @Inject
  public GroupReindexRunnable(IndexTs indexTs, OneOffRequestContext ctx, Groups groups) {
    super(AbstractIndexRestApiServlet.IndexName.GROUP, indexTs, ctx);
    this.groups = groups;
  }

  @Override
  protected Iterable<GroupReference> fetchItems() throws Exception {
    return groups.getAllGroupReferences()::iterator;
  }

  @Override
  protected Optional<Timestamp> indexIfNeeded(GroupReference g, Timestamp sinceTs) {
    return Optional.empty();
  }
}
