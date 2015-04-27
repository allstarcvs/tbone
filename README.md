# Summary

TeaVM (http://www.teavm.org) empowers Java developers to write browser applications without using Applet.  It's a powerful game changer that marries the richness of the Java ecosystem with the reach of web clients.  The TBone library attempts to provide useful tools on top of TeaVM similar to how BackBone (http://backbonejs.org) gives structures to web applications, hence the name TBone.

# Installation

For the time being, please clone the repository and install it to your local maven repository.

```
mvn clean install
```

### A note on lambda expressions

Retrolambda (https://github.com/orfjackal/retrolambda) is needed to backport the Java 8 lambda expressions to Java 7.  It shall be installed automatically when you run maven.

# Example Usage

See https://github.com/allstarcvs/tbone-example 
