/**
 * Copyright (C) 2017 Black Duck Software, Inc.
 * http://www.blackducksoftware.com/
 *
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
package com.blackducksoftware.integration.hub.alert.web.model.distribution;

import java.util.List;

import org.apache.commons.lang3.builder.RecursiveToStringStyle;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.blackducksoftware.integration.hub.alert.web.model.ConfigRestModel;

public class CommonDistributionConfigRestModel extends ConfigRestModel {
    private static final long serialVersionUID = -4723009315760610084L;

    private String distributionConfigId;
    private String distributionType;
    private String name;
    private String frequency;
    private String notificationType;
    private String filterByProject;
    private List<String> configuredProjects;

    public CommonDistributionConfigRestModel() {
    }

    public CommonDistributionConfigRestModel(final String id, final String distributionConfigId, final String distributionType, final String name, final String frequency, final String notificationType, final String filterByProject,
            final List<String> configuredProjects) {
        super(id);
        this.distributionConfigId = distributionConfigId;
        this.distributionType = distributionType;
        this.name = name;
        this.frequency = frequency;
        this.notificationType = notificationType;
        this.filterByProject = filterByProject;
        this.configuredProjects = configuredProjects;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getDistributionConfigId() {
        return distributionConfigId;
    }

    public void setDistributionConfigId(final String distributionConfigId) {
        this.distributionConfigId = distributionConfigId;
    }

    public String getDistributionType() {
        return distributionType;
    }

    public String getName() {
        return name;
    }

    public String getFrequency() {
        return frequency;
    }

    public String getNotificationType() {
        return notificationType;
    }

    public String getFilterByProject() {
        return filterByProject;
    }

    public List<String> getConfiguredProjects() {
        return configuredProjects;
    }

    public void setConfiguredProjects(final List<String> configuredProjects) {
        this.configuredProjects = configuredProjects;
    }

    @Override
    public String toString() {
        String[] configuredProjectsToStringArray = null;
        if (configuredProjects != null) {
            configuredProjectsToStringArray = configuredProjects.toArray(new String[configuredProjects.size()]);
        }

        final ReflectionToStringBuilder reflectionToStringBuilder = new ReflectionToStringBuilder(this, RecursiveToStringStyle.JSON_STYLE);
        reflectionToStringBuilder.setExcludeFieldNames("configuredProjects");
        reflectionToStringBuilder.append("configuredProjects", configuredProjectsToStringArray);
        return reflectionToStringBuilder.build();
    }

}
