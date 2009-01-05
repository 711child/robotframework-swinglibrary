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

package org.robotframework.swing.tab;

import javax.swing.JTabbedPane;

import org.netbeans.jemmy.operators.ContainerOperator;
import org.robotframework.swing.chooser.ByNameComponentChooser;
import org.robotframework.swing.context.Context;
import org.robotframework.swing.context.ContextVerifier;
import org.robotframework.swing.context.DefaultContextVerifier;
import org.robotframework.swing.factory.ContextBasedOperatorFactory;
import org.robotframework.swing.factory.IdentifierParsingOperatorFactory;

public class TabPaneOperatorFactory extends IdentifierParsingOperatorFactory<TabbedPaneOperator> implements
    ContextBasedOperatorFactory<TabbedPaneOperator> {
    private ContextVerifier contextVerifier = new DefaultContextVerifier();

    @Override
    public TabbedPaneOperator createOperator(String identifier) {
        contextVerifier.verifyContext();
        return super.createOperator(identifier);
    }

    @Override
    public TabbedPaneOperator createOperatorByIndex(int index) {
        return new TabbedPaneOperator((ContainerOperator) Context.getContext(), index);
    }

    @Override
    public TabbedPaneOperator createOperatorByName(String name) {
        return new TabbedPaneOperator((ContainerOperator) Context.getContext(), new ByNameComponentChooser(name));
    }

    public TabbedPaneOperator createOperatorFromContext() {
        if (JTabbedPane.class.isAssignableFrom(Context.getContext().getSource().getClass())) {
            return new TabbedPaneOperator((JTabbedPane) Context.getContext().getSource());
        } else {
            contextVerifier.verifyContext();
            return new TabbedPaneOperator((ContainerOperator) Context.getContext());
        }
    }
}
