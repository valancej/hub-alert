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
package com.blackducksoftware.integration.hub.alert.hub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blackducksoftware.integration.hub.alert.web.controller.BaseController;

@RestController
@RequestMapping(BaseController.BASE_PATH + "/hub")
public class HubDataController extends BaseController {
    private final HubDataHandler hubDataHandler;

    @Autowired
    public HubDataController(final HubDataHandler hubDataHandler) {
        this.hubDataHandler = hubDataHandler;
    }

    @GetMapping(value = "/groups")
    public ResponseEntity<String> getGroups() {
        return hubDataHandler.getHubGroups();
    }

    @GetMapping(value = "/projects")
    public ResponseEntity<String> getProjects() {
        return hubDataHandler.getHubProjects();
    }

}
