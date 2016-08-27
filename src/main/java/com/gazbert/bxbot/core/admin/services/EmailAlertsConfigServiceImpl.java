/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 Gareth Jon Lynch
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.gazbert.bxbot.core.admin.services;

import com.gazbert.bxbot.core.admin.repository.EmailAlertsConfigRepository;
import com.gazbert.bxbot.core.config.emailalerts.EmailAlertsConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * Implementation of the Email Alerts configuration service.
 *
 * @author gazbert
 * @since 11/08/2016
 */
@Service("emailAlertsConfigService")
@Transactional
public class EmailAlertsConfigServiceImpl implements EmailAlertsConfigService {

    private static final Logger LOG = LogManager.getLogger();

    private final EmailAlertsConfigRepository emailAlertsConfigRepository;

    @Autowired
    public EmailAlertsConfigServiceImpl(EmailAlertsConfigRepository emailAlertsConfigRepository) {
        Assert.notNull(emailAlertsConfigRepository, "emailAlertsConfigRepository dependency cannot be null!");
        this.emailAlertsConfigRepository = emailAlertsConfigRepository;
    }

    @Override
    public EmailAlertsConfig getConfig() {
        return emailAlertsConfigRepository.getConfig();
    }

    @Override
    public void updateConfig(EmailAlertsConfig config) {
        LOG.info(() -> "About to update: " + config);
        emailAlertsConfigRepository.updateConfig(config);
    }
}
