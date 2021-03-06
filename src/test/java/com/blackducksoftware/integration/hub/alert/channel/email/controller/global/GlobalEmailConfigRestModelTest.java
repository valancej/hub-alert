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
package com.blackducksoftware.integration.hub.alert.channel.email.controller.global;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.blackducksoftware.integration.hub.alert.channel.email.mock.MockEmailGlobalRestModel;
import com.blackducksoftware.integration.hub.alert.web.model.GlobalRestModelTest;

public class GlobalEmailConfigRestModelTest extends GlobalRestModelTest<GlobalEmailConfigRestModel> {

    @Override
    public void assertGlobalRestModelFieldsNull(final GlobalEmailConfigRestModel restModel) {
        assertNull(restModel.getMailSmtpAllow8bitmime());
        assertNull(restModel.getMailSmtpAuth());
        assertNull(restModel.getMailSmtpConnectionTimeout());
        assertNull(restModel.getMailSmtpDnsNotify());
        assertNull(restModel.getMailSmtpDnsRet());
        assertNull(restModel.getMailSmtpEhlo());
        assertNull(restModel.getMailSmtpFrom());
        assertNull(restModel.getMailSmtpHost());
        assertNull(restModel.getMailSmtpLocalhost());
        assertNull(restModel.getMailSmtpPassword());
        assertNull(restModel.getMailSmtpPort());
        assertNull(restModel.getMailSmtpSendPartial());
        assertNull(restModel.getMailSmtpTimeout());
        assertNull(restModel.getMailSmtpUser());
        assertTrue(!restModel.isMailSmtpPasswordIsSet());
    }

    @Override
    public void assertGlobalRestModelFieldsFull(final GlobalEmailConfigRestModel restModel) {
        assertEquals(getMockUtil().getMailSmtpAllow8bitmime(), restModel.getMailSmtpAllow8bitmime());
        assertEquals(getMockUtil().getMailSmtpAuth(), restModel.getMailSmtpAuth());
        assertEquals(getMockUtil().getMailSmtpConnectionTimeout(), restModel.getMailSmtpConnectionTimeout());
        assertEquals(getMockUtil().getMailSmtpDnsNotify(), restModel.getMailSmtpDnsNotify());
        assertEquals(getMockUtil().getMailSmtpDnsRet(), restModel.getMailSmtpDnsRet());
        assertEquals(getMockUtil().getMailSmtpEhlo(), restModel.getMailSmtpEhlo());
        assertEquals(getMockUtil().getMailSmtpFrom(), restModel.getMailSmtpFrom());
        assertEquals(getMockUtil().getMailSmtpHost(), restModel.getMailSmtpHost());
        assertEquals(getMockUtil().getMailSmtpLocalhost(), restModel.getMailSmtpLocalhost());
        assertEquals(getMockUtil().getMailSmtpPassword(), restModel.getMailSmtpPassword());
        assertEquals(getMockUtil().getMailSmtpPort(), restModel.getMailSmtpPort());
        assertEquals(getMockUtil().getMailSmtpSendPartial(), restModel.getMailSmtpSendPartial());
        assertEquals(getMockUtil().getMailSmtpTimeout(), restModel.getMailSmtpTimeout());
        assertEquals(getMockUtil().getMailSmtpUser(), restModel.getMailSmtpUser());
        assertEquals(getMockUtil().isMailSmtpPasswordIsSet(), restModel.isMailSmtpPasswordIsSet());
    }

    @Override
    public Class<GlobalEmailConfigRestModel> getGlobalRestModelClass() {
        return GlobalEmailConfigRestModel.class;
    }

    @Override
    public MockEmailGlobalRestModel getMockUtil() {
        return new MockEmailGlobalRestModel();
    }

}
