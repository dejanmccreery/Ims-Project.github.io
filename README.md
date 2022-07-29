Coverage: 34%
# Inventory Management Project

Project designed to implement CRUD functionality within an application which utilises SQL database and jabva to build a user ordering system program that runs within the command line.

## Getting Started

First: Make sure to change the db.properties to match your local machines name/password. Second: Run the Schema.sql to setup the ims schema and create tables within your local SQL.

### Prerequisites

Before you begin you should start by installing the following:

```
Java - 1.8 or higher
Eclipse IDE
Maven
```

### Installing

First start by installing your JDK

The below link will guide you from start to finish for installing a JDK:

```
https://www.youtube.com/watch?v=cRgLuNWCq6c
```

Eclipse IDE Installation video link below:

```
https://www.youtube.com/watch?v=h7dR_9RcnY8
```
Maven installation video link below:

```
https://www.youtube.com/watch?v=km3tLti4TCM
```

End with an example of getting some data out of the system or using it for a little demo

## Running the tests

Explain how to run the automated tests for this system. Break down into which tests and what they do

### Unit Tests 

Running unit tests alwow us to isolate specific part of code and test them independently from the rest of the project. This allows us to pick up on specific areas that cause errors and can prevent major issues in the future.

```
  @Test
	public void testCreate() {
		final String F_NAME = "barry", L_NAME = "scott";
		final Customer created = new Customer(F_NAME, L_NAME);

		Mockito.when(utils.getString()).thenReturn(F_NAME, L_NAME);
		Mockito.when(dao.create(created)).thenReturn(created);

		assertEquals(created, controller.create());

		Mockito.verify(utils, Mockito.times(2)).getString();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	}
```
This code tests the create method for Customer.

### Integration Tests 
Integration tests determine if independently developed units of software work correctly when they are connected to each other.


## Deployment

Make sure your build path is set correctly and your database passwords are up to date. 

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)
* **Justin Graham** - *My Version* - [JustaGlitch](https://github.com/JustaGlitch)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 


## Acknowledgments

* Unfathomable amount of youtube videos
* Specifically useful youtube channel along project https://www.youtube.com/c/programmingwithmosh
