# My First Radanalytics App - Scala with Scalatra
This application exposes a simple web service that servers (GET) requests that will use Apache Spark to rougly calculate the value of π. This code is based on the [Spark PI Example](https://github.com/apache/spark/blob/master/examples/src/main/scala/org/apache/spark/examples/SparkPi.scala) that is distributed with the Spark project. It is a tutorial application to show how to get started using Scala with the [Radanalytics platform](https://radanalytics.io), and is intended to be deployed to Openshift.

In addition to demonstrating how to deploy a simple Scala microservice to Openshift, it also contains examples of how to unit test Spark jobs using the [Spark Testing Base](https://github.com/holdenk/spark-testing-base) project.

## Quick start
It is a prerequesite that you have an Openshift cluster running and are logged in with the `oc` command line tool.

1. Setup the project and import the [Radanalytics](http://radanalytics.io) resources
   ```bash
   oc new-project oshinko
   oc create -f https://radanalytics.io/resources.yaml
   oc new-app oshinko-webui
   ```

2. Create an Apache Spark Cluster
    * Go to the Oshinko WebUI you installed on Openshift. From the Oshinko console, choose 'Deploy' and create an Apache Spark cluster named 'spark'

3. Deploy the Application
   ```bash
   oc new-app --template oshinko-scala-spark-build-dc \
    -p APPLICATION_NAME=tutorial-sparkpi-scala-scalatra \
    -p GIT_URI=https://github.com/reynoldsm88/tutorial-sparkpi-scala-scalatra \
    -p APP_MAIN_CLASS=io.radanalytics.examples.scalatra.sparkpi.Main \
    -p APP_FILE=tutorial-sparkpi-scala-scalatra-assembly-0.0.1-SNAPSHOT.jar \
    -p SBT_ARGS="clean assembly" \
    -p APP_ARGS="-Xms1024M, -Xmx2048M, -XX:MaxMetaspace=1024M" \
    -p OSHINKO_CLUSTER_NAME="spark"
   ```

4. Expose the Route
   ```bash
   oc expose svc/tutorial-sparkpi-scala-scalatra
   ```

5. Check that the service is running and can perform calculations
   ```bash
   URL="http://$(oc get route tutorial-sparkpi-scala-scalatra | grep tutorial-sparkpi-scala-scalatra | awk '{print $2}')/sparkpi"
   curl $URL
   ```
