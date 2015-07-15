### Release package and documentation ###

```
svn copy https://robotframework-swinglibrary.googlecode.com/svn/trunk \
https://robotframework-swinglibrary.googlecode.com/svn/tags/swinglibrary-$VERSION
svn checkout https://robotframework-swinglibrary.googlecode.com/svn/tags/swinglibrary-$VERSION

cd swinglibrary-$VERSION
sed -ie "s/\(VERSION_NUMBER\).*/\1 = '$VERSION'/" buildfile
svn commit -m "Updated version to $VERSION" buildfile
mkdir dist
buildr dist
cp target/swinglibrary-$VERSION.jar dist
cp core/target/swinglibrary-$VERSION-sources.zip dist
buildr dist -e legacy
cp target/swinglibrary-$VERSION-jre1.4.jar dist
buildr doc
svn add doc
svn propset svn:mime-type text/html doc/swinglibrary-$VERSION-doc.html
svn commit -m 'Added documentation.' doc
```

Then upload `dist` directory contents to http://code.google.com/p/robotframework-swinglibrary/downloads/list

### Release notes ###

Add release notes to ReleaseNotes, use [get\_issues.py](http://robotframework.googlecode.com/svn/wiki/tools/get_issues.py).

### Release mail ###

Send release mail to announce and users lists (public and NSN).

### Project Home ###

  * Update links.
  * Update news