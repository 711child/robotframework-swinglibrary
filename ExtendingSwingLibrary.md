

When creating your own custom keywords for your custom GUI components you have two choices:

1) You can create your own library and include your keywords in it. Your test will look like this:

| **Settings** | |
|:-------------|:|
| library      | SwingLibrary |
| library      | com.acme.MyLibrary |
|              | |
| **Test Case** | |
| My App Should Work Correctly | |
| # Using keywords from SwingLibrary and from com.acme.MyLibrary | |


2) **Or** you can extend SwingLibrary with your custom keywords. Then you need to import only one library in your test.


| **Settings** | |
|:-------------|:|
| library      | com.acme.SwingLibraryPlusMyCustomKeywords |
|              | |
| **Test Case** | |
| My App Should Work Correctly | |
| # Using custom keywords plus keywords from SwingLibrary  | |

<br>


<h1>How to extend SwingLibrary</h1>

It's easy just subclass <i>org.robotframework.swing.SwingLibrary</i> and pass your <a href='http://code.google.com/p/robotframework-javatools/wiki/AnnotationLibrary'>keyword pattern</a> to the superclass:<br>
<br>
<pre><code>package com.acme;<br>
<br>
import org.robotframework.swing.SwingLibrary;<br>
<br>
public class SwingLibraryPlusMyCustomKeywords extends SwingLibrary {<br>
    public SwingLibraryPlusMyCustomKeywords() {<br>
        super("com/some/own/keyword/*.class");<br>
    }<br>
}<br>
</code></pre>

Make sure that your keyword classes are inside <i>com.some.own.keyword</i> package and you are ready to use them as shown in the second example above.<br>
<br>
It is also possible to provide multiple keyword patterns if required:<br>
<br>
<pre><code>package com.acme;<br>
<br>
import org.robotframework.swing.SwingLibrary;<br>
import java.util.ArrayList;<br>
import java.util.List;<br>
<br>
public class SwingLibraryPlusMyCustomKeywords extends SwingLibrary {<br>
    private static List&lt;String&gt; PATTERNS = new ArrayList&lt;String&gt;() {{<br>
        add("com/some/own/keyword/*.class");<br>
        add("some/other/package/**/keyword/**/*.class");<br>
    }};<br>
<br>
    public SwingLibraryPlusMyCustomKeywords() {<br>
        super(PATTERNS);<br>
    }<br>
}<br>
</code></pre>

<h1>Creating Custom GUI Keywords</h1>

SwingLibrary uses <a href='https://jemmy.dev.java.net/'>jemmy</a> as it's internal driver. You should be aware of couple of concepts if you are creating your own keywords using jemmy.<br>
<br>
<h2>Operators</h2>

All the GUI operations are done through operators. They are responsible for finding the component under operation and for the method invocations going through the <a href='http://en.wikipedia.org/wiki/Event_dispatching_thread'>Event dispatching thread</a>.<br>
<br>
In jemmy you usually create your operator by providing the context from which the component is to be looked for and some kind of identifier for choosing the right component. This can be an index or a name. You can also provide a <i>chooser</i>, a class that does some additional checking for finding your component.<br>
<br>
<h2>Context</h2>

As mentioned above the operators need a context from which they try to find the component under operation. In SwingLibrary the context is set by using for example <a href='http://robotframework-swinglibrary.googlecode.com/svn/tags/swinglibrary-1.0/doc/swinglibrary-1.0-doc.html#Select%20Window'>Select Window</a> or <a href='http://robotframework-swinglibrary.googlecode.com/svn/tags/swinglibrary-1.0/doc/swinglibrary-1.0-doc.html#Select%20Dialog'>Select Dialog</a> keywords. Your keyword can access that context with <i>org.robotframework.swing.context.Context.getContext()</i>.<br>
<br>
<h2>Example</h2>

Creating "Disable Text Component" keyword:<br>
<br>
<pre><code>package com.some.own.keyword;<br>
<br>
import org.robotframework.javalib.annotation.RobotKeyword;<br>
import org.robotframework.javalib.annotation.RobotKeywords;<br>
import org.robotframework.javalib.annotation.ArgumentNames;<br>
import org.robotframework.swing.context.Context;<br>
<br>
import org.netbeans.jemmy.operators.JTextComponentOperator;<br>
import org.netbeans.jemmy.operators.ContainerOperator;<br>
<br>
@RobotKeywords<br>
public class MyKeywords {<br>
    @RobotKeyword("Disables the given textfield.\n")<br>
    @ArgumentNames({"textFieldName"})<br>
    public void disableTextComponent(String textFieldName) {<br>
        ContainerOperator context = (ContainerOperator) Context.getContext();<br>
        JTextComponentOperator operator = new JTextComponentOperator(context, textFieldName);<br>
        operator.setEnabled(false);<br>
    }<br>
}<br>
</code></pre>

<h2>TODO</h2>

Document custom operators for custom components.