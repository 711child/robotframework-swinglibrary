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

package org.robotframework.swing.keyword.textcomponent;

import org.netbeans.jemmy.operators.ContainerOperator;
import org.robotframework.swing.chooser.ByNameComponentChooser;
import org.robotframework.swing.context.Context;
import org.robotframework.swing.factory.DefaultContextVerifyingOperatorFactory;
import org.robotframework.swing.textcomponent.TextComponentOperator;

/**
 * @author Heikki Hulkko
 */
public class TextComponentOperatorFactory extends DefaultContextVerifyingOperatorFactory<TextComponentOperator> {
    @Override
    public TextComponentOperator createOperatorByIndex(int index) {
        return new TextComponentOperator((ContainerOperator) Context.getContext(), index);
    }

    @Override
    public TextComponentOperator createOperatorByName(String name) {
        return new TextComponentOperator((ContainerOperator) Context.getContext(), new ByNameComponentChooser(name));
    }
}
