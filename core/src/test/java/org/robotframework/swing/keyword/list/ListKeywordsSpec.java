package org.robotframework.swing.keyword.list;

import javax.swing.ListModel;

import jdave.junit4.JDaveRunner;

import org.jmock.Expectations;
import org.junit.runner.RunWith;
import org.netbeans.jemmy.operators.JListOperator.ListItemChooser;
import org.robotframework.swing.contract.FieldIsNotNullContract;
import org.robotframework.swing.contract.RobotKeywordContract;
import org.robotframework.swing.contract.RobotKeywordsContract;
import org.robotframework.swing.factory.OperatorFactory;
import org.robotframework.swing.keyword.MockSupportSpecification;
import org.robotframework.swing.list.ListOperator;


@RunWith(JDaveRunner.class)
public class ListKeywordsSpec extends MockSupportSpecification<ListKeywords> {
    public class Any {
        public ListKeywords create() {
            return new ListKeywords();
        }

        public void isRobotKeywordsAnnotated() {
            specify(context, satisfies(new RobotKeywordsContract()));
        }

        public void hasOperatorFactory() throws Throwable {
            specify(context, satisfies(new FieldIsNotNullContract("operatorFactory")));
        }

        public void hasClearSelectionFromListKeyword() {
            specify(context, satisfies(new RobotKeywordContract("clearSelectionFromList")));
        }

        public void hasSelectFromListKeyword() {
            specify(context, satisfies(new RobotKeywordContract("selectFromList")));
        }

        public void hasGetSelectedValueFromListKeyword() {
            specify(context, satisfies(new RobotKeywordContract("getSelectedValueFromList")));
        }

        public void hasGetListItemCountKeyword() {
            specify(context, satisfies(new RobotKeywordContract("getListItemCount")));
        }
    }

    public class WhenOperating {
        private String listIdentifier = "someList";
        private OperatorFactory<?> operatorFactory;
        private ListOperator listOperator;

        public ListKeywords create() {
            ListKeywords listKeywords = new ListKeywords();
            operatorFactory = injectMockTo(listKeywords, OperatorFactory.class);
            listOperator = mock(ListOperator.class);

            checking(new Expectations() {{
                one(operatorFactory).createOperator(with(equal(listIdentifier)));
                will(returnValue(listOperator));
            }});

            return listKeywords;
        }

        public void clearsSelectionFromList() {
            checking(new Expectations() {{
                one(listOperator).clearSelection();
            }});

            context.clearSelectionFromList(listIdentifier);
        }

        public void selectsFromList() {
            final String numericIdentifier = "2";

            checking(new Expectations() {{
                one(operatorFactory).createOperator(listIdentifier);
                will(returnValue(listOperator));

                one(listOperator).findItemIndex(with(any(ListItemChooser.class)));
                will(returnValue(2));

                one(listOperator).clickOnItem(2, 1);
                one(listOperator).clickOnItem(Integer.parseInt(numericIdentifier), 1);
            }});

            context.selectFromList(listIdentifier, "someListItem", new String[0]);
            context.selectFromList(listIdentifier, numericIdentifier, new String[0]);
        }
        
        public void selectsFromListWithAlternativeClickCount() {
            checking(new Expectations() {{
                one(listOperator).clickOnItem(3, 2);
            }});
            
            context.selectFromList(listIdentifier, "3", new String[] { "2" });
        }

        public void getsSelectedValueFromList() {
            final String selectedValue = "someResult";

            checking(new Expectations() {{
                one(listOperator).getSelectedValue();
                will(returnValue(selectedValue));
            }});

            specify(context.getSelectedValueFromList(listIdentifier), must.equal(selectedValue));
        }

        public void getsListItemCount() {
            final ListModel listModel = mock(ListModel.class);
            checking(new Expectations() {{
                one(listOperator).getModel(); will(returnValue(listModel));
                one(listModel).getSize(); will(returnValue(4));
            }});

            specify(context.getListItemCount(listIdentifier), must.equal(4));
        }
    }
}
