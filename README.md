Template project to test code that uses Accumulo.

[![Build Status](https://travis-ci.org/Stevens-GraphGroup/testAccMini.svg)](https://travis-ci.org/Stevens-GraphGroup/testAccMini)

[![Build Status](https://api.shippable.com/projects/54731877d46935d5fbbe6a1d/badge?branchName=master)](https://app.shippable.com/projects/54731877d46935d5fbbe6a1d/builds/latest)

`mvn package -DskipTests=true` to compile and build JARs. Tests:

* `mvn test -DTEST_ACCUMULO=mini` runs tests using [MiniAccumulo](https://accumulo.apache.org/1.6/accumulo_user_manual.html#_mini_accumulo_cluster).
* `mvn test -DTEST_ACCUMULO=local` uses a local Accumulo server.
* See `testing.ACCUMULO_TEST_CONFIG` to setup connections to other Accumulo clients for testing.

