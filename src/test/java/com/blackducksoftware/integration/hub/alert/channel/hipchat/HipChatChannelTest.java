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
package com.blackducksoftware.integration.hub.alert.channel.hipchat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

import com.blackducksoftware.integration.exception.IntegrationException;
import com.blackducksoftware.integration.hub.alert.TestGlobalProperties;
import com.blackducksoftware.integration.hub.alert.TestPropertyKey;
import com.blackducksoftware.integration.hub.alert.audit.repository.AuditEntryRepositoryWrapper;
import com.blackducksoftware.integration.hub.alert.channel.ChannelTest;
import com.blackducksoftware.integration.hub.alert.channel.hipchat.mock.MockHipChatGlobalEntity;
import com.blackducksoftware.integration.hub.alert.channel.hipchat.repository.distribution.HipChatDistributionConfigEntity;
import com.blackducksoftware.integration.hub.alert.channel.hipchat.repository.global.GlobalHipChatConfigEntity;
import com.blackducksoftware.integration.hub.alert.channel.rest.ChannelRequestHelper;
import com.blackducksoftware.integration.hub.alert.channel.rest.ChannelRestConnectionFactory;
import com.blackducksoftware.integration.hub.alert.datasource.entity.repository.global.GlobalHubRepositoryWrapper;
import com.blackducksoftware.integration.hub.alert.digest.model.ProjectData;
import com.blackducksoftware.integration.hub.rest.RestConnection;
import com.blackducksoftware.integration.hub.rest.UnauthenticatedRestConnection;
import com.blackducksoftware.integration.log.LogLevel;
import com.blackducksoftware.integration.log.PrintStreamIntLogger;
import com.blackducksoftware.integration.test.annotation.ExternalConnectionTest;

public class HipChatChannelTest extends ChannelTest {
    final MockHipChatGlobalEntity hipChatMockUtil = new MockHipChatGlobalEntity();

    @Test
    @Category(ExternalConnectionTest.class)
    public void sendMessageTestIT() throws IOException, IntegrationException {
        final AuditEntryRepositoryWrapper auditEntryRepository = Mockito.mock(AuditEntryRepositoryWrapper.class);
        final GlobalHubRepositoryWrapper mockedGlobalRepository = Mockito.mock(GlobalHubRepositoryWrapper.class);
        final TestGlobalProperties globalProperties = new TestGlobalProperties(mockedGlobalRepository, null);
        final ChannelRestConnectionFactory channelRestConnectionFactory = new ChannelRestConnectionFactory(globalProperties);
        HipChatChannel hipChatChannel = new HipChatChannel(gson, auditEntryRepository, null, null, null, channelRestConnectionFactory);

        final ProjectData data = createProjectData("Integration test project");
        final HipChatEvent event = new HipChatEvent(data, null);
        final int roomId = Integer.parseInt(properties.getProperty(TestPropertyKey.TEST_HIPCHAT_ROOM_ID));
        final boolean notify = false;
        final String color = "random";
        final HipChatDistributionConfigEntity config = new HipChatDistributionConfigEntity(roomId, notify, color);

        hipChatChannel = Mockito.spy(hipChatChannel);
        Mockito.doReturn(new GlobalHipChatConfigEntity(properties.getProperty(TestPropertyKey.TEST_HIPCHAT_API_KEY))).when(hipChatChannel).getGlobalConfigEntity();

        hipChatChannel.sendAuditedMessage(event, config);

        final boolean responseLine = outputLogger.isLineContainingText("Successfully sent a hipchat_channel message!");

        assertTrue(responseLine);
    }

    public void createRequestThrowsExceptionWhenRoomIdIsNullTest() {
        final HipChatChannel hipChatChannel = new HipChatChannel(null, null, null, null, null, null);

        IntegrationException intException = null;
        try {
            hipChatChannel.createRequest(null, new HipChatDistributionConfigEntity(null, null, null), null);
        } catch (final IntegrationException e) {
            intException = e;
        }
        assertNotNull(intException);
    }

    @Test
    public void createRequestThrowsExceptionTest() throws Exception {
        final AuditEntryRepositoryWrapper auditEntryRepository = Mockito.mock(AuditEntryRepositoryWrapper.class);
        final HipChatChannel hipChatChannel = new HipChatChannel(gson, auditEntryRepository, null, null, null, null);

        final ChannelRequestHelper channelRequestHelper = new ChannelRequestHelper(null);
        final HipChatDistributionConfigEntity config = new HipChatDistributionConfigEntity(12345, Boolean.FALSE, null);
        final ProjectData projectData = createProjectData("HipChat IT test");

        final String userDir = System.getProperties().getProperty("user.dir");
        try {
            System.getProperties().setProperty("user.dir", "garbage");
            RuntimeException thrownException = null;
            try {
                hipChatChannel.createRequest(channelRequestHelper, config, projectData);
            } catch (final RuntimeException e) {
                thrownException = e;
            }
            assertNotNull(thrownException);
        } finally {
            System.getProperties().setProperty("user.dir", userDir);
        }
    }

    @Test
    public void testGlobalConfigNullTest() {
        final ChannelRestConnectionFactory restFactory = Mockito.mock(ChannelRestConnectionFactory.class);
        final HipChatChannel hipChatChannel = new HipChatChannel(null, null, null, null, null, restFactory);

        Mockito.when(restFactory.createUnauthenticatedRestConnection(Mockito.anyString())).thenReturn(null);

        final GlobalHipChatConfigEntity entity = hipChatMockUtil.createEmptyGlobalEntity();
        final String restConnectionNullMessage = hipChatChannel.testGlobalConfig(entity);
        assertEquals("Connection error: see logs for more information.", restConnectionNullMessage);

        final String nullEntityMessage = hipChatChannel.testGlobalConfig(null);
        assertEquals("The provided entity was null.", nullEntityMessage);
    }

    @Test
    public void testGlobalConfigValidApiKeyTest() {
        final TestGlobalProperties globalProperties = new TestGlobalProperties();
        globalProperties.setHubTrustCertificate(Boolean.TRUE);

        final ChannelRestConnectionFactory restFactory = new ChannelRestConnectionFactory(globalProperties);
        final HipChatChannel hipChatChannel = new HipChatChannel(null, null, null, null, null, restFactory);

        hipChatMockUtil.setApiKey(properties.getProperty(TestPropertyKey.TEST_HIPCHAT_API_KEY));
        final GlobalHipChatConfigEntity entity = hipChatMockUtil.createGlobalEntity();
        final String validMessage = hipChatChannel.testGlobalConfig(entity);
        assertEquals("API key is valid.", validMessage);
    }

    @Test
    public void testGlobalConfigInvalidApiKeyTest() {
        final TestGlobalProperties globalProperties = new TestGlobalProperties();
        globalProperties.setHubTrustCertificate(Boolean.TRUE);

        final ChannelRestConnectionFactory restFactory = new ChannelRestConnectionFactory(globalProperties);
        final HipChatChannel hipChatChannel = new HipChatChannel(null, null, null, null, null, restFactory);

        hipChatMockUtil.setApiKey("garbage");
        final GlobalHipChatConfigEntity entity = hipChatMockUtil.createGlobalEntity();
        final String invalidMessage = hipChatChannel.testGlobalConfig(entity);
        assertTrue(invalidMessage.contains("Invalid API key: "));
    }

    @Test
    public void testGlobalConfigThrowsExceptionTest() throws IntegrationException, MalformedURLException {
        final ChannelRestConnectionFactory restFactory = Mockito.mock(ChannelRestConnectionFactory.class);
        final HipChatChannel hipChatChannel = new HipChatChannel(null, null, null, null, null, restFactory);

        RestConnection restConnection = new UnauthenticatedRestConnection(new PrintStreamIntLogger(System.out, LogLevel.INFO), new URL("http://google.com"), 100, null);
        restConnection = Mockito.spy(restConnection);
        Mockito.doThrow(new IntegrationException("Mock exception")).when(restConnection).createResponse(Mockito.any());
        Mockito.when(restFactory.createUnauthenticatedRestConnection(Mockito.anyString())).thenReturn(restConnection);

        final GlobalHipChatConfigEntity entity = hipChatMockUtil.createEmptyGlobalEntity();
        final String connectionErrorMessage = hipChatChannel.testGlobalConfig(entity);
        assertEquals("Mock exception", connectionErrorMessage);
    }

}
