/**
 * hub-alert
 *
 * Copyright (C) 2018 Black Duck Software, Inc.
 * http://www.blackducksoftware.com/
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.blackducksoftware.integration.hub.alert.digest.model;

import java.util.LinkedList;
import java.util.List;

public class CategoryDataBuilder {
    private String categoryKey;

    private final List<ItemData> itemList;

    public CategoryDataBuilder() {
        this.itemList = new LinkedList<>();
    }

    public void addItem(final ItemData item) {
        itemList.add(item);
    }

    public void removeItem(final ItemData item) {
        itemList.remove(item);
    }

    public String getCategoryKey() {
        return categoryKey;
    }

    public void setCategoryKey(final String categoryKey) {
        this.categoryKey = categoryKey;
    }

    public List<ItemData> getItemList() {
        return itemList;
    }

    public CategoryData build() {
        return new CategoryData(categoryKey, itemList, itemList.size());
    }
}
