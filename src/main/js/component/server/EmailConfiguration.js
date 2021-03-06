'use strict';
import React from 'react';
import PropTypes from 'prop-types';
import CheckboxInput from '../../field/input/CheckboxInput';
import NumberInput from '../../field/input/NumberInput';
import PasswordInput from '../../field/input/PasswordInput';
import TextInput from '../../field/input/TextInput';
import ServerConfiguration from './ServerConfiguration';

import { alignCenter, hidden, advancedWrapper, advanced } from '../../../css/main.css';
import { advancedLink } from '../../../css/server_config.css';

class EmailConfiguration extends ServerConfiguration {
	constructor(props) {
		super(props);
        this.handleAdvancedClicked = this.handleAdvancedClicked.bind(this);
	}

    handleAdvancedClicked(event){
		event.preventDefault();
		let advancedState = !this.state.advancedShown;
		this.setState({
			advancedShown : advancedState
		});
		return false;
	}

	render() {
        let advancedDisplay = "Show Advanced";
		let advancedClass = hidden;
		if (this.state.advancedShown) {
			advancedClass = "";
			advancedDisplay = "Hide Advanced";
		}
		let content =
				<div>
					<TextInput label="Mail Smtp Host" name="mailSmtpHost" value={this.state.values.mailSmtpHost} onChange={this.handleChange} errorName="mailSmtpHostError" errorValue={this.state.errors.mailSmtpHostError}></TextInput>
					<TextInput label="Mail Smtp From" name="mailSmtpFrom" value={this.state.values.mailSmtpFrom} onChange={this.handleChange} errorName="mailSmtpFromError" errorValue={this.state.errors.mailSmtpFromError}></TextInput>
					<CheckboxInput label="Mail Smtp Auth" name="mailSmtpAuth" value={this.state.values.mailSmtpAuth} onChange={this.handleChange} errorName="mailSmtpAuthError" errorValue={this.state.errors.mailSmtpAuthError}></CheckboxInput>
					<TextInput label="Mail Smtp User" name="mailSmtpUser" value={this.state.values.mailSmtpUser} onChange={this.handleChange} errorName="mailSmtpUserError" errorValue={this.state.errors.mailSmtpUserError}></TextInput>
					<PasswordInput label="Mail Smtp Password" name="mailSmtpPassword" value={this.state.values.mailSmtpPassword} isSet={this.state.values.mailSmtpPasswordIsSet} onChange={this.handleChange} errorName="mailSmtpPasswordError" errorValue={this.state.errors.mailSmtpPasswordError}></PasswordInput>
                    <div className={advancedLink}>
                        <a href="#" className={advanced} onClick={this.handleAdvancedClicked}>{advancedDisplay}</a>
                    </div>
                    <div className={advancedClass}>
                        <NumberInput label="Mail Smtp Port" name="mailSmtpPort" value={this.state.values.mailSmtpPort} onChange={this.handleChange} errorName="mailSmtpPortError" errorValue={this.state.errors.mailSmtpPortError}></NumberInput>
    					<NumberInput label="Mail Smtp Connection Timeout" name="mailSmtpConnectionTimeout" value={this.state.values.mailSmtpConnectionTimeout} onChange={this.handleChange} errorName="mailSmtpConnectionTimeoutError" errorValue={this.state.errors.mailSmtpConnectionTimeoutError}></NumberInput>
    					<NumberInput label="Mail Smtp Timeout" name="mailSmtpTimeout" value={this.state.values.mailSmtpTimeout} onChange={this.handleChange} errorName="mailSmtpTimeoutError" errorValue={this.state.errors.mailSmtpTimeoutError}></NumberInput>
    					<TextInput label="Mail Smtp Localhost" name="mailSmtpLocalhost" value={this.state.values.mailSmtpLocalhost} onChange={this.handleChange} errorName="mailSmtpLocalhostError" errorValue={this.state.errors.mailSmtpLocalhostError}></TextInput>
    					<CheckboxInput label="Mail Smtp Ehlo" name="mailSmtpEhlo" value={this.state.values.mailSmtpEhlo} onChange={this.handleChange} errorName="mailSmtpEhloError" errorValue={this.state.errors.mailSmtpEhloError}></CheckboxInput>
    					<TextInput label="Mail Smtp Dns Notify" name="mailSmtpDnsNotify" value={this.state.values.mailSmtpDnsNotify} onChange={this.handleChange} errorName="mailSmtpDnsNotifyError" errorValue={this.state.errors.mailSmtpDnsNotifyError}></TextInput>
    					<TextInput label="Mail Smtp Dns Ret" name="mailSmtpDnsRet" value={this.state.values.mailSmtpDnsRet} onChange={this.handleChange} errorName="mailSmtpDnsRetError" errorValue={this.state.errors.mailSmtpDnsRetError}></TextInput>
    					<CheckboxInput label="Mail Smtp Allow 8-bit Mime" name="mailSmtpAllow8bitmime" value={this.state.values.mailSmtpAllow8bitmime} onChange={this.handleChange} errorName="mailSmtpAllow8bitmimeError" errorValue={this.state.errors.mailSmtpAllow8bitmimeError}></CheckboxInput>
    					<CheckboxInput label="Mail Smtp Send Partial" name="mailSmtpSendPartial" value={this.state.values.mailSmtpSendPartial} onChange={this.handleChange} errorName="mailSmtpSendPartialError" errorValue={this.state.errors.mailSmtpSendPartialError}></CheckboxInput>
                    </div>
				</div>;
		return super.render(content);
	}
};

EmailConfiguration.propTypes = {
    headerText: PropTypes.string,
    configButtonTest: PropTypes.bool,
    configButtonsSave: PropTypes.bool,
    baseUrl: PropTypes.string,
    testUrl: PropTypes.string
};

EmailConfiguration.defaultProps = {
    headerText: 'Email Smtp Server Configuration',
    configButtonTest: false,
    baseUrl: '/api/configuration/global/email'
};

export default EmailConfiguration;
