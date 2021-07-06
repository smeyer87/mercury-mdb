/*

    Copyright 2018-2021 Accenture Technology

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

 */

package org.platformlambda.core.util;

import org.junit.Assert;
import org.junit.Test;
import org.platformlambda.cloud.ConnectorConfig;

import java.io.IOException;
import java.util.Map;

public class TopicSubstitutionTest {

    @Test
    public void substitution() throws IOException {
        Map<String, String> topicMap = ConnectorConfig.getTopicSubstitution();
        Assert.assertTrue(topicMap.containsKey("multiplex.0001.0"));
        Assert.assertEquals("user.topic.one", topicMap.get("multiplex.0001.0"));
    }
}