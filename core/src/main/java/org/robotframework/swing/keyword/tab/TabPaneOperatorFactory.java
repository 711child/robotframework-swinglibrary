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

package org.robotframework.swing.keyword.tab;

import javax.swing.JTabbedPane;

import org.robotframework.swing.chooser.ByNameComponentChooser;
import org.robotframework.swing.context.Context;
import org.robotframework.swing.context.DefaultContextVerifier;
import org.robotframework.swing.context.IContextVerifier;
import org.robotframework.swing.factory.ContextBasedOperatorFactory;
import org.robotframework.swing.factory.IdentifierParsingOperatorFactory;
import org.robotframework.swing.operator.tab.MyTabbedPaneOperator;

/**
 * @author Heikki Hulkko
 */
public class TabPaneOperatorFactory extends IdentifierParsingOperatorFactory<MyTabbedPaneOperator> implements
    ContextBasedOperatorFactory<MyTabbedPaneOperator> {
    private IContextVerifier contextVerifier = new DefaultContextVerifier();

    @Override
    public MyTabbedPaneOperator createOperator(String identifier) {
        contextVerifier.verifyContext();
        return super.createOperator(identifier);
    }

    @Override
    public MyTabbedPaneOperator createOperatorByIndex(int index) {
        return new MyTabbedPaneOperator(Context.getContext(), index);
    }

    @Override
    public MyTabbedPaneOperator createOperatorByName(String name) {
        return new MyTabbedPaneOperator(Context.getContext(), new ByNameComponentChooser(name));
    }

    public MyTabbedPaneOperator createOperatorFromContext() {
        if (JTabbedPane.class.isAssignableFrom(Context.getContext().getSource().getClass())) {
            return new MyTabbedPaneOperator((JTabbedPane) Context.getContext().getSource());
        } else {
            contextVerifier.verifyContext();
            return new MyTabbedPaneOperator(Context.getContext());
        }
    }
}
