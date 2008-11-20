/*
 * Copyright 2008 Nokia Siemens Networks Oyj
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.robotframework.swing.keyword.label;

import org.netbeans.jemmy.operators.ContainerOperator;
import org.robotframework.swing.chooser.ByNameComponentChooser;
import org.robotframework.swing.context.Context;
import org.robotframework.swing.factory.IdentifierParsingOperatorFactory;
import org.robotframework.swing.operator.label.DefaultLabelOperator;

/**
 * @author Heikki Hulkko
 */
public class LabelOperatorFactory extends IdentifierParsingOperatorFactory<DefaultLabelOperator> {
    public DefaultLabelOperator createOperatorByIndex(int index) {
        return new DefaultLabelOperator((ContainerOperator) Context.getContext(), index);
    }

    public DefaultLabelOperator createOperatorByName(String name) {
        return new DefaultLabelOperator((ContainerOperator) Context.getContext(), new ByNameComponentChooser(name));
    }
}
