/*
 * Copyright (c) 2002-2012 Alibaba Group Holding Limited.
 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.alibaba.test2.module.action.form.group;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.citrus.service.form.Group;
import com.alibaba.citrus.turbine.dataresolver.FormGroup;
import com.alibaba.test2.module.action.form.MyData;
import org.springframework.beans.factory.annotation.Autowired;

public class MyAction {
    @Autowired
    private HttpServletRequest request;

    public void doGetGroup(@FormGroup("myGroup1") Group group) {
        setAttribute(group);
    }

    public void doGetGroupDontSkipAction(@FormGroup(name = "myGroup1", skipIfInvalid = false) Group group) {
        setAttribute(group);
    }

    public void doGetGroupInstanceBean(@FormGroup(name = "myGroup1", instanceKey = "aaa") MyData data) {
        setAttribute(data);
    }

    public void doGetGroupInstanceBeanDontSkipAction(@FormGroup(name = "myGroup1", instanceKey = "aaa", skipIfInvalid = false) MyData data) {
        setAttribute(data);
    }

    private void setAttribute(Object data) {
        request.setAttribute("actionLog", data);
    }
}
