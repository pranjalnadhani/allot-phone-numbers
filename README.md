# AllotPhoneNumbers

An API to allot phone numbers.

## How to start the AllotPhoneNumbers application

1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/AllotPhoneNumbers-1.0.jar server config.yml`
1. To check that your application is running enter url `http://localhost:8080`

### APIs to obtain phone numbers
The API endpoint to generate phone numbers is:

**POST /api/allotnumber**
Request body:
````json
{
  "phone": 9876543210
}
````

P.S.: `phone` is an optional field. You can leave it blank to get the number automatically generated for you. If you want a custom number for yourself, specify it in the request body as shown. If the custom number would be available, it would be generated for you, otherwise, you will receive an automatically generated number.