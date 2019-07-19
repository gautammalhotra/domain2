package bootcamp

import grails.transaction.Transactional

class UtilController {
    def sessionFactory

    def index() {}


    def testConstraint() {
        Employee employee = new Employee(firstName: "gautam", lastName: "malhotra", email: "gautam.malhotra@rxlogix.com",
                password: "gautam")
        employee.validate()
        employee.errors.allErrors.each {
            println "Errors" + it
        }
        render employee.hasErrors()
    }

    def saveFlow() {
        Employee employee = new Employee(firstName: "gautam", lastName: "malhotra", email: "gautam.malhotra@rxlogix.com",
                password: "gautam123")
        render employee.save(flush: true)

    }

    def testVersion() {
        /*
        code for console
        import bootcamp.*;

def employee = Employee.get(1)
println employee.version
Thread.sleep(3000)
employee.firstName = "gautam12"
employee.save(flush:true,failOnError:true)
println employee.version
         */
        Employee employee = Employee.get(1)
        println employee.version
        employee.firstName = "Hello123456"
        employee.save(flush: true, failOnError: true)
        render employee.version
    }

    def showLazyWithSingleEnded() {
        /*
        def flight = Flight.get(3)
println flight.number
println flight.destination
         */
    }

    def showLazyFetching() {
        /*
        import bootcamp.*;

Airport airport = Airport.get(1)

airport.flights.each{Flight flight->
println flight.destination.city
}
         */
    }

    def testGetMethod() {
        Airport airport = Airport.get(1L)
        airport.name = "This is test..........."
        render airport.name

    }

    def messageTag() {
        Employee employee = new Employee(firstName: "gautam",password: 'test',confirmPassword: 'hello')
        if (employee.validate()) {
            employee.save()
            render "Saved object"
        } else {
            render "${employee.errors.allErrors.collect { message(error: it) }.join(',')}"
        }

    }

    def cascade(){
        /*
        import bootcamp.*;

Employee employee = Employee.get(1)
employee.addresses.add(Address.first())
employee.delete()
         */
    }

}
