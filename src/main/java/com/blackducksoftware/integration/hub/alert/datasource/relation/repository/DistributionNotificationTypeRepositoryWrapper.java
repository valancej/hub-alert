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
import com.blackducksoftware.integration.hub.alert.datasource.relation.DistributionNotificationTypeRelation;
import com.blackducksoftware.integration.hub.alert.datasource.relation.key.DistributionNotificationTypeRelationPK;

@Component
public class DistributionNotificationTypeRepositoryWrapper extends AbstractRepositoryWrapper<DistributionNotificationTypeRelation, DistributionNotificationTypeRelationPK, DistributionNotificationTypeRepository> {

    @Autowired
    public DistributionNotificationTypeRepositoryWrapper(final DistributionNotificationTypeRepository repository) {
        super(repository);
    }

    public List<DistributionNotificationTypeRelation> findByCommonDistributionConfigId(final Long commonDistributionConfigId) {
        return decryptSensitiveData(getRepository().findByCommonDistributionConfigId(commonDistributionConfigId));
    }

    @Override
    public DistributionNotificationTypeRelation encryptSensitiveData(final DistributionNotificationTypeRelation entity) {
        return entity;
    }

    @Override
    public DistributionNotificationTypeRelation decryptSensitiveData(final DistributionNotificationTypeRelation entity) {
        return entity;
    }
}
