

# How to get the Swing component identifier #

## Swing Explorer ##

The developers of the application provide meaningful identifiers/names for the Swing components, which then can be used in the keywords to locate and access the components. If the identifiers aren't provided, there's not much that can be done, besides trying to access the components by indexes. Sometimes the component identifiers are provided, but they are unknown and there's no one to ask about them. In these cases one can resort to indexes or try to sniff out the ids out using for example the [Swing Explorer](https://swingexplorer.dev.java.net/). "[Swing Explorer](https://swingexplorer.dev.java.net/) is a tool for Swing developers intended for visual exploring of a Swing-based application internals"

Download the [Swing Explorer](https://swingexplorer.dev.java.net/) and start your SUT using its Launcher (with the swexpl.jar also in the classpath):

```
java -cp swexpl.jar org.swingexplorer.Launcher <The SUTs Main Class>
```

For a quick trial, download the Download and extract the [SwingLibrary demo](http://robotframework-swinglibrary.googlecode.com/svn/wiki/swinglibrary-example.zip) and the [swexpl.jar](https://swingexplorer.dev.java.net/source/browse/*checkout*/swingexplorer/builds/1.0/swexpl.jar). Copy the swexpl.jar to the demo's lib directory and execute:

```
java -cp lib/swexpl.jar:lib/registration-0.1.jar org.swingexplorer.Launcher org.robotframework.registration.Main
```

The Registrartion demo app and Swing Explorer window should appear and the exploring of Swing application can be started.

For more information, please refer to the [Swing Explorer site](https://swingexplorer.dev.java.net).

## JSpy ##

JSpy is another handy tool for browsing the swing components http://code.google.com/p/robotframework-javatools/wiki/JSpy.