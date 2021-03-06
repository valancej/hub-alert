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
package com.blackducksoftware.integration.hub.alert.channel.email.mock;

import com.blackducksoftware.integration.hub.alert.channel.email.controller.distribution.EmailGroupDistributionRestModel;
import com.blackducksoftware.integration.hub.alert.mock.model.MockCommonDistributionRestModel;
import com.blackducksoftware.integration.hub.alert.mock.model.MockRestModelUtil;
import com.google.gson.JsonObject;

public class MockEmailRestModel extends MockRestModelUtil<EmailGroupDistributionRestModel> {
    private final MockCommonDistributionRestModel distributionMockUtil = new MockCommonDistributionRestModel();

    private final String groupName;
    private final String id;
    private final String emailTemplateLogoImage;
    private final String emailSubjectLine;

    public MockEmailRestModel() {
        this("groupName", "1", "emailTemplateLogoImage", "emailSubjectLine");
    }

    private MockEmailRestModel(final String groupName, final String id, final String emailTemplateLogoImage, final String emailSubjectLine) {
        this.groupName = groupName;
        this.id = id;
        this.emailTemplateLogoImage = emailTemplateLogoImage;
        this.emailSubjectLine = emailSubjectLine;
    }

    public String getGroupName() {
        return groupName;
    }

    @Override
    public Long getId() {
        return Long.valueOf(id);
    }

    public String getEmailTemplateLogoImage() {
        return emailTemplateLogoImage;
    }

    public String getEmailSubjectLine() {
        return emailSubjectLine;
    }

    @Override
    public EmailGroupDistributionRestModel createRestModel() {
        final EmailGroupDistributionRestModel restModel = new EmailGroupDistributionRestModel(String.valueOf(distributionMockUtil.getId()), distributionMockUtil.getDistributionConfigId(), distributionMockUtil.getDistributionType(),
                distributionMockUtil.getName(), distributionMockUtil.getFrequency(), distributionMockUtil.getFilterByProject(), groupName, emailTemplateLogoImage, emailSubjectLine, distributionMockUtil.getProjects(),
                distributionMockUtil.getNotificationsAsStrings());
        return restModel;
    }

    @Override
    public EmailGroupDistributionRestModel createEmptyRestModel() {
        return new EmailGroupDistributionRestModel();
    }

    @Override
    public String getRestModelJson() {
        final JsonObject json = new JsonObject();
        json.addProperty("groupName", groupName);
        json.addProperty("emailTemplateLogoImage", emailTemplateLogoImage);
        json.addProperty("emailSubjectLine", emailSubjectLine);

        return distributionMockUtil.combineWithRestModelJson(json);
    }

}
