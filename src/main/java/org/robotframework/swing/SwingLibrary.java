/*
 * Copyright 2008-2011 Nokia Siemens Networks Oyj
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
package org.robotframework.swing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.netbeans.jemmy.JemmyProperties;
import org.netbeans.jemmy.TestOut;
import org.robotframework.javalib.library.AnnotationLibrary;
import org.robotframework.swing.keyword.timeout.TimeoutKeywords;

public class SwingLibrary extends AnnotationLibrary {
    public static final String ROBOT_LIBRARY_SCOPE = "GLOBAL";
    public static SwingLibrary instance;
    private final AnnotationLibrary annotationLibrary = new AnnotationLibrary("org/robotframework/swing/keyword/**/*.class");
    private static final String LIBRARY_DOCUMENTATION =
            "SwingLibrary is a Robot Framework test library for testing Java Swing user interfaces.\n\n" +
            "It uses a tool called Jemmy (http://java.net/projects/jemmy/) internally to operate on Swing components.\n\n" +
            "*Getting Started*\n\n" +
            "First, the SwingLibrary needs to be taken into use in the settings table:\n" +
            "| *Settings * | *Value* |\n" +
            "| Library | SwingLibrary |\n\n" +

            "The tested application can be started with keyword `Start Application`, using the name " +
            "of the main application class as an argument:\n" +
            "| *Action* | *Argument* |\n"+
            "| Start Application | com.acme.TheApplication |\n\n" +
            "When the tests are executed, both the SwingLibrary and the application and all its dependencies " +
            "need to be available in the CLASSPATH. Robot Framework needs to be started with `jybot` start script "+
            "when using the SwingLibrary, for example like this:\n\n" +
            "`CLASSPATH=swinglibrary-1.1.3.jar:myApp.jar jybot my_test.txt`\n\n" +
            "*Contexts*\n\n" +
            "Keywords that operate on a component always search for the component in some context, which has to explicitly set. " +
            "Typical contexts are windows, dialogs and tabbed panes. For example, to choose a frame whose title is 'My App' as context, use:\n\n" +
            "| Select Window | My App |\n\n" +
            "After `Select Window` has been used, all subsequent keyword use the selected window as context until a new context is selected.\n\n" +

            "*Locating components*\n\n  " +
            "Most of the keywords that operate on a visible component take an argument named `identifier`, " +
            "which is used to locate the element. The first matching element is operated on, according to these rules: \n\n" +
            "1. if the `identifier` is a number, it is used as a zero-based index for the particular component type in the current context. " +
            "Using indices is, however, fragile and is strongly discouraged\n" +
            "2. if the `identifier` matches to internal name of a component (set using `setName` method in Java code), that component is chosen.\n" +
            "3. for components that have visible text (e.g. buttons), `identifier` is also matched against that.\n\n" +
            "Keyword `List Components in Context` lists all components and their names and indices in a given context.";


    public SwingLibrary() {
        this(Collections.<String>emptyList());
    }

    protected SwingLibrary(final String keywordPattern) {
        this(new ArrayList<String>() {{ add(keywordPattern); }});
    }

    protected SwingLibrary(Collection<String>  keywordPatterns) {
        addKeywordPatterns(keywordPatterns);
        disableOutput();
        setDefaultTimeouts();
        instance = this;
    }

    private void addKeywordPatterns(Collection<String> keywordPatterns) {
        for (String pattern : keywordPatterns) {
            annotationLibrary.addKeywordPattern(pattern);
        }
    }

    public Object runKeyword(String keywordName, Object[] args) {
        return annotationLibrary.runKeyword(keywordName, toStrings(args));
    }

    public String[] getKeywordArguments(String keywordName) {
        return annotationLibrary.getKeywordArguments(keywordName);
    }

    public String getKeywordDocumentation(String keywordName) {
        if (keywordName.equals("__intro__"))
            return LIBRARY_DOCUMENTATION;
        return annotationLibrary.getKeywordDocumentation(keywordName);
    }

    public String[] getKeywordNames() {
        return annotationLibrary.getKeywordNames();
    }

    private void setDefaultTimeouts() {
        new TimeoutKeywords().setJemmyTimeouts("10");
    }

    private void disableOutput() {
        JemmyProperties.setCurrentOutput(TestOut.getNullOutput());
    }

    private Object[] toStrings(Object[] args) {
        Object[] newArgs = new Object[args.length];
        for (int i = 0; i < newArgs.length; i++) {
            if (args[i].getClass().isArray()) {
                newArgs[i] = args[i];
            } else {
                newArgs[i] = args[i].toString();
            }
        }
        return newArgs;
    }
}
