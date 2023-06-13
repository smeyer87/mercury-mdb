# Composable application example for MongoDB

The lambda-example-mdb demonstrates REST automation (lightweight non-blocking HTTP server) that allows you
to create REST endpoints by configuration instead of code.  The original project (lambda-example) has been extended to support an interface writing data to a MongoDB Atlas database configured by the user.

All of the original example code from the lambda-example are left in this project example as well -- the new objects are shown below with instructions for configuration.

## MongoDB Integration

This sample application is very simple to start and does only the following:

# Provide MongoDB Configuration Parameters
- Allows the application to specify MongoDB Atlas connections (user, password, and cluster identity) using a Configuration File:
-   The file should be formatted as a plain-text key-value pair including the following named attributes.  No quotation marks should be provided around the values.
-   MONGODB_USER=username
-   MONGODB_PASSWORD=password
-   MONGODB_CLUSTER_ID=URL.to.Atlas.instance  (example: cluster0.a1bcdef.mongodb.net )
-   DATA_DB=Atlasdatabasename
-   By default this file is configured to be named 'demo.properties' and placed in the path: C:/tmp/mongodemo (or just /tmp/mongodemo for Linux machines)
-   File path and name may be edited in the code.

MongoDB dependencies for the Java driver have been added to the Maven project POM for the example.

# Provide a single connection pool / database connection for use by the calling functions
- Within the MainApp you will see the public method used to retrieve the DB connection for use by other functions.  This method eliminates the requirement to code and manage database connections within each of the functions requiring database access.  Note that this assumes all functions have the same security and privileges against the database -- if this is not true for your application you will need to provide different connections for each of your use cases.

# Provide a sample REST endpoint configured to write the input Request Body into a specified MongoDB Collection
The REST endpoint connection is named /api/writemdbrecord and configured as described with the REST.YAML file associated at the Project level.

- Note that the Mercury platform converts the incoming HTTP Request Body into a Hashmap object.
- To convert back into a Document object for the MongoDB .InsertOne( ) method you will note a loop to convert all incoming fields from the hash map back into JSON elements and into the Document map.
- The simple example here does not attempt to check for an existing record of the same \_id value.  The intent with this operation is that the application knows the record should be inserted.  If a <null> response is received, the requested operation attempted to insert a value with an \_id equal to an existing record.
- With the project roadmap for this feature we will add separate methods for the .Upsert( ) operation to enable a more flexible 'Update else Insert' logic.
- Additional functionality will be added to the project over time, including event chaining and more complex examples.
