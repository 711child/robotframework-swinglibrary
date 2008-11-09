package org.robotframework.swing.table;

import java.awt.Point;

import jdave.Block;
import jdave.Specification;
import jdave.junit4.JDaveRunner;

import org.jmock.Expectations;
import org.junit.runner.RunWith;
import org.netbeans.jemmy.operators.JTableOperator;
import org.netbeans.jemmy.operators.JTableOperator.TableCellChooser;

@RunWith(JDaveRunner.class)
public class DefaultTableOperatorSpec extends Specification<DefaultTableOperator> {
    public class HandlingErrorScenarios {
        private JTableOperator jTableOperator;

		public DefaultTableOperator create() {
            jTableOperator = mock(JTableOperator.class);
			return new DefaultTableOperator(jTableOperator);
        }

        public void findingNonexistentCellFails() {
        	checking(new Expectations() {{
        		one(jTableOperator).findCell(with(any(TableCellChooser.class))); will(returnValue(new Point(-1, -1)));
        	}});
        	
            specify(new Block() {
                public void run() throws Throwable {
                    context.selectCell("12", "nonexisting");
                }
            }, should.raise(InvalidCellException.class));
        }
    }
}
