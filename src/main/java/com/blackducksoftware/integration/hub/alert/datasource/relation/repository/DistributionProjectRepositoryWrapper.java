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
package com.blackducksoftware.integration.hub.alert.datasource.relation.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blackducksoftware.integration.hub.alert.datasource.AbstractRepositoryWrapper;
import com.blackducksoftware.integration.hub.alert.datasource.relation.DistributionProjectRelation;
import com.blackducksoftware.integration.hub.alert.datasource.relation.key.DistributionProjectRelationPK;

@Component
public class DistributionProjectRepositoryWrapper extends AbstractRepositoryWrapper<DistributionProjectRelation, DistributionProjectRelationPK, DistributionProjectRepository> {

    @Autowired
    public DistributionProjectRepositoryWrapper(final DistributionProjectRepository repository) {
        super(repository);
    }

    public List<DistributionProjectRelation> findByCommonDistributionConfigId(final Long commonDistributionConfigId) {
        return decryptSensitiveData(getRepository().findByCommonDistributionConfigId(commonDistributionConfigId));
    }

    public List<DistributionProjectRelation> findByProjectId(final Long projectId) {
        return decryptSensitiveData(getRepository().findByProjectId(projectId));
    }

    @Override
    public DistributionProjectRelation encryptSensitiveData(final DistributionProjectRelation entity) {
        return entity;
    }

    @Override
    public DistributionProjectRelation decryptSensitiveData(final DistributionProjectRelation entity) {
        return entity;
    }

}
