Args [![Build Status](https://travis-ci.com/wjur/args.svg?branch=master)](https://travis-ci.com/wjur/args) [![Coverage Status](https://coveralls.io/repos/github/wjur/args/badge.svg?branch=master)](https://coveralls.io/github/wjur/args?branch=master) [![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.wjur/args/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.wjur/args)
==========

Args is a groovy library to make map-based test builders safer.

The main disadvantage of map-based test builder is that they are typo-prone. When you pass
values as a map there is no validation and you never know whether a key you used is correct
or not. Args validates keys' names and assure that there are no typos.


Usage
-----

Add `Args` as dependency:

```
repositories {
    mavenCentral()
}

dependencies {
    compile 'io.github.wjur:args:0.1.0'
}
```

Use the Args class in your test builders:
```diff
class DomainObjectTestBuilder {
  private DomainObjectTestBuilder() {}

  private static final def defaults = [
    "id"       : "object-1",
    "size"     : 100,
    "createdAt": "2019-04-23"
]

static DomainObject domainObject(Map overrides = [:]) {
-  def args = defaults + overrides
+  def args = Args.args(defaults, overrides)
  return new DomainObject(
    args.id,
    args.size,
    DateTime.parse(args.createdAt)
  )
}
```


Licence
-------

MIT License

Copyright (c) 2018 Wojciech Jurczyk
