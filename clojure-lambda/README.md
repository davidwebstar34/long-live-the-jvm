# clojure-lambda
Java and Clojure project

### Based on
https://aws.amazon.com/blogs/compute/clojure/

lein uberjar

aws lambda create-function \
  --function-name clj-hellopojo \
  --handler PojoHandler::handlepojo \
  --runtime java8 \
  --memory 512 \
  --timeout 10 \
  --role arn:aws:iam::account:role/Role \
  --zip-file fileb://./target/clojure-lambda-0.1.0-SNAPSHOT-standalone.jar

### Good Reads

https://www.braveclojure.com/clojure-for-the-brave-and-true/
https://medium.com/@kari.marttila/using-clojure-to-implement-a-web-service-server-53f62dca964f
