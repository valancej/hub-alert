/*
 * Copyright (C) 2017 Black Duck Software Inc.
 * http://www.blackducksoftware.com/
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Black Duck Software ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Black Duck Software.
 */
package com.blackducksoftware.integration.hub.alert.channel.slack.controller.distribution;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.Mockito;

import com.blackducksoftware.integration.hub.alert.channel.slack.SlackManager;

public class SlackDistributionConfigActionsTest {
    @Test
    public void testTestConfig() throws Exception {
        final SlackManager slackManager = Mockito.mock(SlackManager.class);
        final SlackDistributionConfigActions configActions = new SlackDistributionConfigActions(null, null, null, null, null, slackManager);

        configActions.testConfig(null);
        verify(slackManager, times(1)).sendTestMessage(Mockito.any());
        Mockito.reset(slackManager);

        configActions.testConfig(null);
        verify(slackManager, times(1)).sendTestMessage(Mockito.any());
    }

}
