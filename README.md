# tbone
Framework for building web clients using Java (based on TeaVM)

# Summary

TeaVM (http://www.teavm.org) empowers Java developers to write browser applications without using Applet.  
It's a powerful game changer that marries the richness of the Java ecosystem with the reach of web clients.  
The TBone library attempts to provide useful tools on top of TeaVM similar to how BackBone (http://backbonejs.org) 
gives structures to web applications, hence the name TBone.

# Installation

For the time being, please clone the repository and install it to your local maven repository.

```
mvn clean install
```

### A note on lambda expressions

Retrolambda (https://github.com/orfjackal/retrolambda) is needed to backport the Java 8 lambda expressions to Java 7.  It shall be installed automatically when you run maven.

# Usage

Follow TeaVM's guideline to build a new Maven project, then add the following dependency:

```
<dependency>
	<groupId>com.allstarcvs</groupId>
	<artifactId>tbone</artifactId>
	<version>0.0.1-SNAPSHOT</version>
</dependency>
```

You may also want to modify your pom.xml to use lambda.  See pom.xml in the example directory.

We have cherry-picked a handful of javascript libraries as a foundation.  Here's a sample bower.json file:

```
{
    "name": "cms",
    "version": "1.0.0-SNAPSHOT",
    "dependencies": {
        "page": "latest",
        "jquery": "latest",
        "sprintf": "latest",
        "semantic-ui": "latest"
    }
}
```

Finally, include the javascripts and stylesheets in index.html.

```
<!DOCTYPE html>
<html>
  <head>
    <title>Content Management System</title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">

    <script type="text/javascript" charset="utf-8" src="lib/sprintf/dist/sprintf.min.js"></script>
    <script type="text/javascript" charset="utf-8" src="lib/jquery/dist/jquery.min.js"></script>
    <script type="text/javascript" charset="utf-8" src="lib/semantic-ui/dist/semantic.min.js"></script>
    <script type="text/javascript" charset="utf-8" src="lib/page/page.js"></script>

    <script type="text/javascript" charset="utf-8" src="teavm/runtime.js"></script>
    <script type="text/javascript" charset="utf-8" src="teavm/classes.js"></script>

    <link rel="stylesheet" href="/lib/semantic-ui/dist/semantic.min.css" />

  </head>
  <body onload="main()"/>
</html>

```


Include Page.js (https://visionmedia.github.io/page.js/) to provide client-side routing.

