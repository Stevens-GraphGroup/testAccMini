Template project to test code that uses Accumulo.

[![Build Status](https://travis-ci.org/denine99/AccumuloPlay.svg?branch=master)](https://travis-ci.org/denine99/AccumuloPlay)

[![Build Status](https://api.shippable.com/projects/54731877d46935d5fbbe6a1d/badge?branchName=master)](https://app.shippable.com/projects/54731877d46935d5fbbe6a1d/builds/latest)

`mvn package -DskipTests=true` to compile and build JARs. Tests:

* `mvn test -DTEST_CONFIG=mini` runs tests using [MiniAccumulo](https://accumulo.apache.org/1.6/accumulo_user_manual.html#_mini_accumulo_cluster).
* `mvn test -DTEST_CONFIG=local` uses a local Accumulo server.
* See `testing.TEST_CONFIG` to setup connections to other Accumulo clients for testing.

