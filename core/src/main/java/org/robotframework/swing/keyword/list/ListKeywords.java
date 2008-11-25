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

package org.robotframework.swing.keyword.list;

import org.netbeans.jemmy.operators.JListOperator;
import org.netbeans.jemmy.operators.JListOperator.ListItemChooser;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;
import org.robotframework.swing.arguments.VoidIdentifierHandler;
import org.robotframework.swing.factory.OperatorFactory;
import org.robotframework.swing.list.ListOperator;
import org.robotframework.swing.list.ListOperatorFactory;
import org.springframework.util.ObjectUtils;

/**
 * @author Heikki Hulkko
 */
@RobotKeywords
public class ListKeywords {
    private OperatorFactory<ListOperator> operatorFactory = new ListOperatorFactory();

    @RobotKeyword("Clears selection from list.\n\n"
        + "Example:\n"
        + "| Clear Selection From List | _myList_ |\n")
    public void clearSelectionFromList(String identifier) {
        operatorFactory.createOperator(identifier).clearSelection();
    }

    @RobotKeyword("Selects an item from the list.\n\n"
        + "Examples:\n"
        + "| Select From List | _myList_ | _myItem_ | # selects 'myItem'                   |\n"
        + "| Select From List | _myList_ | _0_      | # selects the first item in the list |\n")
    public void selectFromList(String identifier, String listItemIdentifier) {
        ListOperator listOperator = operatorFactory.createOperator(identifier);
        new ListSelector(listOperator).parseArgument(listItemIdentifier);
    }

    @RobotKeyword("Returns the item that's currently selected in the list.\n\n"
        + "Example:\n"
        + "| ${listItem}=    | Get Selected Value From List | _myList_      |\n"
        + "| Should Be Equal | _Expected Item_              | _${listItem}_ |\n")
    public Object getSelectedValueFromList(String identifier) {
        return operatorFactory.createOperator(identifier).getSelectedValue();
    }

    @RobotKeyword("Returns the number of items contained in list.\n\n"
        + "Example:\n"
        + "| ${listItemCount}=    | Get List Item Count | _myList_      |\n"
        + "| Should Be Equal As Integers | _2_ | _${listItemCount}_ |\n")
    public int getListItemCount(String identifier) {
        return operatorFactory.createOperator(identifier).getModel().getSize();
    }

    private static class ListSelector extends VoidIdentifierHandler {
        private final ListOperator listOperator;

        public ListSelector(ListOperator listOperator) {
            this.listOperator = listOperator;
        }

        @Override
        protected void handleIndexArgument(int index) {
            listOperator.selectItem(index);
        }

        @Override
        protected void handleNameArgument(final String name) {
            ListItemChooser itemChooser = new JListOperator.ListItemChooser() {
                public boolean checkItem(JListOperator operator, int index) {
                    String item = operator.getModel().getElementAt(index).toString();
                    return ObjectUtils.nullSafeEquals(name, item);
                }

                public String getDescription() {
                    return name;
                }
            };

            int itemIndex = listOperator.findItemIndex(itemChooser);
            listOperator.selectItem(itemIndex);
        }
    }
}
