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
package com.blackducksoftware.integration.hub.alert.datasource.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.RecursiveToStringStyle;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@Entity
@Table(name = "global_config")
public class GlobalConfigEntity extends DatabaseEntity {
    private static final long serialVersionUID = 9172607945030111585L;

    @Column(name = "hub_timeout")
    private Integer hubTimeout;

    @Column(name = "hub_username")
    private String hubUsername;

    @Column(name = "hub_password")
    private String hubPassword;

    @Column(name = "alert_accumulator_cron")
    private String accumulatorCron;

    @Column(name = "alert_digest_daily_cron")
    private String dailyDigestCron;

    @Column(name = "alert_purge_data_cron")
    private String purgeDataCron;

    public GlobalConfigEntity() {
    }

    public GlobalConfigEntity(final Integer hubTimeout, final String hubUsername, final String hubPassword, final String accumulatorCron, final String dailyDigestCron, final String purgeDataCron) {
        this.hubTimeout = hubTimeout;
        this.hubUsername = hubUsername;
        this.hubPassword = hubPassword;
        this.accumulatorCron = accumulatorCron;
        this.dailyDigestCron = dailyDigestCron;
        this.purgeDataCron = purgeDataCron;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Integer getHubTimeout() {
        return hubTimeout;
    }

    public String getHubUsername() {
        return hubUsername;
    }

    public String getHubPassword() {
        return hubPassword;
    }

    public String getAccumulatorCron() {
        return accumulatorCron;
    }

    public String getDailyDigestCron() {
        return dailyDigestCron;
    }

    public String getPurgeDataCron() {
        return purgeDataCron;
    }

    @Override
    public String toString() {
        final ReflectionToStringBuilder reflectionToStringBuilder = new ReflectionToStringBuilder(this, RecursiveToStringStyle.JSON_STYLE);
        reflectionToStringBuilder.setExcludeFieldNames("hubPassword");
        return reflectionToStringBuilder.build();
    }

}